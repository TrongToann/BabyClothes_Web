/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongtoan.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trongtoan.entity.UserDTO;

/**
 *
 * @author DELL
 */
public class AuthenFilter implements Filter {
    private static List<String> USER_RESOURCE ;      // hằng số phải khởi tạo giá trị
    private static List<String> ADMIN_RESOURCE ;
    private static List<String> SELLER_RESOURCE ;
    private static List<String> NON_AUTHEN_RESOURCE ;
    private static final String US = "US" ;
    private static final String AD = "AD" ; 
    private static final String SEL = "SEL" ; 
    private static final String LOGIN_PAGE = "login.jsp" ; 
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public AuthenFilter() {
        // các tài nguyên mà quyền US được phép truy cấp
        USER_RESOURCE = new ArrayList<>() ; 
        USER_RESOURCE.add("newjsp.jsp") ;     
        USER_RESOURCE.add("checkout.jsp") ;     
        USER_RESOURCE.add("detail.jsp") ;     
        USER_RESOURCE.add("viewCart.jsp") ;     
        USER_RESOURCE.add("HomeController") ;     
        // các tài nguyên mà quyền AD được phép truy cập 
        ADMIN_RESOURCE = new ArrayList<>() ;  
        ADMIN_RESOURCE.add("adminPage.jsp") ;  
        ADMIN_RESOURCE.add("userPage.jsp") ;  
        ADMIN_RESOURCE.add("updateAccount.jsp") ;  
        ADMIN_RESOURCE.add("createProduct.jsp") ;  
        ADMIN_RESOURCE.add("updateProduct.jsp") ; 
        ADMIN_RESOURCE.add("createAccount.jsp") ; 
        
        SELLER_RESOURCE = new ArrayList<>() ; 
        SELLER_RESOURCE.add("sellerPage.jsp") ; 
        SELLER_RESOURCE.add("orderDetail.jsp") ; 
        SELLER_RESOURCE.add("updateOrder.jsp") ; 
        
        //các tài nguyên mà truy cập tự do không cần xác thực hay phân quyền
        NON_AUTHEN_RESOURCE = new ArrayList<>() ; 
        NON_AUTHEN_RESOURCE.add("login.jsp") ; 
        NON_AUTHEN_RESOURCE.add("MainController")  ;  
        NON_AUTHEN_RESOURCE.add(".jpg")  ;   
        NON_AUTHEN_RESOURCE.add(".png")  ;    
        NON_AUTHEN_RESOURCE.add(".gif")  ;     
        NON_AUTHEN_RESOURCE.add("homeFinal.jsp")  ;          
        NON_AUTHEN_RESOURCE.add("createAccountUser.jsp") ;  
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        try {
            HttpServletRequest req = (HttpServletRequest) request ; 
            HttpServletResponse res = (HttpServletResponse) response ; 
            String url = req.getRequestURI() ;
            int index = url.lastIndexOf("/") ; 
            String resource = url.substring(index + 1) ;
            boolean checkContain = false ; 
            for (String value : NON_AUTHEN_RESOURCE) {
                if(url.contains(value)) {
                    checkContain = true ; 
                    break ;
                }
            }
            if(checkContain) {
                chain.doFilter(request, response);
            }else {
                HttpSession session = req.getSession() ; 
                if(session == null || session.getAttribute("LOGIN_USER") == null) {
                    res.sendRedirect(LOGIN_PAGE); 
                }else {
                    UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER") ; 
                    String roleID = loginUser.getRoleID() ;
                    if(AD.equals(roleID) && ADMIN_RESOURCE.contains(resource)) {
                        chain.doFilter(request, response);
                    }else if(US.equals(roleID) && USER_RESOURCE.contains(resource)) {
                        chain.doFilter(request, response); 
                    }else if(SEL.equals(roleID) && SELLER_RESOURCE.contains(resource)) { 
                        chain.doFilter(request, response); 
                    }else {
                        res.sendRedirect(LOGIN_PAGE);
                    }
                }
            }
        } catch (Exception e) {
            log("ERROR AT AUTHENFILTER" + e.toString());
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("AuthenFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthenFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthenFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}