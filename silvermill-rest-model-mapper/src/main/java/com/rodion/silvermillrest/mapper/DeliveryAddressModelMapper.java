package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermillrest.model.DeliveryAddressModel;

/**
 * @author Rodion
 */
public class DeliveryAddressModelMapper {

    public static DeliveryAddressModel map(DeliveryAddress deliveryAddress){
        return new DeliveryAddressModel(deliveryAddress.getDeliveryAddressName(),
                deliveryAddress.getStreet(),
                deliveryAddress.getBuilding(),
                deliveryAddress.getCity(),
                deliveryAddress.getZipCode(),
                deliveryAddress.getCountry(),
                deliveryAddress.getPostBox());
    }
}
