package com.rodion.silvermillrest.service;

import com.rodion.silvermilldata.client.CustomerClient;
import com.rodion.silvermilldata.domain.Customer;
import com.rodion.silvermillrest.mapper.CustomerModelMapper;
import com.rodion.silvermillrest.model.CustomerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author Rodion
 */

@RestController("customerRestService")
@RequestMapping("/customer")
public class CustomerRestService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserRestService.class);


    private CustomerClient customerClient;

    public CustomerRestService(CustomerClient customerClient) {
        this.customerClient = Objects.requireNonNull(customerClient, "customerClient cannot be null");
    }

    @RequestMapping(value = "/{customerName}", method = RequestMethod.GET)
    public ResponseEntity<CustomerModel> getCustomer(HttpServletRequest request, @PathVariable String customerName){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");

        Customer customer = customerClient.findByCustomerName(customerName);
        CustomerModel customerModel = CustomerModelMapper.map(customer);

        return new ResponseEntity<>(customerModel, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){

        List<Customer> customers =customerClient.findAllCustomers();
        List<CustomerModel> userModels = CustomerModelMapper.map(customers);

        return new ResponseEntity<>(userModels, HttpStatus.OK);
    }
}

