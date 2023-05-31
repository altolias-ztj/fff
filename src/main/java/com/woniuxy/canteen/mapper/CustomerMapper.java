package com.woniuxy.canteen.mapper;

import com.woniuxy.canteen.entity.Customer;

import java.util.List;

public interface CustomerMapper {
    void add(Customer customer);
    void update(Customer customer);
    void delete(int id);
    List<Customer> getByCondition(Customer customer);
    Customer getByAccount(String account);
    int getCountByAccount(String account);
}
