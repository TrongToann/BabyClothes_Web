package trongtoan.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import trongtoan.entity.Category;
import trongtoan.entity.Order;
import trongtoan.entity.Product;
import trongtoan.entity.UserDTO;
import trongtoan.utils.DBUtils;

public class DAO {

    private static final String GETLIST_PRODUCT = "SELECT id, name, image, price, title, description, quantity, cateID FROM tblProduct where status = 1 ";
    private static final String GETLIST_ACCOUNT = "SELECT rID, userID, fullName, role, password FROM tblAccount where status = 1 ";
    private static final String GETLIST_CATEGORY = "SELECT cateID, name FROM tblCategory";
    private static final String GETLIST_ORDER = "SELECT orderID, userID, total, order_Date FROM tblOrder ";
    private static final String GETLIST_ORDERDETAIL = "SELECT detailID, orderID, productID, price, quantity FROM tblOrderDetail";
    private static final String GETLAST_PRODUCT = "SELECT top 1 ID, name, image, price, title, description FROM tblProduct where status = 1 order by id desc ";
    private static final String GETPRODUCTBYCID = "SELECT ID, name, image, price, title, description FROM tblProduct WHERE cateID = ? AND status = 1 ";
    private static final String GETPRODUCTBYID = "SELECT ID, name, image, price, title, description FROM tblProduct WHERE ID = ? AND status = 1";
    private static final String SEARCH_PRODUCT = "SELECT ID, name, image, price, title, description FROM tblProduct WHERE [name] like ? AND status = 1 ";
    private static final String SEARCH_ACCOUNT = "SELECT rID, userID, password, fullName, role FROM tblAccount WHERE fullName like ? AND status = 1 ";
    private static final String LOGIN = "SELECT rID,fullName, role FROM tblAccount WHERE userID=? AND password=? AND status = 1 ";
    private static final String CHECKID = "SELECT orderID from tblOrder WHERE orderID = ?";
    private static final String CHECKAID = "SELECT rID from tblAccount WHERE rID = ?";
    private static final String CHECK_ACCOUNT_USERID = "SELECT userID from tblAccount WHERE userID = ?";
    private static final String CHECK_DETAILID = "SELECT detailID from tblOrderDetail WHERE detailID = ?";
    private static final String CHECK_PRODUCTID = "SELECT ID from tblProduct WHERE ID = ?";
    private static final String FIND_ORDERID = "SELECT orderID from tblOrder WHERE rID = ?";
    private static final String ADD_ORDER = "INSERT INTO tblOrder(orderID, userID , total, order_Date) VALUES (?,?,?,?) ";
    private static final String ADD_ORDER_DETAIL = "INSERT INTO tblOrderDetail(detailID,orderID,productID,price,quantity) VALUES (?,?,?,?,?) ";
    private static final String UPDATE_PRODUCT = "UPDATE tblProduct SET ID =? , [name] = ? , [price] = ? , [title] = ? ,[quantity] = ? WHERE ID = ?";
    private static final String UPDATE_ACCOUNT = "UPDATE tblAccount SET rID =? , userID = ? , password = ? , fullName = ? , role = ? WHERE rID = ?";
    private static final String DELETE_PRODUCT = "UPDATE tblProduct SET status = 2 WHERE ID = ? ";
    private static final String CHECK_BEFORE_DELETE_PRODUCT = "SELECT * FROM tblOrderDetail WHERE productID = ? ";
    private static final String DELETE_ACCOUNT = "UPDATE tblAccount SET status = 2 WHERE rID = ?";
    private static final String DELETE_ORDER = "DELETE tblOrder WHERE orderID = ?";
    private static final String DELETE_ORDERDETAIL = "DELETE tblOrderDetail WHERE orderID = ?";
    private static final String CREATE_PRODUCT = "INSERT INTO tblProduct(ID, [name] ,[image] ,[price] ,[title] ,[description] ,[quantity],cateID , status) VALUES (? , ? , ? , ? , ? , ? , ?,?,?) ";
    private static final String ADD_ACCOUNT = "INSERT INTO tblAccount(rID,userID,password,fullName,role,status) VALUES (?,?,?,?,?,?)";
    private static final String CHECKOUT = "SELECT [quantity] FROM tblProduct WHERE ID = ? ";

