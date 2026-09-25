package com.delrosario.stationeryms.controller;

import com.delrosario.stationeryms.model.Product;
import com.delrosario.stationeryms.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity listProducts() {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity response;
        try {
            Product[] products = productService.getProducts();
            response = ResponseEntity.ok().headers(headers).body(products);
        } catch(Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity get(@PathVariable final Integer id) {
        logger.info("Input product id >> " + Integer.toString(id));
        ResponseEntity response;
        try {
            Product product = productService.getProduct(id);
            response = ResponseEntity.ok(product);
        } catch(Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @PostMapping("/api/products")
    public ResponseEntity add(@RequestBody Product product) {
        logger.info("Input >> " + product.toString());
        ResponseEntity response;
        try {
            Product newProduct = productService.create(product);
            logger.info("created product >> " + newProduct.toString());
            response = ResponseEntity.ok(newProduct);
        } catch(Exception ex) {
            logger.error("Failed to create product : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/api/products")
    public ResponseEntity update(@RequestBody Product product) {
        logger.info("Update Input >> " + product.toString());
        ResponseEntity response;
        try {
            Product updatedProduct = productService.update(product);
            response = ResponseEntity.ok(updatedProduct);
        } catch(Exception ex) {
            logger.error("Failed to update product : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity delete(@PathVariable final Integer id) {
        logger.info("Input >> " + Integer.toString(id));
        ResponseEntity response;
        try {
            productService.delete(id);
            response = ResponseEntity.ok(null);
        } catch(Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }
}