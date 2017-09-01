package com.rodion.silvermillrest.model;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermilldata.domain.ValueObject;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderModel extends ValueObject {

    private static final long serialVersionUID = 1L;

    private String orderNumber;
    private Date orderDate;
    private String paymentTerms;
    private CustomerModel customer;
    private DeliveryAddressModel deliveryAddress;
    private String deliveryTerms;
    private List<OrderRowModel> orderRows;
    private String currency;
    private Integer VATRate;
    private Double amount;
    private Double totalAmount;
    private String status;

    private OrderModel() {
    }

    public OrderModel(String orderNumber, Date orderDate, String paymentTerms, CustomerModel customer, DeliveryAddressModel deliveryAddress, String deliveryTerms, List<OrderRowModel> orderRows, String currency, Integer VATRate, Double amount, Double totalAmount, String status) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.paymentTerms = paymentTerms;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.deliveryTerms = deliveryTerms;
        this.orderRows = orderRows;
        this.currency = currency;
        this.VATRate = VATRate;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public DeliveryAddressModel getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryTerms() {
        return deliveryTerms;
    }

    public List<OrderRowModel> getOrderRows() {
        return orderRows;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getVATRate() {
        return VATRate;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{orderNumber, orderDate, paymentTerms, customer, deliveryAddress, deliveryTerms, orderRows, currency, VATRate, amount, totalAmount, status};
    }
}
