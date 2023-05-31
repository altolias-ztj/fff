package com.woniuxy.canteen.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    private List<T> data;
    private int totalPage;
    private int currPage;
    private int totalNums;
    private int pageSize;
    private int actualNum;
}
