package com.rodion.silvermillrest.model;

import com.rodion.silvermilldata.domain.ValueObject;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public class ProductModel extends ValueObject {

    private static final long serialVersionUID = 1L;

    private String productArticle;
    private String productName;
    private String productColor;
    private Double productSalesPrice;
    private Integer productQuantity;

    private ProductModel() {
    }

    public ProductModel(String productArticle, String productName, String productColor, Double productSalesPrice, Integer productQuantity) {
        this.productArticle = productArticle;
        this.productName = productName;
        this.productColor = productColor;
        this.productSalesPrice = productSalesPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductArticle() {
        return productArticle;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public Double getProductSalesPrice() {
        return productSalesPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{productArticle, productName, productColor, productSalesPrice, productQuantity};
    }
}
