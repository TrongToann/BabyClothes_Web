package trongtoan.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trongtoan.dao.DAO;
import trongtoan.entity.Category;
import trongtoan.entity.Product;

public class SearchController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "newjsp.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String txtSearch = request.getParameter("txt");
            DAO dao = new DAO();
            List<Product> list = dao.searchByName(txtSearch);
            List<Category> listCC = dao.getAllCategory();
            Product p1 = dao.getLasted();
            if (!list.isEmpty() && !listCC.isEmpty() && p1 != null) {
                url = SUCCESS ; 
            }else {
                url = SUCCESS ; 
                request.setAttribute("ERROR_SEARCH", "Opps!The Binzi. Không Phục Vụ Sản Phẩm Trên...");
            }
            request.setAttribute("listP", list);
            request.setAttribute("listCC", listCC);
            request.setAttribute("lastProduct", p1);
            request.setAttribute("txtSearch", txtSearch);
        } catch (SQLException e) {
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
