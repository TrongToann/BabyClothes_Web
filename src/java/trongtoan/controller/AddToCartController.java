package trongtoan.controller;

import java.io.IOException;
import java.sql.SQLException;
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
import trongtoan.entity.Cart;
import trongtoan.entity.Category;
import trongtoan.entity.Product;

public class AddToCartController extends HttpServlet {

    private static final String SUCCESS = "detail.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {
            Product tea;
            int total = 0;
            String id = request.getParameter("pid");
            HttpSession session = request.getSession();

            DAO dao = new DAO();
            Product product = dao.getProductByID(id);
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            tea = new Product(product.getId(), product.getName(), product.getImage(), product.getPrice(), product.getTitle(), product.getDescription(), quantity);

            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
                cart = new Cart();
            }
            cart.add(tea);

            List<Category> listCC = dao.getAllCategory();
            Product p1 = dao.getLasted();
            Product p = dao.getProductByID(id);
            session.setAttribute("CART", cart);
            request.setAttribute("listCC", listCC);
            request.setAttribute("lastProduct", p1);
            request.setAttribute("detail", p);
            url = SUCCESS;

        } catch (NumberFormatException | SQLException e) {
            log("ERORR at AddToCartController" + e.toString());

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
        } catch (NamingException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
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
