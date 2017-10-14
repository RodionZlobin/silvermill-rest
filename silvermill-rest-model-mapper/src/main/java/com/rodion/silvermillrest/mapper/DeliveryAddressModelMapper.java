package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermillrest.model.DeliveryAddressModel;

/**
 * @author Rodion
 */
public final class DeliveryAddressModelMapper {

    private DeliveryAddressModelMapper(){}

    public static DeliveryAddressModel map(DeliveryAddress deliveryAddress){
        return deliveryAddress == null ? null :
                new DeliveryAddressModel(deliveryAddress.getAddressName(),
                            deliveryAddress.getStreet(),
                            deliveryAddress.getBuilding(),
                            deliveryAddress.getCity(),
                            deliveryAddress.getZipCode(),
                            deliveryAddress.getCountry(),
                            deliveryAddress.getPostBox());
    }
}
