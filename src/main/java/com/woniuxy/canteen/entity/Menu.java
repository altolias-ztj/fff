package com.woniuxy.canteen.entity;

import lombok.Data;

@Data
public class Menu {
    private Integer id;
    private String name;
    private String link;
    private Integer pid;
}
