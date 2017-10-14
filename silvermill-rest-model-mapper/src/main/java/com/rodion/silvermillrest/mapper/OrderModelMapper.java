package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.Order;
import com.rodion.silvermillrest.model.OrderModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class OrderModelMapper {

    private OrderModelMapper(){}

    public static OrderModel map(Order order){
        return order == null ? null :
                new OrderModel(order.getOrderNumber(),
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

        return orders.stream().map(OrderModelMapper::map).collect(Collectors.toList());
    }
}
