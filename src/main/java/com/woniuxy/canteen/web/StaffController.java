package com.woniuxy.canteen.web;

import com.woniuxy.canteen.entity.Menu;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.entity.Staff;
import com.woniuxy.canteen.service.MenuService;
import com.woniuxy.canteen.service.StaffService;
import com.woniuxy.canteen.vo.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    @Resource
    private MenuService menuService;

    @PostMapping("add")
    public ResponseResult<Void> add(@RequestBody Staff staff) {
        staffService.add(staff);
        return ResponseResult.ok();
    }

    @PostMapping("update")
    public ResponseResult<Void> update(@RequestBody Staff staff) {
        staffService.update(staff);
        return ResponseResult.ok();
    }

    @GetMapping("delete")
    public ResponseResult<Void> delete(int id) {
        staffService.delete(id);
        return ResponseResult.ok();
    }

    @GetMapping("list")
    public ResponseResult<PageBean<Staff>> list(Staff staff, Integer page) {
        if (page == null) {
            page = 1;
        }
        return ResponseResult.ok(staffService.getByPage(staff, page));
    }

    @PostMapping("login")
    public ResponseResult<Void> login(@RequestBody Staff staff, HttpSession session) {
        Staff s = staffService.login(staff.getAccount());
        if (s.getPassword() != staff.getPassword()) {

        }
        session.setAttribute("staff", s);
        return ResponseResult.ok();
    }

    @GetMapping("sl")
    public ResponseResult<Staff> sl(HttpSession session) {
        return ResponseResult.ok((Staff) session.getAttribute("staff"));
    }

    @GetMapping("menus")
    public ResponseResult<List<Menu>> menus(HttpSession session) {
        Staff staff = (Staff) session.getAttribute("staff");
        return ResponseResult.ok(menuService.getByStaffId(staff.getId()));
    }

    @GetMapping("getChiefs")
    public ResponseResult<List<Staff>> chiefs() {
        List<Staff> staffs = staffService.getAll();
        List<Staff> chiefs = new ArrayList<>();
        for (Staff staff : staffs) {
            if (staff.getRole().equals("c")) {
                chiefs.add(staff);
            }
        }
        return ResponseResult.ok(chiefs);
    }
}
