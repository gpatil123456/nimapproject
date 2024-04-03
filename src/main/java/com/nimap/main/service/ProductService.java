package com.nimap.main.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimap.main.entity.Product;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);

    Product getProductById(Long id) throws NotFoundException;

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product) throws NotFoundException;

    void deleteProduct(Long id) throws NotFoundException;
}
