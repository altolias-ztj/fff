package com.woniuxy.canteen.query;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrderQO {
    private String foodStyle;
    private String customerA;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date2;
}
