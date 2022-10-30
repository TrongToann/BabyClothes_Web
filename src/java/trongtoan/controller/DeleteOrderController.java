/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import trongtoan.entity.Order;


/**
 *
 * @author DELL
 */
public class DeleteOrderController extends HttpServlet {

    private static final String ERROR = "error.jsp" ; 
    private static final String SUCCESS = "updateOrder.jsp" ;  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR ; 
        try {
            HttpSession session = request.getSession() ; 
            List<Order> list = new ArrayList() ;
            List<Order> list2 = new ArrayList() ;
            String orderID = request.getParameter("orderID") ; 
            DAO dao = new DAO() ; 
            boolean deleteProduct = dao.deleteOrder(orderID) ; 
            if(deleteProduct) {
                list = dao.getAllOrder(); 
                list2 = dao.getAllOrderDetail() ;
                session.setAttribute("listOrder", list);
                session.setAttribute("listOrderDetail", list2);
                url = SUCCESS ; 
            }else if(deleteProduct == false) {
                url = SUCCESS ; 
                request.setAttribute("ERROR", "Không Thể Xóa Sản Phẩm Do Có Đơn Hàng Đang Đặt");
            }   
        } catch (SQLException e) {
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
