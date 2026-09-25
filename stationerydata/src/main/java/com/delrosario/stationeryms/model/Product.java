package com.delrosario.stationeryms.model;

import lombok.Data;

@Data
public class Product {
    int id;
    String name;
    String description;
    double price;
    String uom;
    int availableStocks;
    String image;
    String status;
}