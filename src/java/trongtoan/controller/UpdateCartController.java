/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongtoan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongtoan.entity.Cart;
import trongtoan.entity.Product;

/**
 *
 * @author DELL
 */
public class UpdateCartController extends HttpServlet {

    private static final String ERROR = "error.jsp" ; 
    private static final String SUCCESS = "viewCart.jsp" ; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR ; 
        try {
            Product p1 = new Product() ;
            HttpSession session = request.getSession() ; 
            Cart cart = (Cart) session.getAttribute("CART") ; 
            String id = request.getParameter("id")  ; 
            int quantity = Integer.parseInt(request.getParameter("quantity")) ; 
            for (Product object : cart.getCart().values()) {
                
                if( id.equals(object.getId()) ) {
                     p1 = new Product(object.getId(), object.getName(), object.getImage(), object.getPrice(), object.getTitle(),object.getDescription() , quantity) ; 
                }
            }
            cart.update(id, p1); 
            session.setAttribute("CART", cart);
            url = SUCCESS ;
        } catch (NumberFormatException e) {
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
