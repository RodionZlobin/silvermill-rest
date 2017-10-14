package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.Invoice;
import com.rodion.silvermillrest.model.InvoiceModel;

/**
 * @author Rodion Zlobin {@literal <mailto:rodion.zlobin@so4it.com/>}.
 */
public final class InvoiceModelMapper {

    private InvoiceModelMapper(){}

    public static InvoiceModel map (Invoice invoice){
        return invoice == null ? null :
                new InvoiceModel(invoice.getInvoiceNumber(),
                            invoice.getInvoiceDate(),
                            invoice.getDueDate(),
                            CustomerModelMapper.map(invoice.getCustomer()),
                            DeliveryAddressModelMapper.map(invoice.getDeliveryAddress()),
                            invoice.getDeliveryTerms(),
                            invoice.getCountryOfOrigin(),
                            invoice.getCurrency(),
                            invoice.getVATRate(),
                            invoice.getAmount(),
                            invoice.getTotalAmount(),
                            OrderRowModelMapper.map(invoice.getOrderRows()),
                            invoice.getStatus(),
                            invoice.getTotalAmountInWords(),
                            invoice.getReducedVATNotification());
    }
}
