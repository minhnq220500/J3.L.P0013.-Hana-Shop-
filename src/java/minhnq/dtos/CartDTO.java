/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.dtos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import minhnq.daos.ProductDAO;

/**
 *
 * @author admin
 */
public class CartDTO {

    private String userID;
    private HashMap<String, ProductDTO> cart;

    public CartDTO() {
    }

    public CartDTO(String userID) {
        this.userID = userID;
        this.cart = cart;
    }

    public void addToCart(ProductDTO dto) throws Exception {
//        if (this.getCart().containsKey(dto.getProductID())) {
//            int newQuantity = this.getCart().get(dto.getProductID()).getQuantity() + 1;
//            this.getCart().get(dto.getProductID()).setQuantity(newQuantity);
//        } else {
//            this.getCart().put(dto.getProductID(), dto);
//        }

        ProductDAO dao = new ProductDAO();
        int maxQuantity = dao.getProductQuantityByID(dto.getProductID());

        if (getCart() == null) {
            setCart(new HashMap<>());//tạo ra cái giỏ hàng
            
            getCart().put(dto.getProductID(), dto);
        } 
        
        else if (getCart() != null) {
            if (getCart().containsKey(dto.getProductID())) {

                //khi nó max rồi thì nó sẽ không add thêm
                int quantity = this.getCart().get(dto.getProductID()).getQuantity();
                if (quantity == maxQuantity) {
                    dto.setQuantity(quantity);
                } else {
                    dto.setQuantity(quantity + 1);
                    getCart().put(dto.getProductID(), dto);
                }

            } //if ID sản phẩm k có trong giỏ hàng
            else if (getCart().containsKey(dto.getProductID()) == false) {
                getCart().put(dto.getProductID(), dto);
            }
        }

    }

    public void update(ProductDTO productDTO) {
        if (this.getCart() != null) {
            if (this.getCart().containsKey(productDTO.getProductID())) {
                getCart().replace(productDTO.getProductID(), productDTO);
            }
        }
    }

    public void remove(String id) throws Exception {
        if (this.getCart().containsKey(id)) {
            this.getCart().remove(id);
        }
    }

    public float getTotalPrice() throws Exception {
        float result = 0;
        for (ProductDTO dto : this.getCart().values()) {
            result += dto.getQuantity() * dto.getPrice();
        }
        return result;
    }

    /**
     * @return the userName
     */
    /**
     * @return the cart
     */
    public HashMap<String, ProductDTO> getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(HashMap<String, ProductDTO> cart) {
        this.cart = cart;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

}
