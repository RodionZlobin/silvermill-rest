package com.rodion.silvermillrest.model;

import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermilldata.domain.ValueObject;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public class OrderRowModel extends ValueObject {

    private static final long serialVersionUID = 1L;

    private String orderNumber;
    private String invoiceNumber;
    private ProductModel product;
    private String unit;
    private Double quantity;
    private Double price;
    private Double amount;

    private OrderRowModel() {
    }

    public OrderRowModel(String orderNumber, String invoiceNumber, ProductModel product, String unit, Double quantity, Double price, Double amount) {
        this.orderNumber = orderNumber;
        this.invoiceNumber = invoiceNumber;
        this.product = product;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public ProductModel getProduct() {
        return product;
    }

    public String getUnit() {
        return unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{orderNumber, invoiceNumber, product, unit, quantity, price, amount};
    }
}
