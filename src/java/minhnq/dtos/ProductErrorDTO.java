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
public class ProductErrorDTO {
    private String productIDError;
    private String productNameError;
    private String priceError;
    private String quantityError;
    private String statusError;
    private String imageError;
    private String descriptionError;
    private String createDateError;
    private String counterError;
    private String categoryIDError;

    public ProductErrorDTO() {
    }

    public ProductErrorDTO(String productIDError, String productNameError, String priceError, String quantityError, String statusError, String imageError, String descriptionError, String createDateError, String counterError, String categoryIDError) {
        this.productIDError = productIDError;
        this.productNameError = productNameError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.statusError = statusError;
        this.imageError = imageError;
        this.descriptionError = descriptionError;
        this.createDateError = createDateError;
        this.counterError = counterError;
        this.categoryIDError = categoryIDError;
    }

    
    
    public ProductErrorDTO(String productNameError, String priceError, String quantityError,String imageError, String descriptionError, String categoryIDError) {
        this.productNameError = productNameError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.imageError = imageError;
        this.descriptionError = descriptionError;
        this.categoryIDError = categoryIDError;
    }

    /**
     * @return the productIDError
     */
    public String getProductIDError() {
        return productIDError;
    }

    /**
     * @param productIDError the productIDError to set
     */
    public void setProductIDError(String productIDError) {
        this.productIDError = productIDError;
    }

    /**
     * @return the productNameError
     */
    public String getProductNameError() {
        return productNameError;
    }

    /**
     * @param productNameError the productNameError to set
     */
    public void setProductNameError(String productNameError) {
        this.productNameError = productNameError;
    }

    /**
     * @return the priceError
     */
    public String getPriceError() {
        return priceError;
    }

    /**
     * @param priceError the priceError to set
     */
    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    /**
     * @return the quantityError
     */
    public String getQuantityError() {
        return quantityError;
    }

    /**
     * @param quantityError the quantityError to set
     */
    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    /**
     * @return the statusError
     */
    public String getStatusError() {
        return statusError;
    }

    /**
     * @param statusError the statusError to set
     */
    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    /**
     * @return the imageError
     */
    public String getImageError() {
        return imageError;
    }

    /**
     * @param imageError the imageError to set
     */
    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    /**
     * @return the descriptionError
     */
    public String getDescriptionError() {
        return descriptionError;
    }

    /**
     * @param descriptionError the descriptionError to set
     */
    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    /**
     * @return the createDateError
     */
    public String getCreateDateError() {
        return createDateError;
    }

    /**
     * @param createDateError the createDateError to set
     */
    public void setCreateDateError(String createDateError) {
        this.createDateError = createDateError;
    }

    /**
     * @return the counterError
     */
    public String getCounterError() {
        return counterError;
    }

    /**
     * @param counterError the counterError to set
     */
    public void setCounterError(String counterError) {
        this.counterError = counterError;
    }

    /**
     * @return the categoryIDError
     */
    public String getCategoryIDError() {
        return categoryIDError;
    }

    /**
     * @param categoryIDError the categoryIDError to set
     */
    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    
    
    
}
