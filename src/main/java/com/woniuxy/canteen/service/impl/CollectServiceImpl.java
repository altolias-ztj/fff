package com.woniuxy.canteen.service.impl;

import com.woniuxy.canteen.mapper.CollectMapper;
import com.woniuxy.canteen.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;


    @Override
    public void add(int cId, int fId) {
        collectMapper.add(cId, fId);
    }

    @Override
    public void delete(int cId, int fId) {
        collectMapper.delete(cId, fId);
    }
}
