package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LM_Code
 * @create 2019-04-19-15:29
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    //注入dao层mapper
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        Criteria criteria = example.createCriteria();//创建查询条件
        criteria.andParentIdEqualTo(parentId);//设置查询条件
        //根据父节点查询子节点列表
        List<TbItemCat> list = itemCatMapper.selectByExample(example);//根据条件查询
        //创建返回的list，即EasyUITreeNode的集合
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbItemCat itemCat : list) {
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(itemCat.getId());
            easyUITreeNode.setText(itemCat.getName());
            easyUITreeNode.setState(itemCat.getIsParent()?"closed":"open");
            resultList.add(easyUITreeNode);
        }
        return resultList;
    }
}
