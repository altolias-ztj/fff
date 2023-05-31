package com.woniuxy.canteen.query;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClockingQO {
    private Integer staffId;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate min;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate max;
}
