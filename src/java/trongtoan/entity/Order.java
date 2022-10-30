
package trongtoan.entity;


public class Order {
   private String orderID ; 
   private String rID ; 
   private int total ; 
   private String detailID ;  
   private String productID ;  
   private int price ;  
   private int quantity ;  

    public Order(String orderID, String rID, int total) {
        this.orderID = orderID;
        this.rID = rID;
        this.total = total;
    }

    public Order(String detailID ,String orderID, String productID, int price, int quantity) {
        this.orderID = orderID;
        this.detailID = detailID;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", rID=" + rID + ", total=" + total + ", detailID=" + detailID + ", productID=" + productID + ", price=" + price + ", quantity=" + quantity + '}';
    }
   
   
}
