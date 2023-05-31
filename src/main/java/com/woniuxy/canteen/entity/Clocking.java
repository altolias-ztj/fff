package com.woniuxy.canteen.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Clocking {
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private Staff staff;
    private Integer staffId;
}