    public boolean addAccount(UserDTO user) throws SQLException, NamingException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_ACCOUNT);
                ptm.setString(1, user.getrID());
                ptm.setString(2, user.getUserID());
                ptm.setString(3, user.getPassword());
                ptm.setString(4, user.getFullName());
                ptm.setString(5, user.getRoleID());
                ptm.setInt(6,1);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (SQLException e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public int checkDuplicate(String id) throws SQLException, NamingException , ClassNotFoundException {
        int check = -1;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_ACCOUNT_USERID);
                ptm.setString(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = 1;
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public UserDTO checkLogin(String userID, String password) throws SQLException, NamingException , ClassNotFoundException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String rID = rs.getString("rID");
                    String fullName = rs.getString("fullName");
                    String role = rs.getString("role");
                    user = new UserDTO(rID, userID, fullName, role, "");
                }
            }

        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public List<Product> getAllProduct() throws SQLException, NamingException , ClassNotFoundException{
        List<Product> list = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLIST_PRODUCT);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getInt(8)));
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }

    public List<Category> getAllCategory() throws SQLException, NamingException , ClassNotFoundException{
        List<Category> listCC = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLIST_CATEGORY);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listCC.add(new Category(rs.getInt(1),
                            rs.getString(2)));
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return listCC;
    }

    public List<Order> getAllOrder() throws SQLException, NamingException , ClassNotFoundException{
        List<Order> list = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLIST_ORDER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    Date date = rs.getDate("order_Date");
                    list.add(new Order(rs.getString(1), rs.getString(2), rs.getInt(3), date)); 
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Order> getAllOrderDetail() throws SQLException, NamingException , ClassNotFoundException{
        List<Order> list = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLIST_ORDERDETAIL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }

    public Product getLasted() throws SQLException, NamingException , ClassNotFoundException{
        Product p1 = new Product();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLAST_PRODUCT);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    p1 = new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getString(6));
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return p1;
    }

    public List<Product> getProductByCID(String cid) throws SQLException, NamingException , ClassNotFoundException{
        List<Product> list = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETPRODUCTBYCID);
                ptm.setString(1, cid);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getString(6)));
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }

    public Product getProductByID(String cid) throws SQLException, NamingException , ClassNotFoundException{
        Product p1 = new Product();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETPRODUCTBYID);
                ptm.setString(1, cid);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    p1 = new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getString(6));
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return p1;
    }

    public List<Product> searchByName(String txtSearch) throws SQLException, NamingException, ClassNotFoundException {
        List<Product> list = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_PRODUCT);
                ptm.setString(1, "%" + txtSearch + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getString(6)));
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }
     public List<UserDTO> searchAccountByName(String txtSearch) throws SQLException, NamingException , ClassNotFoundException{
        List<UserDTO> list = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_ACCOUNT);
                ptm.setString(1, "%" + txtSearch + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)) ) ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }

    public int checkOrID(String rID) throws SQLException, NamingException , ClassNotFoundException{
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int temp = -1;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECKID);
                ptm.setString(1, rID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    temp = 1;
                }

            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return temp;
    }

    public int checkDID(String dID) throws SQLException, NamingException , ClassNotFoundException{
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int temp = -1;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DETAILID);
                ptm.setString(1, dID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    temp = 1;
                }

            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return temp;
    }

    public int checkAID(String dID) throws SQLException, NamingException , ClassNotFoundException{
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int temp = -1;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECKAID);
                ptm.setString(1, dID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    temp = 1;
                }

            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return temp;
    }

    public int checkpID(int dID) throws SQLException, NamingException , ClassNotFoundException{
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int temp = -1;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_PRODUCTID);
                ptm.setInt(1, dID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    temp = 1;
                }

            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return temp;
    }

    public boolean insertOrder(String orderID, String rID, String total, Date orderDate) throws SQLException, NamingException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_ORDER);
                ptm.setString(1, orderID);
                ptm.setString(2, rID);
                ptm.setString(3, total);
                ptm.setDate(4, (java.sql.Date) orderDate); 
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (SQLException e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public boolean insertOrderDetail(String detailID, String orderID, String productID, double price, int quantity) throws SQLException, NamingException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_ORDER_DETAIL);
                ptm.setString(1, detailID);
                ptm.setString(2, orderID);
                ptm.setString(3, productID);
                ptm.setDouble(4, price);
                ptm.setInt(5, quantity);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (SQLException e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public String findOrderID(String rID) throws SQLException, NamingException , ClassNotFoundException{
        String orderDetail = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FIND_ORDERID);
                ptm.setString(1, rID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    orderDetail = rs.getString("orderID");
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return orderDetail;
    }

    public boolean updateProduct(Product product) throws SQLException, NamingException , ClassNotFoundException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_PRODUCT);
                ptm.setString(1, product.getId());
                ptm.setString(2, product.getName());
                ptm.setDouble(3, product.getPrice());
                ptm.setString(4, product.getName());
                ptm.setInt(5, product.getQuantity());
                ptm.setString(6, product.getId());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (SQLException e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean deleteProduct(int id) throws SQLException, NamingException , ClassNotFoundException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_BEFORE_DELETE_PRODUCT);
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = false;
                } else {
                    ptm = conn.prepareStatement(DELETE_PRODUCT);
                    ptm.setInt(1, id);

                    check = ptm.executeUpdate() > 0 ? true : false;
                }

            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean createProduct(Product product) throws SQLException, NamingException , ClassNotFoundException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_PRODUCT);
                ptm.setString(1, product.getId());
                ptm.setString(2, product.getName());
                ptm.setString(3, product.getImage());
                ptm.setDouble(4, product.getPrice());
                ptm.setString(5, product.getTitle());
                ptm.setString(6, product.getDescription());
                ptm.setInt(7, 50);
                ptm.setInt(8, product.getCateID()) ;
                ptm.setInt(9, 1);
                
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (SQLException e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public List<UserDTO> getAllAccount() throws SQLException, NamingException , ClassNotFoundException{
        List<UserDTO> list = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLIST_ACCOUNT);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new UserDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)
                    ));
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }

    public boolean updateAccount(UserDTO user) throws SQLException, NamingException , ClassNotFoundException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ACCOUNT);
                ptm.setString(1, user.getrID());
                ptm.setString(2, user.getUserID());
                ptm.setString(3, user.getPassword());
                ptm.setString(4, user.getFullName());
                ptm.setString(5, user.getRoleID());
                ptm.setString(6, user.getrID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (SQLException e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean deleteAccount(String id) throws SQLException, NamingException , ClassNotFoundException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        PreparedStatement ptm1 = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_ACCOUNT);
                ptm.setString(1, id);

                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (SQLException e) {
        } finally {
            if (ptm1 != null) {
                ptm1.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean deleteOrder(String orderID) throws SQLException, NamingException , ClassNotFoundException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        PreparedStatement ptm1 = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_ORDER);
                ptm1 = conn.prepareStatement(DELETE_ORDERDETAIL);
                ptm.setString(1, orderID);
                ptm1.setString(1, orderID);
                check = ptm1.executeUpdate() > 0 ? true : false;
                check = ptm.executeUpdate() > 0 ? true : false;

            }
        } catch (SQLException e) {
        } finally {
            if (ptm1 != null) {
                ptm1.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean checkOut(String id, int quantity) throws SQLException, NamingException , ClassNotFoundException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECKOUT);
                ptm.setString(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int quantityDB = rs.getInt(1);
                    if (quantity < quantityDB) {
                        check = true;
                    }
                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public int getQuantity(String id) throws SQLException, NamingException , ClassNotFoundException{
        int quantityDB = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECKOUT);
                ptm.setString(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    quantityDB = rs.getInt(1);

                }
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return quantityDB;
    }

    public static void main(String[] args) throws NamingException , ClassNotFoundException{
        try {
            DAO dao = new DAO();
            List<Order> list = new ArrayList();
            list = dao.getAllOrder() ; 
            for (Order order : list) {
                System.out.println(order.toString());
            }
        } catch (SQLException e) {
        }
    }
}
