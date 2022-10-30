package trongtoan.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongtoan.dao.DAO;
import trongtoan.entity.TrongToan;
import trongtoan.entity.UserDTO;
import trongtoan.entity.UserError;

public class CreateAccountController extends HttpServlet {

    private static final String ERROR = "createAccount.jsp";
    private static final String SUCCESS = "updateAccount.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserError userError = new UserError();
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            List<UserDTO> list = new ArrayList();
            DAO dao = new DAO();
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            boolean checkValidation = true;
            int checkdup = -1;
            if (userID.length() > 10 || userID.length() < 3) {
                userError.setUserIDError("Length must be in [3 - 10 ]");
                checkValidation = false;
            }
            checkdup = dao.checkDuplicate(userID);
            if (checkdup == 1) {
                userError.setUserIDError("User ID has been in used!!");
                checkValidation = false;
            }
            if (fullName.length() > 50 || fullName.length() < 2) {
                userError.setFullNameError("Length must be [2 - 50]");
                checkValidation = false;
            }
            if (!password.equals(confirm)) {
                userError.setConfirmError("Conflict of two password");
                checkValidation = false;
            }
            if (checkValidation) {
                UserDTO user = new UserDTO(TrongToan.aID(roleID), userID, fullName, roleID, password);
                boolean checkCreate = dao.addAccount(user);
                if (checkCreate) {
                    list = dao.getAllAccount();
                    session.setAttribute("listA", list);
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (SQLException e) {
            log("Error at CreateController" + e.toString());
            if (e.toString().contains("duplicate")) {
                userError.setUserIDError("Two Password Conflict");
                request.setAttribute("USER_ERROR", userError);
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
