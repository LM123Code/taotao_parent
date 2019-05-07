package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @author LM_Code
 * @create 2019-04-15-17:37
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper mapper;//注入mapper
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemCatMapper itemCatMapper;

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //1、设置分页信息，使用pagehelper
        if(page == null) page = 1;
        if(rows == null) rows = 30;
        PageHelper.startPage(page, rows);
        System.out.println("查询商品：第 " + page + " 页，共 " + rows + " 条");
        //2、注入mapper
        //3、创建example对象，不需要设置查询条件
        TbItemExample example = new TbItemExample();
        //4、调用方法查询数据
        List<TbItem> list = mapper.selectByExample(example);
        //5、取分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);
        System.out.println("查询结果共 " + info.getTotal() + " 条");
        //6、封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int)info.getTotal());
        result.setRows(info.getList());
        for (TbItem tbItem : list) {
            System.out.println(tbItem.getId() + "    " + tbItem.getTitle());
        }
        //7、返回
        return result;
    }

    /**
     * 插入商品
     * @param item
     * @param desc
     * @return
     */
    @Override
    public TaotaoResult addItem(TbItem item, String desc) {
        //生成商品id
        long id = IDUtils.genItemId();
        //补全商品信息
        item.setId(id);
        item.setStatus((byte) 1);//1正常 2下架 3删除
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //插入商品
        mapper.insert(item);
        //创建商品描述表对应的pojo对象
        TbItemDesc itemDesc = new TbItemDesc();
        //补全信息
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(item.getCreated());
        itemDesc.setUpdated(item.getUpdated());
        //向商品描述表插入信息
        itemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();
    }
    //根据id查找TbItemDesc
    @Override
    public TaotaoResult queryDescById(Long id) {
        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(id);
        return TaotaoResult.ok(itemDesc);
    }

    /**
     * 更新商品
     * @param item
     * @param desc
     * @return
     */
    @Override
    public TaotaoResult updateItem(TbItem item, String desc) {
        //补全信息
        item.setUpdated(new Date());
        //修改商品
        mapper.updateByPrimaryKeySelective(item);
        //创建商品描述表对应的pojo对象
        TbItemDesc itemDesc = new TbItemDesc();
        //补全信息
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(item.getUpdated());
        //向商品描述更新信息
        itemDescMapper.updateByPrimaryKeySelective(itemDesc);
        return TaotaoResult.ok();
    }

    /**
     * 下架商品
     * @param ids
     * @return
     */
    @Override
    public TaotaoResult instock(Long[] ids) {
        TbItem item = new TbItem();
        item.setStatus((byte) 2);//状态改为下架
        for (Long id : ids) {
            item.setId(id);
            mapper.updateByPrimaryKeySelective(item);
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult reshelf(Long[] ids) {
        TbItem item = new TbItem();
        item.setStatus((byte)1);//状态改为上架
        for (Long id : ids) {
            item.setId(id);
            mapper.updateByPrimaryKeySelective(item);
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult delete(Long[] ids) {
        for (Long id : ids) {
            mapper.deleteByPrimaryKey(id);
        }
        return TaotaoResult.ok();
    }
}
