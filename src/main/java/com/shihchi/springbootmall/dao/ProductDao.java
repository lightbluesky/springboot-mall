package com.shihchi.springbootmall.dao;

import com.shihchi.springbootmall.dto.ProductRequest;
import com.shihchi.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams params);

    Product getProductById(Integer productId);

    Integer countProduct(ProductQueryParams params);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
