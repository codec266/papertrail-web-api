package com.delrosario.stationeryms.model;

import lombok.Data;
import java.util.Date;

@Data
public class Order {
    int id;
    int customerId;
    String customerName;
    Date dateOrdered;
    Date dateUpdated;
    String orderStatus;
}