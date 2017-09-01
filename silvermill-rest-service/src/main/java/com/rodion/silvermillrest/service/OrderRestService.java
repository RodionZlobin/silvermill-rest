package com.rodion.silvermillrest.service;

import com.rodion.silvermilldata.client.OrderClient;
import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermillrest.mapper.OrderModelMapper;
import com.rodion.silvermillrest.model.OrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author Rodion
 */

@RestController("orderRestService")
@RequestMapping("/order")
public class OrderRestService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserRestService.class);

    private OrderClient orderClient;

    public OrderRestService(OrderClient orderClient) {
        this.orderClient = Objects.requireNonNull(orderClient, "orderClient cannot be null");
    }

    @RequestMapping(value = "/{orderNumber}", method = RequestMethod.GET)
    public ResponseEntity<OrderModel> getOrderByNumber(@PathVariable String orderNumber){

        Order order = orderClient.findOrderByNumber(orderNumber);
        OrderModel orderModel = OrderModelMapper.map(order);

        return new ResponseEntity<>(orderModel, HttpStatus.OK);
    }

}
