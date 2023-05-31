package com.woniuxy.canteen.web;

import com.woniuxy.canteen.entity.Clocking;
import com.woniuxy.canteen.entity.Customer;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.entity.Staff;
import com.woniuxy.canteen.query.ClockingQO;
import com.woniuxy.canteen.service.ClockingService;
import com.woniuxy.canteen.vo.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("clocking")
public class ClockingController {

    @Resource
    private ClockingService clockingService;

    @GetMapping("add")
    public ResponseResult<Void> add(HttpSession session) {
        Clocking clocking = new Clocking();
        clocking.setStaffId(((Staff) session.getAttribute("staff")).getId());
        clocking.setDate(LocalDate.now());
        clocking.setTime(LocalTime.now());
        if (clocking.getTime().compareTo(LocalTime.of(9, 0, 0)) < 0 || clocking.getTime().compareTo(LocalTime.of(18, 0, 0)) > 0) {
            clocking.setStatus("正常");
        } else {
            clocking.setStatus("异常");
        }
        clockingService.add(clocking);
        return ResponseResult.ok();
    }

    @GetMapping("delete")
    public ResponseResult<Void> delete(int id) {
        clockingService.delete(id);
        return ResponseResult.ok();
    }

    @GetMapping("list")
    public ResponseResult<PageBean<Clocking>> list(ClockingQO clockingQO, Integer page) {
        if (page == null) {
            page = 1;
        }
        return ResponseResult.ok(clockingService.getByPage(clockingQO, page));
    }

    @GetMapping("plist")
    public ResponseResult<PageBean<Clocking>> plist(HttpSession session,Integer page) {
        if (page == null) {
            page = 1;
        }
        ClockingQO clockingQO = new ClockingQO();
        clockingQO.setStaffId(((Staff) session.getAttribute("staff")).getId());
        return ResponseResult.ok(clockingService.getByPage(clockingQO,page));
    }
}
