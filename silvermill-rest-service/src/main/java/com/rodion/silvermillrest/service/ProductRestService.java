package com.rodion.silvermillrest.service;

import com.rodion.silvermilldata.client.ProductClient;
import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermillrest.mapper.ProductModelMapper;
import com.rodion.silvermillrest.model.ProductModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author Rodion
 */

@RestController("productRestService")
@RequestMapping("/product")
public class ProductRestService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserRestService.class);


    private ProductClient productClient;

    public ProductRestService(ProductClient productClient) {
        this.productClient = Objects.requireNonNull(productClient, "productClient cannot be null");
    }

    @RequestMapping(value = "/{productArticle}", method = RequestMethod.GET)
    public ResponseEntity<ProductModel> getProductByArticle(HttpServletRequest request, @PathVariable String productArticle){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");

        Product product = productClient.findByProductArticle(productArticle);
        ProductModel productModel = ProductModelMapper.map(product);

        return new ResponseEntity<>(productModel, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){

        List<Product> products =productClient.findAllProducts();
        List<ProductModel> productModels = ProductModelMapper.map(products);

        return new ResponseEntity<>(productModels, HttpStatus.OK);
    }
}
