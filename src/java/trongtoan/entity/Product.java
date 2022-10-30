/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongtoan.entity;

/**
 *
 * @author DELL
 */
public class Product {
    private String id; 
    private String name ; 
    private String image ; 
    private double price ; 
    private String title ; 
    private int quantity ; 
    private String description ; 
    private int cateID ; 

    public Product() {
    }

    public Product(String id, String name, String image, double price, String title,  String description , int quantity, int cateID) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        
        this.description = description;
        this.quantity = quantity;
        this.cateID = cateID;
    }

    
    public Product(String id, String name, String image, double price, String title, int cateID, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.cateID = cateID;
    }

    public Product(String id, String name, double price, String title, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.title = title;
        this.quantity = quantity;
    }
     
    
    
    public Product(String id, String name, double price, String title, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.title = title;
        this.quantity = quantity;
        this.description = description;
    }
    
    
    public Product(String id, String name, String image, double price, String title, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
    }
    

    public Product(String id, String name, String image, double price, String title, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }
    
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", title=" + title + ", quantity=" + quantity + ", description=" + description + '}';
    }
    

    
    
    
}
