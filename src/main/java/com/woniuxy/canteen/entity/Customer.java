package com.woniuxy.canteen.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Customer {
    private Integer id;
    private String name;
    private String gender;
    private String account;
    private String password;
    private BigDecimal money;
    private String status;
}
