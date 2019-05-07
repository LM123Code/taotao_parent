package com.taotao.controller;

import com.taotao.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试使用的controller，查询当前时间
 * @author LM_Code
 * @create 2019-04-14-16:43
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    //根据springmvc中的配置：<dubbo:reference interface="com.taotao.service.TestService" id="testService" />可以找到，忽略此错误提示
    private TestService testService;
    @RequestMapping("/queryNow")
    @ResponseBody
    public String queryNow(HttpServletResponse response) throws IOException {
        //1、引入服务
        //2、注入服务
        //3、调用服务的方法
        return testService.queryNow();
    }
}
