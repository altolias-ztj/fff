package com.woniuxy.canteen;

import com.woniuxy.canteen.entity.Order;
import com.woniuxy.canteen.mapper.OrderMapper;
import com.woniuxy.canteen.query.OrderQO;
import com.woniuxy.canteen.service.OrderService;
import com.woniuxy.canteen.web.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class OrderTest {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderService orderService;

    @Test
    public void addTest() {
        OrderQO order = new OrderQO();
        System.out.println(orderMapper.getByCondition(order));
    }

    @Test
    public void listTest(){
        System.out.println(orderService.getByIdPage(1,1));
    }
}
