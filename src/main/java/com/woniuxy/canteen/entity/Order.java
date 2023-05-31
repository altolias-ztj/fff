package com.woniuxy.canteen.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Order {
    private Integer id;
    private LocalDate dealDate;
    private LocalTime dealTime;
    private Customer customer;
    private Integer customerId;
    private Food food;
    private Integer foodId;
}
