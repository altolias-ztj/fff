package com.woniuxy.canteen.service;

import com.woniuxy.canteen.entity.Customer;
import com.woniuxy.canteen.entity.PageBean;

public interface CustomerService {
    void add(Customer customer);
    void update(Customer customer);
    void delete(int id);
    PageBean<Customer> getByPage(Customer customer,int page);

    Customer login(String account);

    boolean isExist(String account);
}
