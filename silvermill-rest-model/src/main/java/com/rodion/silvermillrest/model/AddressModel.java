package com.rodion.silvermillrest.model;

import com.rodion.silvermilldata.domain.ValueObject;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class AddressModel extends ValueObject {

    private static final long serialVersionUID = 1L;

    private String addressName;
    private String street;
    private String building;
    private String city;
    private String zipCode;
    private String country;
    private String postBox;

    private AddressModel() {
    }

    public AddressModel(String addressName, String street, String building, String city, String zipCode, String country, String postBox) {
        this.addressName = addressName;
        this.street = street;
        this.building = building;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.postBox = postBox;
    }

    public String getAddressName() {
        return addressName;
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
        return new Object[]{addressName, street, building, city, zipCode, country, postBox};
    }
}
