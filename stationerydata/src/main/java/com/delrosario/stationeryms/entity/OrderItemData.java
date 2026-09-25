package com.delrosario.stationeryms.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "order_item_data")
public class OrderItemData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int orderId;
    int quantity;
    String uom;
    double price;
    String status;
}