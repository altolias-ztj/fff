package com.woniuxy.canteen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.canteen.entity.Customer;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.entity.Staff;
import com.woniuxy.canteen.mapper.CustomerMapper;
import com.woniuxy.canteen.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public void add(Customer customer) {
        customerMapper.add(customer);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.update(customer);
    }

    @Override
    public void delete(int id) {
        customerMapper.delete(id);
    }

    @Override
    public PageBean<Customer> getByPage(Customer customer, int page) {
        int pageSize = 3;
        PageBean<Customer> pageBean = new PageBean<>();
        PageHelper.startPage(page, pageSize);
        Page<Customer> p = (Page<Customer>) customerMapper.getByCondition(customer);
        pageBean.setData(p.getResult());
        pageBean.setCurrPage(page);
        pageBean.setPageSize(pageSize);
        pageBean.setActualNum(pageBean.getData().size());
        pageBean.setTotalNums((int) p.getTotal());
        pageBean.setTotalPage(p.getPages());
        return pageBean;
    }

    @Override
    public Customer login(String account) {
        return customerMapper.getByAccount(account);
    }

    @Override
    public boolean isExist(String account) {
        return customerMapper.getCountByAccount(account) == 0;
    }
}
