package com.woniuxy.canteen.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Staff {
    private Integer id;
    @NotBlank
    private String name;
    private String gender;
    @NotBlank
    private String account;
    @NotBlank
    private String password;
    private LocalDate hireDate;
    private String role;
    private BigDecimal salary;
}
