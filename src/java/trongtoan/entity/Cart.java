
package trongtoan.entity;

import java.util.HashMap;
import java.util.Map;


public class Cart {
    private Map<String, Product> cart ; 

    public Cart() {
    }

    public Cart(Map<String, Product> cart) {
        this.cart = cart;
    }

    public Map<String, Product> getCart() {
        return cart;
    }

    public void setCart(Map<String, Product> cart) {
        this.cart = cart;
    }
    public void add(Product tea){
        if(this.cart == null) {
            this.cart = new HashMap<>() ; 
        }
        if(this.cart.containsKey(tea.getId())) {
            int currentQuantity = this.cart.get(tea.getId()).getQuantity() ;
            tea.setQuantity(currentQuantity + tea.getQuantity()); 
        } 
        cart.put(tea.getId(), tea) ;
    }
    public void delete(String id) {
        if(this.cart == null ) {
            return ; 
        } 
        if(this.cart.containsKey(id)) {
            this.cart.remove(id) ; 
        }
    }
    public void update(String id, Product newtea) {
        if(this.cart == null) {
            return ; 
        } 
        if(this.cart.containsKey(id)) {
            this.cart.replace(id, newtea) ; 
        }
    }
}
