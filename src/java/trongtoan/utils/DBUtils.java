
package trongtoan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtils {
    public static Connection getConnection1() throws SQLException, ClassNotFoundException {
        Connection conn = null ; 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BabyShop" ; 
        conn = DriverManager.getConnection(url, "sa" , "sa123456") ;
        return conn ; 
    }
    public static Connection getConnection() throws  SQLException, NamingException {
        Connection conn = null ; 
        Context context = new InitialContext() ; 
        Context end = (Context) context.lookup("java:comp/env") ;  
        DataSource ds = (DataSource) end.lookup("DataSource") ; 
        conn = ds.getConnection() ; 
        return conn ; 
    }
}
