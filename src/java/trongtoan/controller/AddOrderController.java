
package trongtoan.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongtoan.dao.DAO;
import trongtoan.entity.Cart;
import trongtoan.entity.Product;
import trongtoan.entity.TrongToan;
import trongtoan.entity.UserDTO;

public class AddOrderController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String orderID = null;
            String total = request.getParameter("total").trim();
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            DAO dao = new DAO();
            UserDTO userLogin = (UserDTO) session.getAttribute("LOGIN_USER");
            orderID = TrongToan.oID() ;
            boolean insertOrder = dao.insertOrder(TrongToan.oID(), userLogin.getrID(), total, java.sql.Date.valueOf(java.time.LocalDate.now()) );
            for (Product detail : cart.getCart().values()) {
                dao.insertOrderDetail(TrongToan.dID(), orderID, detail.getId(), detail.getPrice(), detail.getQuantity());
                int newQuantity = dao.getQuantity(detail.getId()) - detail.getQuantity();
                Product p1 = new Product(detail.getId(),
                        detail.getName(), detail.getImage(), detail.getPrice(),
                        detail.getTitle(), detail.getDescription(), newQuantity, detail.getCateID());
                dao.updateProduct(p1);
            }
            if (insertOrder) {
                url = SUCCESS;
                session.setAttribute("CART", null);
            }
         
            TrongToan.sendEmail(request, response);

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
