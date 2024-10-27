package com.shihchi.springbootmall.service.impl;

import com.shihchi.springbootmall.dao.ProductDao;
import com.shihchi.springbootmall.model.Product;
import com.shihchi.springbootmall.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public Product getProductById(Integer productId) {
        try {
            return productDao.getProductById(productId);
        }
        catch (Exception e) {
            logger.error("Get Product By Id error - productId = {} - {}", productId, e.getMessage());
            throw e;
        }
    }
}
