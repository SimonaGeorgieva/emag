package com.emag.service;

import com.emag.dao.ProductDao;
import com.emag.exception.ProductException;
import com.emag.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public void addProduct(Product product) throws ProductException {
        productDao.addProduct(product);
    }

    @Override
    public HashSet<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}