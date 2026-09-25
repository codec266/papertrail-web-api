package com.delrosario.stationeryms.controller;

import com.delrosario.stationeryms.model.Order;
import com.delrosario.stationeryms.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping("/api/orders")
    public ResponseEntity add(@RequestBody Order order) {
        logger.info("Input >> " + order.toString());
        ResponseEntity response;
        try {
            Order newOrder = orderService.create(order);
            logger.info("created order >> " + newOrder.toString());
            response = ResponseEntity.ok(newOrder);
        } catch(Exception ex) {
            logger.error("Failed to create order : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/api/orders")
    public ResponseEntity update(@RequestBody Order order) {
        logger.info("Update Input >> " + order.toString());
        ResponseEntity response;
        try {
            Order newOrder = orderService.update(order);
            response = ResponseEntity.ok(newOrder); // Note: Returning the updated order data
        } catch(Exception ex) {
            logger.error("Failed to update order : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }
}