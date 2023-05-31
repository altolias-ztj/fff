package com.woniuxy.canteen.query;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodQO {
    private Integer staffId;
    private String style;
    private BigDecimal min;
    private BigDecimal max;
}
