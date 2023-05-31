package com.woniuxy.canteen.web;

import com.woniuxy.canteen.entity.Customer;
import com.woniuxy.canteen.entity.Order;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.query.OrderQO;
import com.woniuxy.canteen.service.OrderService;
import com.woniuxy.canteen.vo.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("add")
    public ResponseResult<Void> add(int id, HttpSession session) {
        Order order = new Order();
        Customer c = (Customer) session.getAttribute("customer");
        order.setCustomerId(c.getId());
        order.setFoodId(id);
        order.setDealDate(LocalDate.now());
        order.setDealTime(LocalTime.now());
        orderService.add(order);
        return ResponseResult.ok();
    }

    @GetMapping("delete")
    public ResponseResult<Void> delete(int id) {
        orderService.delete(id);
        return ResponseResult.ok();
    }

    @GetMapping("personalList")
    public ResponseResult<PageBean<Order>> plist(HttpSession session, Integer page) {
        int id = ((Customer) session.getAttribute("customer")).getId();
        if (page == null) {
            page = 1;
        }
        return ResponseResult.ok(orderService.getByIdPage(id, page));
    }

    @GetMapping("list")
    public ResponseResult<PageBean<Order>> list(OrderQO orderQO, Integer page) {
        if (page == null) {
            page = 1;
        }
        return ResponseResult.ok(orderService.getByPage(orderQO, page));
    }
}
