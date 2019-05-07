package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LM_Code
 * @create 2019-04-15-17:58
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    /**
     * 分页查询item，get请求方法
     * @param page 页数
     * @param rows 行数
     * @return json数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows){
        //1、在配置文件中引入服务
        //2、注入服务
        //3、调用服务的方法
        System.out.println("开始查询");
        EasyUIDataGridResult easyUIDataGridResult = itemService.getItemList(page, rows);
        System.out.println(easyUIDataGridResult.getTotal());
        List<TbItem> list = easyUIDataGridResult.getRows();
        for (TbItem tbItem : list) {
            System.out.println(tbItem.getId() + "  " + tbItem.getTitle());
        }
        return easyUIDataGridResult;
    }
    /**
     * 插入商品
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult addItem(TbItem item, String desc){
        TaotaoResult taotaoResult = itemService.addItem(item, desc);
        return taotaoResult;
    }
    /**
     * 根据id查询item的desc
     */
    @RequestMapping(value = "/desc", method = RequestMethod.GET)
    @ResponseBody
    public TaotaoResult queryDescById(Long id){
        return itemService.queryDescById(id);
    }
    /**
     * 修改商品
     */
    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateItem(TbItem item, String desc){
        System.out.println(item);
        return itemService.updateItem(item, desc);
    }
    /**
     * 删除商品
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult delete(Long[] ids){
        return itemService.delete(ids);
    }
    /**
     * 下架商品
     */
    @RequestMapping(value = "/instock", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult instock(Long[] ids){
        return itemService.instock(ids);
    }
    /**
     * 上架商品
     */
    @RequestMapping(value = "/reshelf", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult reshelf(Long[] ids){
        return itemService.reshelf(ids);
    }
}
