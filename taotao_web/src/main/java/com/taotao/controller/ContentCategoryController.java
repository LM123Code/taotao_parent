package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类的处理
 * @author LM_Code
 * @create 2019-05-17-15:10
 */
@Controller
public class ContentCategoryController {
    @Autowired
    ContentCategoryService contentCategoryService;

    /**
     * 查询结点
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/content/category/list", method = RequestMethod.GET)
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id", defaultValue = "0") Long parentId){
        //引入服务
        //注入
        //调用服务
        return contentCategoryService.getContentCategoryList(parentId);
    }

    /**
     * 添加结点
     * @param parentId
     * @param name
     * @return
     */
    @RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createContentCategory(Long parentId, String name){
        return contentCategoryService.createContentCategory(parentId, name);
    }
}
