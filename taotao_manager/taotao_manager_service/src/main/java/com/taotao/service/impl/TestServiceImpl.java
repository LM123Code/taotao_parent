package com.taotao.service.impl;

import com.taotao.mapper.TestMapper;
import com.taotao.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试service实现类，查询数据库当前时间
 * @author LM_Code
 * @create 2019-04-14-16:20
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper mapper;
    /**
     * 查询当前时间
     * @return
     */
    @Override
    public String queryNow() {
        //1、注入mapper
        //2、调用查询时间的方法
        return mapper.queryNow();
    }
}
