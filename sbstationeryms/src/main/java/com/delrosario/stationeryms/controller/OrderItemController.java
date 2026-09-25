package com.delrosario.stationeryms.controller;

import com.delrosario.stationeryms.model.OrderItem;
import com.delrosario.stationeryms.service.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderItemController {
    Logger logger = LoggerFactory.getLogger(OrderItemController.class);

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/api/order-items")
    public ResponseEntity add(@RequestBody OrderItem orderItem) {
        logger.info("Input >> " + orderItem.toString());
        ResponseEntity response;
        try {
            OrderItem newItem = orderItemService.create(orderItem);
            logger.info("created order item >> " + newItem.toString());
            response = ResponseEntity.ok(newItem);
        } catch(Exception ex) {
            logger.error("Failed to create order item : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/api/order-items")
    public ResponseEntity update(@RequestBody OrderItem orderItem) {
        logger.info("Update Input >> " + orderItem.toString());
        ResponseEntity response;
        try {
            OrderItem newItem = orderItemService.update(orderItem);
            response = ResponseEntity.ok(newItem);
        } catch(Exception ex) {
            logger.error("Failed to update order item : {}", ex.getMessage(), ex);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return response;
    }
}