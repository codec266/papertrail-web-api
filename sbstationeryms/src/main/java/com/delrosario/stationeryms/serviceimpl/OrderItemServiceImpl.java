package com.delrosario.stationeryms.serviceimpl;

import com.delrosario.stationeryms.entity.OrderItemData;
import com.delrosario.stationeryms.model.OrderItem;
import com.delrosario.stationeryms.repository.OrderItemDataRepository;
import com.delrosario.stationeryms.service.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    Logger logger = LoggerFactory.getLogger(OrderItemServiceImpl.class);

    @Autowired
    OrderItemDataRepository orderItemDataRepository;

    @Override
    public OrderItem create(OrderItem orderItem) {
        OrderItemData data = new OrderItemData();
        data.setOrderId(orderItem.getOrderId());
        data.setQuantity(orderItem.getQuantity());
        data.setUom(orderItem.getUom());
        data.setPrice(orderItem.getPrice());
        data.setStatus(orderItem.getStatus());

        data = (OrderItemData) orderItemDataRepository.save(data);

        OrderItem newItem = new OrderItem();
        newItem.setId(data.getId());
        newItem.setOrderId(data.getOrderId());
        newItem.setQuantity(data.getQuantity());
        newItem.setUom(data.getUom());
        newItem.setPrice(data.getPrice());
        newItem.setStatus(data.getStatus());
        return newItem;
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        OrderItemData data = new OrderItemData();
        data.setId(orderItem.getId());
        data.setOrderId(orderItem.getOrderId());
        data.setQuantity(orderItem.getQuantity());
        data.setUom(orderItem.getUom());
        data.setPrice(orderItem.getPrice());
        data.setStatus(orderItem.getStatus());

        data = (OrderItemData) orderItemDataRepository.save(data);

        OrderItem newItem = new OrderItem();
        newItem.setId(data.getId());
        newItem.setOrderId(data.getOrderId());
        newItem.setQuantity(data.getQuantity());
        newItem.setUom(data.getUom());
        newItem.setPrice(data.getPrice());
        newItem.setStatus(data.getStatus());
        return newItem;
    }
}