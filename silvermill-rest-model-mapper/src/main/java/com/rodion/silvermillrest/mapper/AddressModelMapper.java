package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.Address;
import com.rodion.silvermillrest.model.AddressModel;

/**
 * @author Rodion
 */
public class AddressModelMapper {

    public static AddressModel map(Address address){
        return new AddressModel(address.getAddressName(),
                                    address.getStreet(),
                                    address.getBuilding(),
                                    address.getCity(),
                                    address.getZipCode(),
                                    address.getCountry(),
                                    address.getPostBox());
    }
}
