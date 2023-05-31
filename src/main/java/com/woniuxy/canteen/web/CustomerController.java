package com.woniuxy.canteen.web;

import com.woniuxy.canteen.entity.Customer;
import com.woniuxy.canteen.entity.Menu;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.service.CustomerService;
import com.woniuxy.canteen.service.MenuService;
import com.woniuxy.canteen.vo.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @Resource
    private MenuService menuService;

    @PostMapping("add")
    public ResponseResult<Void> add(@RequestBody Customer customer) {
        customerService.add(customer);
        return ResponseResult.ok();
    }

    @PostMapping("update")
    public ResponseResult<Void> update(@RequestBody Customer customer) {
        customerService.update(customer);
        return ResponseResult.ok();
    }

    @GetMapping("delete")
    public ResponseResult<Void> delete(int id) {
        customerService.delete(id);
        return ResponseResult.ok();
    }

    @GetMapping("list")
    public ResponseResult<PageBean<Customer>> list(Customer customer, Integer page) {
        if (page == null) {
            page = 1;
        }
        return ResponseResult.ok(customerService.getByPage(customer, page));
    }

    @PostMapping("login")
    public ResponseResult<Void> login(@RequestBody Customer customer, HttpSession session) {
        Customer c = customerService.login(customer.getAccount());
        if (c.getPassword() != customer.getPassword()) {

        }
        session.setAttribute("customer", c);
        return ResponseResult.ok();
    }

    @GetMapping("menus")
    public ResponseResult<List<Menu>> menus() {
        int[] m = new int[]{3, 5, 6, 33, 52, 61};
        List<Menu> menus = new ArrayList<>();
        for (int i : m) {
            menus.add(menuService.getById(i));
        }
        return ResponseResult.ok(menus);
    }
}
