package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LM_Code
 * @create 2019-04-15-14:55
 */
@Controller
public class PageController {
    /**
     * 首页设置
     * @return
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
    /**
     * 显示商品的查询页面（item相关页面）
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        System.out.println(page);
        return page;
    }
}
