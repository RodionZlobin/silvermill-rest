package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermillrest.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion
 */
public class OrderModelMapper {

    public static OrderModel map(Order order){
        return new OrderModel(order.getOrderNumber(),
                order.getOrderDate(),
                order.getPaymentTerms(),
                CustomerModelMapper.map(order.getCustomer()),
                DeliveryAddressModelMapper.map(order.getDeliveryAddress()),
                order.getDeliveryTerms(),
                OrderRowModelMapper.map(order.getOrderRows()),
                order.getCurrency(),
                order.getVATRate(),
                order.getAmount(),
                order.getTotalAmount(),
                order.getStatus());
    }

    public static List<OrderModel> map(List<Order> orders){
        List<OrderModel> orderModels = new ArrayList<>();
        orders.forEach(o -> orderModels.add(OrderModelMapper.map(o)));
        return orderModels;
    }
}
