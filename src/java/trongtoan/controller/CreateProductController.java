
package trongtoan.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongtoan.dao.DAO;
import trongtoan.entity.Product;
import trongtoan.entity.TrongToan;
import trongtoan.entity.UserError;


public class CreateProductController extends HttpServlet {

    private static final String ERROR = "createProduct.jsp";
    private static final String SUCCESS = "updateProduct.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            DAO dao = new DAO();
            HttpSession session = request.getSession();
            String name = request.getParameter("name");
            String image = request.getParameter("image");
            String title = request.getParameter("title");
            double price = Double.parseDouble(request.getParameter("price")) ;
            String description = request.getParameter("description");
            String cateID = request.getParameter("cateID");
            UserError userError = new UserError();
            boolean checkValidation = true;
            if (name.length() > 50 || name.length() < 8) {
                userError.setUserIDError("Length must be in [8 - 50 ]");
                checkValidation = false;
            }
            if (title.length() > 50 || title.length() < 8) {
                userError.setFullNameError("Length must be in [8 - 50 ]");
                checkValidation = false;
            }
            if (price < 0) {
                userError.setRoldeIDError("Price must be positive");
                checkValidation = false;
            }
            
            if (checkValidation) {
                Product p1 = new Product(TrongToan.pID(), name, image, price, title, Integer.parseInt(cateID), description);
                boolean createProduct = dao.createProduct(p1);
                if (createProduct) {
                    List<Product> list = dao.getAllProduct();
                    session.setAttribute("listP", list);
                    url = SUCCESS;
                }
            } else {
                session.setAttribute("PRODUCT_ERROR", userError);
            }

        } catch (NumberFormatException | SQLException e) {
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
