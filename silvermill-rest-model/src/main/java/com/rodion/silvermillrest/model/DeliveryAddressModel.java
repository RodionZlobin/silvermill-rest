package com.rodion.silvermillrest.model;

import com.rodion.silvermilldata.domain.ValueObject;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class DeliveryAddressModel extends ValueObject {

    private static final long serialVersionUID = 1L;

    private String deliveryAddressName;
    private String street;
    private String building;
    private String city;
    private String zipCode;
    private String country;
    private String postBox;

    private DeliveryAddressModel() {
    }

    public DeliveryAddressModel(String deliveryAddressName, String street, String building, String city, String zipCode, String country, String postBox) {
        this.deliveryAddressName = deliveryAddressName;
        this.street = street;
        this.building = building;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.postBox = postBox;
    }

    public String getDeliveryAddressName() {
        return deliveryAddressName;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPostBox() {
        return postBox;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{deliveryAddressName, street, building, city, zipCode, country, postBox};
    }
}
