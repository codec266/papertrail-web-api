package com.delrosario.stationeryms.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "order_data")
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int customerId;
    String customerName;
    Date dateOrdered;
    Date dateUpdated;
    String orderStatus;
}