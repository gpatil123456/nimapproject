package com.nimap.main.controller;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.main.entity.Product;
import com.nimap.main.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	 private final ProductService productService;

	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @GetMapping
	    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
	        Page<Product> products = productService.getAllProducts(pageable);
	        return ResponseEntity.ok(products);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws NotFoundException {
	        Product product = productService.getProductById(id);
	        return ResponseEntity.ok(product);
	    }

	    @PostMapping
	    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	        Product createdProduct = productService.createProduct(product);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) throws NotFoundException {
	        Product updatedProduct = productService.updateProduct(id, product);
	        return ResponseEntity.ok(updatedProduct);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws NotFoundException {
	        productService.deleteProduct(id);
	        return ResponseEntity.noContent().build();
	    }
   

    
}
