package com.taotao.controller;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理内容
 * @author LM_Code
 * @create 2019-05-18-17:43
 */
@Controller
public class ContentController {
    @Autowired
    ContentService contentService;
    @RequestMapping(value = "/content/save", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult saveContent(TbContent content){
        //引入服务
        //注入服务
        //调用
        return contentService.saveContent(content);
    }
}
