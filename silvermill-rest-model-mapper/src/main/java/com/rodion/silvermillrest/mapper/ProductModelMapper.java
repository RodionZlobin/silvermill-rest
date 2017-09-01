package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.Product;
import com.rodion.silvermillrest.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion
 */
public class ProductModelMapper {

    public static ProductModel map(Product product){
        return new ProductModel(product.getProductArticle(),
                        product.getProductName(),
                        product.getProductColor(),
                        product.getProductSalesPrice(),
                        product.getProductQuantity());
    }

    public static List<ProductModel> map(List<Product> products){
        List<ProductModel> productModels = new ArrayList<>();
        products.forEach(p -> productModels.add(ProductModelMapper.map(p)));
        return productModels;
    }
}
