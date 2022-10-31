
package trongtoan.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongtoan.dao.DAO;
import trongtoan.entity.Product;


public class UpdateProductController extends HttpServlet {

    private static final String ERROR = "error.jsp" ; 
    private static final String SUCCESS = "updateProduct.jsp" ; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR ; 
        try {
            DAO dao = new DAO() ; 
            HttpSession session = request.getSession() ; 
            List<Product> list = new ArrayList() ;
            String id = request.getParameter("id").trim()  ; 
            String name = request.getParameter("name").trim() ; 
            String price = request.getParameter("price").trim()  ; 
            String title = request.getParameter("title") ; 
            int quantity = Integer.parseInt( request.getParameter("quantity").trim()  );   
            Product p1 = new Product(id, name, Double.parseDouble(price), title, quantity) ;  
            boolean check = dao.updateProduct(p1) ; 
            if(check) {
                list = dao.getAllProduct() ;
                session.setAttribute("listP", list);
                url = SUCCESS ; 
            } 
        } catch (NumberFormatException | SQLException e) {
            log("Error at UpdateProduct Controller" + e.toString());
        }finally {
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
        } catch (NamingException ex) {
            Logger.getLogger(UpdateProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProductController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NamingException ex) {
            Logger.getLogger(UpdateProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProductController.class.getName()).log(Level.SEVERE, null, ex);
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
