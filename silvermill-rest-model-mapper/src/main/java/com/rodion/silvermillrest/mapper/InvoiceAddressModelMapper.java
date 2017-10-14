package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.Address;
import com.rodion.silvermillrest.model.AddressModel;

/**
 * @author Rodion
 */
public final class InvoiceAddressModelMapper {

    private InvoiceAddressModelMapper(){}

    public static AddressModel map(Address address){
        return address == null ? null :
                new AddressModel(address.getAddressName(),
                                    address.getStreet(),
                                    address.getBuilding(),
                                    address.getCity(),
                                    address.getZipCode(),
                                    address.getCountry(),
                                    address.getPostBox());
    }
}
