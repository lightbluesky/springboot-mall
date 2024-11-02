package com.shihchi.springbootmall.service;

import com.shihchi.springbootmall.dto.ProductRequest;
import com.shihchi.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
