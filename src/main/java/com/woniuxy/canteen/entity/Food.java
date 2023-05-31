package com.woniuxy.canteen.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Food {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Staff staff;
    private Integer staffId;
    private String style;
    private String image;
}
