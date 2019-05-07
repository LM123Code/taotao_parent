package com.taotao.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LM_Code
 * @create 2019-04-29-8:53
 */
@Controller
public class PageContraller {
    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
