/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class OrderDTO implements Serializable {
    private String orderID;
    private String userID;
    private Date orderDate;
    private float totalPrice;
    
    private List<ProductDTO> list;

    public OrderDTO() {
    }

    public OrderDTO(String oderID, String userID, Date orderDate, float totalPrice) {
        this.orderID = oderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    /**
     * @return the oderID
     */
    

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

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the totalPrice
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the list
     */
    public List<ProductDTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<ProductDTO> list) {
        this.list = list;
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
}
