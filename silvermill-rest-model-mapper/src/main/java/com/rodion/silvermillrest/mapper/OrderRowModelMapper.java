package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.OrderRow;
import com.rodion.silvermillrest.model.OrderRowModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public class OrderRowModelMapper {

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
        List<OrderRowModel> orderRowModels = new ArrayList<>();
        orderRows.forEach(p -> orderRowModels.add(OrderRowModelMapper.map(p)));
        return orderRowModels;
    }
}
