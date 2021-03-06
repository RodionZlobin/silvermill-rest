package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermillrest.model.OrderRowModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public final class OrderRowModelMapper {

    private OrderRowModelMapper(){}

    public static OrderRowModel map(OrderRow orderRow){
        return new OrderRowModel(orderRow.getOrderNumber(),
                        orderRow.getInvoiceNumber(),
                        ProductModelMapper.map(orderRow.getProduct()),
                        orderRow.getUnit(),
                        orderRow.getQuantity(),
                        orderRow.getPrice(),
                        orderRow.getAmount());
    }

    public static List<OrderRowModel> map(List<OrderRow> orderRows){

        return orderRows.stream().map(OrderRowModelMapper::map).collect(Collectors.toList());
    }
}
