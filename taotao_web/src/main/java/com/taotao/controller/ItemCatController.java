package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类管理
 *
 * @author LM_Code
 * @create 2019-04-19-15:52
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    //注入服务
    @Autowired
    ItemCatService itemCatService;
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name = "id", defaultValue = "0") long parentId){
        List<EasyUITreeNode> itemCatList = itemCatService.getItemCatList(parentId);
        return itemCatList;
    }
}
