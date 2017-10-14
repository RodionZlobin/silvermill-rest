package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermillrest.model.ProductModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class ProductModelMapper {

    private ProductModelMapper(){}

    public static ProductModel map(Product product){
        return new ProductModel(product.getProductArticle(),
                        product.getProductName(),
                        product.getProductColor(),
                        product.getProductSalesPrice(),
                        product.getProductQuantity());
    }

    public static List<ProductModel> map(List<Product> products){

        return products.stream().map(ProductModelMapper::map).collect(Collectors.toList());
    }
}
