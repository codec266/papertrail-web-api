package com.delrosario.stationeryms.service;
import com.delrosario.stationeryms.model.OrderItem;

public interface OrderItemService {
    OrderItem create(OrderItem orderItem) throws Exception;
    OrderItem update(OrderItem orderItem) throws Exception;
}