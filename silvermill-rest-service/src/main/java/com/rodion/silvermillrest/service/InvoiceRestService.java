package com.rodion.silvermillrest.service;

import com.rodion.silvermilldata.client.InvoiceClient;
import com.rodion.silvermilldata.domain.Invoice;
import com.rodion.silvermillrest.mapper.InvoiceModelMapper;
import com.rodion.silvermillrest.model.InvoiceModel;
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

@RestController("invoiceRestService")
@RequestMapping("/invoice")
public class InvoiceRestService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserRestService.class);

    private InvoiceClient invoiceClient;

    public InvoiceRestService(InvoiceClient invoiceClient) {
        this.invoiceClient = Objects.requireNonNull(invoiceClient, "invoiceClient cannot be null");
    }

    @RequestMapping(value = "/{invoiceNumber}", method = RequestMethod.GET)
    public ResponseEntity<InvoiceModel> getInvoiceByNumber(@PathVariable String invoiceNumber){

        Invoice invoice =invoiceClient.findInvoiceByNumber(invoiceNumber);
        InvoiceModel invoiceModel = InvoiceModelMapper.map(invoice);

        return new ResponseEntity<>(invoiceModel, HttpStatus.OK);
    }
}
