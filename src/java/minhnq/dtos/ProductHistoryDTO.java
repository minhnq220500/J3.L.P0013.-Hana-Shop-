/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.dtos;

import java.util.Date;

/**
 *
 * @author admin
 */
public class ProductHistoryDTO {
    private int productHistoryID;
    private String type;
    private Date recordTime;
    private String productID;
    private String userID;

    public ProductHistoryDTO() {
    }

    public ProductHistoryDTO(int productHistoryID, String type, Date recordTime, String productID, String userID) {
        this.productHistoryID = productHistoryID;
        this.type = type;
        this.recordTime = recordTime;
        this.productID = productID;
        this.userID = userID;
    }

    

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the recordTime
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     * @param recordTime the recordTime to set
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
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

    /**
     * @return the productHistoryID
     */
    public int getProductHistoryID() {
        return productHistoryID;
    }

    /**
     * @param productHistoryID the productHistoryID to set
     */
    public void setProductHistoryID(int productHistoryID) {
        this.productHistoryID = productHistoryID;
    }
    
    
}
