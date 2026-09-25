package com.delrosario.stationeryms.model;

import lombok.Data;

@Data
public class Stationery {
    int id;
    String name;
    String description;
    double cost;
}