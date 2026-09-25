package com.delrosario.stationeryms.model;

import lombok.Data;

@Data
public class OrderItem {
    int id;
    int orderId;
    int quantity;
    String uom;
    double price;
    String status;
}