package com.rodion.silvermillrest.model;

import com.rodion.silvermilldata.domain.ValueObject;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class CustomerModel extends ValueObject {

    private static final long serialVersionUID = 1L;

    private String customerName;
    private String customerVAT;
    private String customerRegNumber;
    private AddressModel address;
    private DeliveryAddressModel deliveryAddress;

    private CustomerModel() {
    }

    public CustomerModel(String customerName, String customerVAT, String customerRegNumber, AddressModel address, DeliveryAddressModel deliveryAddress) {
        this.customerName = customerName;
        this.customerVAT = customerVAT;
        this.customerRegNumber = customerRegNumber;
        this.address = address;
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerVAT() {
        return customerVAT;
    }

    public void setCustomerVAT(String customerVAT) {
        this.customerVAT = customerVAT;
    }

    public String getCustomerRegNumber() {
        return customerRegNumber;
    }

    public void setCustomerRegNumber(String customerRegNumber) {
        this.customerRegNumber = customerRegNumber;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public DeliveryAddressModel getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressModel deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{customerName, customerVAT, customerRegNumber, address, deliveryAddress};
    }
}
