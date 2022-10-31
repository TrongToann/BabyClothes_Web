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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongtoan.dao.DAO;
import trongtoan.entity.UserDTO;

/**
 *
 * @author DELL
 */
public class UpdateAccountController extends HttpServlet {

    private static final String ERROR = "error.jsp" ; 
    private static final String SUCCESS = "updateAccount.jsp" ; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR ; 
        try {
            DAO dao = new DAO() ; 
            HttpSession session = request.getSession() ; 
            List<UserDTO> list = new ArrayList() ;
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            String rid = request.getParameter("rid").trim() ; 
            String id = request.getParameter("id").trim()  ; 
            String name = request.getParameter("name").trim()  ;
            String fullName = request.getParameter("fullName") ; 
            String role = request.getParameter("role").trim()  ; 
            UserDTO user = new UserDTO(rid, id, fullName, role, name) ;
            boolean check = dao.updateAccount(user) ; 
            if(loginUser.getrID().equals(rid)) {
                loginUser.setRoleID(role);
                loginUser.setFullName(fullName);
                loginUser.setPassword(name);
                
            }
            if(check) {
                list = dao.getAllAccount() ;
                session.setAttribute("listA", list);
                url = SUCCESS ; 
                session.setAttribute("LOGIN_USER", loginUser); 
            } 
        } catch (SQLException e) {
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
            Logger.getLogger(UpdateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateAccountController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateAccountController.class.getName()).log(Level.SEVERE, null, ex);
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
