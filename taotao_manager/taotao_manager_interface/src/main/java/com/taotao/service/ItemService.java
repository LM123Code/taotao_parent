package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

import java.math.BigInteger;
import java.util.List;

/**
 * @author LM_Code
 * @create 2019-04-15-17:36
 */
public interface ItemService {
    public EasyUIDataGridResult getItemList(Integer page, Integer rows);
    public TaotaoResult addItem(TbItem item, String desc);
    public TaotaoResult queryDescById(Long id);
    public TaotaoResult updateItem(TbItem item, String desc);
    public TaotaoResult instock(Long[] ids);
    public TaotaoResult reshelf(Long[] ids);
    public TaotaoResult delete(Long[] ids);
}
