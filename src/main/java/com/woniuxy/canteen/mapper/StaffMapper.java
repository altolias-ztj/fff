package com.woniuxy.canteen.mapper;

import com.woniuxy.canteen.entity.Staff;

import java.util.List;

public interface StaffMapper {
    void add(Staff staff);
    void update(Staff staff);
    void delete(int id);
    List<Staff> getByCondition(Staff staff);
    Staff getByAccount(String account);
    int getCountByAccount(String account);
}
