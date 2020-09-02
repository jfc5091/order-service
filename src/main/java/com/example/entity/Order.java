package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TB")
@Data
@AllArgsConstructor
public class Order {
    @Id
    private int id;
    private String name;
    private int qty;
    private double price;
}
