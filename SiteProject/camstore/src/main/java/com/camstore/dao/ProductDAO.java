package com.camstore.dao;

import java.util.List;

import com.camstore.model.Product;

public interface ProductDAO {

    List<Product> listProducts();

    Product getProductById (int id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void removeProduct(int id);
}

