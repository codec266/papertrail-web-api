package com.delrosario.stationeryms.serviceimpl;

import com.delrosario.stationeryms.entity.ProductData;
import com.delrosario.stationeryms.model.Product;
import com.delrosario.stationeryms.repository.ProductDataRepository;
import com.delrosario.stationeryms.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductDataRepository productDataRepository;

    @Override
    public Product[] getProducts() {
        List productsData = new ArrayList<>();
        List products = new ArrayList<>();
        productDataRepository.findAll().forEach(productsData::add);
        Iterator it = productsData.iterator();

        while(it.hasNext()) {
            Product product = new Product();
            // Explicitly cast to ProductData
            ProductData data = (ProductData) it.next();
            product.setId(data.getId());
            product.setName(data.getName());
            product.setDescription(data.getDescription());
            product.setPrice(data.getPrice());
            product.setUom(data.getUom());
            product.setAvailableStocks(data.getAvailableStocks());
            product.setImage(data.getImage());
            product.setStatus(data.getStatus());
            products.add(product);
        }

        Product[] array = new Product[products.size()];
        for (int i = 0; i < products.size(); i++){
            // Explicitly cast to Product
            array[i] = (Product) products.get(i);
        }
        return array;
    }

    @Override
    public Product getProduct(Integer id) {
        logger.info("Input id >> " + Integer.toString(id));
        Optional optional = productDataRepository.findById(id);
        if(optional.isPresent()) {
            Product product = new Product();
            ProductData data = (ProductData) optional.get();
            product.setId(data.getId());
            product.setName(data.getName());
            product.setDescription(data.getDescription());
            product.setPrice(data.getPrice());
            product.setUom(data.getUom());
            product.setAvailableStocks(data.getAvailableStocks());
            product.setImage(data.getImage());
            product.setStatus(data.getStatus());
            return product;
        }
        logger.info("Failed >> unable to locate product");
        return null;
    }

    @Override
    public Product create(Product product) {
        logger.info("add: Input" + product.toString());
        ProductData data = new ProductData();
        data.setName(product.getName());
        data.setDescription(product.getDescription());
        data.setPrice(product.getPrice());
        data.setUom(product.getUom());
        data.setAvailableStocks(product.getAvailableStocks());
        data.setImage(product.getImage());
        data.setStatus(product.getStatus());

        data = (ProductData) productDataRepository.save(data);
        logger.info("add: Input" + data.toString());

        Product newProduct = new Product();
        newProduct.setId(data.getId());
        newProduct.setName(data.getName());
        newProduct.setDescription(data.getDescription());
        newProduct.setPrice(data.getPrice());
        newProduct.setUom(data.getUom());
        newProduct.setAvailableStocks(data.getAvailableStocks());
        newProduct.setImage(data.getImage());
        newProduct.setStatus(data.getStatus());
        return newProduct;
    }

    @Override
    public Product update(Product product) {
        ProductData data = new ProductData();
        data.setId(product.getId());
        data.setName(product.getName());
        data.setDescription(product.getDescription());
        data.setPrice(product.getPrice());
        data.setUom(product.getUom());
        data.setAvailableStocks(product.getAvailableStocks());
        data.setImage(product.getImage());
        data.setStatus(product.getStatus());

        data = (ProductData) productDataRepository.save(data);

        Product newProduct = new Product();
        newProduct.setId(data.getId());
        newProduct.setName(data.getName());
        newProduct.setDescription(data.getDescription());
        newProduct.setPrice(data.getPrice());
        newProduct.setUom(data.getUom());
        newProduct.setAvailableStocks(data.getAvailableStocks());
        newProduct.setImage(data.getImage());
        newProduct.setStatus(data.getStatus());
        return newProduct;
    }

    @Override
    public void delete(Integer id) {
        logger.info("Input >> " + Integer.toString(id));
        Optional optional = productDataRepository.findById(id);
        if(optional.isPresent()) {
            ProductData data = (ProductData) optional.get();
            productDataRepository.delete(data);
            logger.info("Success >> " + data.toString());
        } else {
            logger.info("Failed >> unable to locate product id: " + Integer.toString(id));
        }
    }
}