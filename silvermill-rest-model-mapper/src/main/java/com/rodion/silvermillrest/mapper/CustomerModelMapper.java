package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermillrest.model.CustomerModel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class CustomerModelMapper {

    private CustomerModelMapper(){}

    public static CustomerModel map(Customer customer){
        return customer == null ? null :
                new CustomerModel(customer.getCustomerName(),
                                customer.getCustomerVAT(),
                                customer.getCustomerRegNumber(),
                                InvoiceAddressModelMapper.map(customer.getAddress()),
                                DeliveryAddressModelMapper.map(customer.getDeliveryAddress()));

    }

    public static List<CustomerModel> map(Collection<Customer> customers){

        return customers.stream().map(CustomerModelMapper::map).collect(Collectors.toList());
    }
}
