package com.delrosario.stationeryms.serviceimpl;

import com.delrosario.stationeryms.entity.OrderData;
import com.delrosario.stationeryms.model.Order;
import com.delrosario.stationeryms.repository.OrderDataRepository;
import com.delrosario.stationeryms.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderDataRepository orderDataRepository;

    @Override
    public Order create(Order order) {
        logger.info("add: Input" + order.toString());
        OrderData orderData = new OrderData();
        orderData.setCustomerId(order.getCustomerId());
        orderData.setCustomerName(order.getCustomerName());
        orderData.setDateOrdered(new Date());
        orderData.setOrderStatus(order.getOrderStatus());

        orderData = (OrderData) orderDataRepository.save(orderData);

        Order newOrder = new Order();
        newOrder.setId(orderData.getId());
        newOrder.setCustomerId(orderData.getCustomerId());
        newOrder.setCustomerName(orderData.getCustomerName());
        newOrder.setDateOrdered(orderData.getDateOrdered());
        newOrder.setOrderStatus(orderData.getOrderStatus());
        return newOrder;
    }

    @Override
    public Order update(Order order) {
        OrderData orderData = new OrderData();
        orderData.setId(order.getId());
        orderData.setCustomerId(order.getCustomerId());
        orderData.setCustomerName(order.getCustomerName());
        orderData.setDateOrdered(order.getDateOrdered());
        orderData.setDateUpdated(new Date());
        orderData.setOrderStatus(order.getOrderStatus());

        orderData = (OrderData) orderDataRepository.save(orderData);

        Order newOrder = new Order();
        newOrder.setId(orderData.getId());
        newOrder.setCustomerId(orderData.getCustomerId());
        newOrder.setCustomerName(orderData.getCustomerName());
        newOrder.setDateOrdered(orderData.getDateOrdered());
        newOrder.setDateUpdated(orderData.getDateUpdated());
        newOrder.setOrderStatus(orderData.getOrderStatus());
        return newOrder;
    }
}