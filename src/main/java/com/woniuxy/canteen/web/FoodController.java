package com.woniuxy.canteen.web;

import com.woniuxy.canteen.entity.Customer;
import com.woniuxy.canteen.entity.Food;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.query.FoodQO;
import com.woniuxy.canteen.service.CollectService;
import com.woniuxy.canteen.service.FoodService;
import com.woniuxy.canteen.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("food")
public class FoodController {
    @Resource
    private FoodService foodService;

    @Resource
    private CollectService collectService;

    @Value("${canteen.path}")
    private String uploadPath;

    @PostMapping("add")
    public ResponseResult<Void> list(@RequestBody Food food) {
        foodService.add(food);
        return ResponseResult.ok();
    }

    @PostMapping("update")
    public ResponseResult<Void> update(@RequestBody Food food){
        foodService.update(food);
        return ResponseResult.ok();
    }

    @GetMapping("delete")
    public ResponseResult<Void> delete(int id) {
        foodService.delete(id);
        return ResponseResult.ok();
    }

    @GetMapping("list")
    public ResponseResult<PageBean<Food>> list(FoodQO foodQO, Integer page) {
        if (page == null) {
            page = 1;
        }
        return ResponseResult.ok(foodService.getByPage(foodQO, page));
    }

    @PostMapping("upload")
    public ResponseResult<String> upload(MultipartFile file) {
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "");
        String oriFileName = file.getOriginalFilename();
        String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));
        File dest = new File(uploadPath, newFileName + suffix);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ResponseResult<String> responseResult = new ResponseResult<>();
        responseResult.setCode(200);
        responseResult.setData(newFileName + suffix);
        return responseResult;
    }

    @GetMapping("collect")
    public ResponseResult<Void> collect(int id, HttpSession session) {
        Customer c = (Customer) session.getAttribute("customer");
        collectService.add(c.getId(), id);
        return ResponseResult.ok();
    }

    @GetMapping("cancelCollect")
    public ResponseResult<Void> cancelCollect(int id, HttpSession session) {
        Customer c = (Customer) session.getAttribute("customer");
        collectService.delete(c.getId(), id);
        return ResponseResult.ok();
    }

    @GetMapping("collectList")
    public ResponseResult<PageBean<Food>> plist(HttpSession session, Integer page) {
        int id = ((Customer) session.getAttribute("customer")).getId();
        if (page == null) {
            page = 1;
        }
        return ResponseResult.ok(foodService.getByIdPage(id, page));
    }
}
