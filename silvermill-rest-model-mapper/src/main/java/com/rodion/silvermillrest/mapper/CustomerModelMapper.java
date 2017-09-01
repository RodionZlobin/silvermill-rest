package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermillrest.model.CustomerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion
 */
public class CustomerModelMapper {

    public static CustomerModel map(Customer customer){
        return new CustomerModel(customer.getCustomerName(),
                                customer.getCustomerVAT(),
                                customer.getCustomerRegNumber(),
                                AddressModelMapper.map(customer.getAddress()),
                                DeliveryAddressModelMapper.map(customer.getDeliveryAddress()));

    }

    public static List<CustomerModel> map(List<Customer> customers){
        List<CustomerModel> customerModels = new ArrayList<>();
        customers.forEach(p -> customerModels.add(CustomerModelMapper.map(p)));
        return customerModels;
    }
}
