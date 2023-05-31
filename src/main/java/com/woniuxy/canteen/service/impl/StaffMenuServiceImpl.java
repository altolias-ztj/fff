package com.woniuxy.canteen.service.impl;

import com.woniuxy.canteen.mapper.StaffMenuMapper;
import com.woniuxy.canteen.service.StaffMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StaffMenuServiceImpl implements StaffMenuService {
    @Resource
    private StaffMenuMapper staffMenuMapper;

    @Override
    public void add(int sId, int mId) {
        staffMenuMapper.add(sId, mId);
    }

    @Override
    public void delete(int sId, int mId) {
        staffMenuMapper.delete(sId, mId);
    }
}
