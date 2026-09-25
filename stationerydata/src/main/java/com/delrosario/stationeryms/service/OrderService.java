package com.delrosario.stationeryms.service;
import com.delrosario.stationeryms.model.Order;

public interface OrderService {
    Order create(Order order) throws Exception;
    Order update(Order order) throws Exception;
}