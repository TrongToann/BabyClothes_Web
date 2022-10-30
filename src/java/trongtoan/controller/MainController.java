package trongtoan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainController extends HttpServlet {
    //ACTION
    private static final String ERROR = "error.jsp" ; 
    private static final String LOGIN = "Login" ;  
    private static final String SEARCH = "Search" ;    
    private static final String SEARCH_ACCOUNT = "SearchAccount" ;    
    private static final String SEARCH_PRODUCT_UPDATE = "SearchUpdateProduct" ;    
    private static final String DETAIL = "Detail" ;  
    private static final String CATEGORY = "Category" ;  
    private static final String CART = "Add To Cart" ;  
    private static final String ADD_ORDER = "proceed to checkout" ;  
    private static final String CHECK_OUT = "CheckOut" ;  
    private static final String UPDATE_PRODUCT = "updateProduct" ;  
    private static final String UPDATE_ACCOUNT = "updateAccount" ;  
    private static final String UPDATE_CART = "updateCart" ;   
    private static final String DELETE_PRODUCT = "deleteProduct" ;   
    private static final String DELETE_CART = "deleteCart" ;   
    private static final String DELETE_ACCOUNT = "deleteAccount" ;   
    private static final String DELETE_ORDER = "deleteOrder" ;   
    private static final String CREATE_PRODUCT = "createProduct" ;   
    private static final String CREATE_ACCOUNT = "createAccount" ;   
    private static final String TURR_TO_ADMIN = "AdminHome" ;   
    private static final String TURR_TO_SELLER = "orderMain" ;   
    private static final String TURR_TO_SELLER_LIST = "orderMainMain" ;   
    private static final String LOGOUT = "Logout" ;   
    //CONTROLLER
    private static final String LOGIN_CONTROLLER = "LoginController" ;        
    private static final String SEARCH_CONTROLLER = "SearchController" ;      
    private static final String SEARCH_ACCOUNT_CONTROLLER = "SearchForUpdateAccount" ;      
    private static final String SEARCH_PRODUCT_UPDATE_CONTROLLER = "SearchForUpdateProduct" ;      
    private static final String DETAIL_CONTROLLER = "DetailController" ;    
    private static final String CATEGORY_CONTROLLER = "CategoryController" ;    
    private static final String ADD_TO_CART = "AddToCartController" ;     
    private static final String ADD_ORDER_CONTROLLER = "AddOrderController" ;      
    private static final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController" ;      
    private static final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountController" ;      
    private static final String DELETE_PRODUCT_CONTROLLER = "DeleteProductController" ;      
    private static final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountController" ;      
    private static final String CREATE_PRODUCT_CONTROLLER = "CreateProductController" ;      
    private static final String CREATE_ACCOUNT_CONTROLLER = "CreateAccountController" ;      
    private static final String DELETE_CART_CONTROLLER = "DeleteCartController" ;      
    private static final String UPDATE_CART_CONTROLLER = "UpdateCartController" ;      
    private static final String DELETE_ORDER_CONTROLLER = "DeleteOrderController" ;      
    private static final String LOGOUT_CONTROLLER = "LogOutController" ;      
    private static final String CHECKOUT_CONTROLLER = "CheckOutController" ;    
    private static final String TURR_TO_ADMIN_CONTROLLER = "AdminHomeController" ;   
    private static final String TURR_TO_SELLER_CONTROLLER = "SellHomeController" ;   
    private static final String TURR_TO_SELLER_LIST_CONTROLLER = "sellerPage.jsp" ;   
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR ; 
        try {
            String action = request.getParameter("action") ; 
            if(LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER ;
            }else if(SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER ;
            }else if(CATEGORY.equals(action)) {
                url = CATEGORY_CONTROLLER; 
            }else if(DETAIL.equals(action)) {
                url = DETAIL_CONTROLLER; 
            }else if(CART.equals(action)) {
                url = ADD_TO_CART; 
            }else if(ADD_ORDER.equals(action)) {
                url = ADD_ORDER_CONTROLLER; 
            }else if(UPDATE_PRODUCT.equals(action)) {
                url = UPDATE_PRODUCT_CONTROLLER; 
            }else if(DELETE_PRODUCT.equals(action)) {
                url = DELETE_PRODUCT_CONTROLLER;  
            }else if(CREATE_PRODUCT.equals(action)) {
                url = CREATE_PRODUCT_CONTROLLER;   
            }else if(UPDATE_CART.equals(action)) {
                url = UPDATE_CART_CONTROLLER;   
            }else if(DELETE_CART.equals(action)) {
                url = DELETE_CART_CONTROLLER ;    
            }else if(UPDATE_ACCOUNT.equals(action)) {
                url = UPDATE_ACCOUNT_CONTROLLER ;    
            }else if(DELETE_ACCOUNT.equals(action)) {
                url = DELETE_ACCOUNT_CONTROLLER ;    
            }else if(DELETE_ORDER.equals(action)) {
                url = DELETE_ORDER_CONTROLLER ;    
            }else if(LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER ;    
            }else if(CHECK_OUT.equals(action)) {
                url = CHECKOUT_CONTROLLER ;    
            }else if(CREATE_ACCOUNT.equals(action)) {
                url = CREATE_ACCOUNT_CONTROLLER ;    
            }else if(SEARCH_ACCOUNT.equals(action)) {
                url = SEARCH_ACCOUNT_CONTROLLER ;    
            }else if(SEARCH_PRODUCT_UPDATE.equals(action)) {
                url = SEARCH_PRODUCT_UPDATE_CONTROLLER ;    
            }else if(TURR_TO_ADMIN.equals(action)) {
                url = TURR_TO_ADMIN_CONTROLLER ;    
            }else if(TURR_TO_SELLER.equals(action)) {
                url = TURR_TO_SELLER_CONTROLLER ;    
            }else if(TURR_TO_SELLER_LIST.equals(action)) {
                url = TURR_TO_SELLER_LIST_CONTROLLER ;    
            }
            
        } catch (Exception e) {
            log("ERROR AT MAINCONTROLLER" + e.toString());
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
