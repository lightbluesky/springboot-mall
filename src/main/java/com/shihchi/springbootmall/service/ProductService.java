package com.shihchi.springbootmall.service;

import com.shihchi.springbootmall.dao.ProductQueryParams;
import com.shihchi.springbootmall.dto.ProductRequest;
import com.shihchi.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductQueryParams params);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
