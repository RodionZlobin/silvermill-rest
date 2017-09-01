package com.rodion.silvermillrest.model;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermilldata.domain.ValueObject;

import java.util.Date;
import java.util.List;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public class InvoiceModel extends ValueObject {

    private static final long serialVersionUID = 1L;

    private String invoiceNumber;
    private Date invoiceDate;
    private Date dueDate;
    private CustomerModel customer;
    private DeliveryAddressModel deliveryAddress;
    private String deliveryTerms;
    private String countryOfOrigin;
    private String currency;
    private Integer VATRate;
    private Double amount;
    private Double totalAmount;
    private List<OrderRowModel> orderRows;
    private String status;
    private String totalAmountInWords;
    private String reducedVATNotification;

    private InvoiceModel() {
    }


    public InvoiceModel(String invoiceNumber, Date invoiceDate, Date dueDate, CustomerModel customer, DeliveryAddressModel deliveryAddress, String deliveryTerms, String countryOfOrigin, String currency, Integer VATRate, Double amount, Double totalAmount, List<OrderRowModel> orderRows, String status, String totalAmountInWords, String reducedVATNotification) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.deliveryTerms = deliveryTerms;
        this.countryOfOrigin = countryOfOrigin;
        this.currency = currency;
        this.VATRate = VATRate;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.orderRows = orderRows;
        this.status = status;
        this.totalAmountInWords = totalAmountInWords;
        this.reducedVATNotification = reducedVATNotification;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
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

    public String getCountryOfOrigin() {
        return countryOfOrigin;
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

    public List<OrderRowModel> getOrderRows() {
        return orderRows;
    }

    public String getStatus() {
        return status;
    }

    public String getTotalAmountInWords() {
        return totalAmountInWords;
    }

    public String getReducedVATNotification() {
        return reducedVATNotification;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{invoiceNumber, invoiceDate, dueDate, customer, deliveryAddress, deliveryTerms, countryOfOrigin, currency, VATRate, amount, totalAmount,
        orderRows, status, totalAmountInWords, reducedVATNotification};
    }
}
