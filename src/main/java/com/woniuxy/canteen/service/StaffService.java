package com.woniuxy.canteen.service;

import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.entity.Staff;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void update(Staff staff);
    void delete(int id);
    PageBean<Staff> getByPage(Staff staff,int page);

    Staff login(String account);

    List<Staff> getAll();

    boolean isExist(String account);
}
