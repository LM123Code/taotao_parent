package com.taotao.content.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 内容分类
 * @author LM_Code
 * @create 2019-05-17-14:41
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<EasyUITreeNode> getContentCategoryList(Long parentId) {
        //注入mapper
        //创建example
        TbContentCategoryExample example = new TbContentCategoryExample();
        //设置条件
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> contentCategories = contentCategoryMapper.selectByExample(example);
        //转成EasyUITreeNode
        List<EasyUITreeNode> nodes = new ArrayList<>();
        for (TbContentCategory contentCategory : contentCategories) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(contentCategory.getId());
            node.setState(contentCategory.getIsParent()?"closed":"open");
            node.setText(contentCategory.getName());
            nodes.add(node);
        }
        return nodes;
    }

    @Override
    public TaotaoResult createContentCategory(Long parentId, String name) {
        //构建对象，补全其他的属性
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setCreated(new Date());
        contentCategory.setIsParent(false);
        contentCategory.setName(name);
        contentCategory.setParentId(parentId);
        contentCategory.setSortOrder(1);
        contentCategory.setStatus(1);
        contentCategory.setUpdated(contentCategory.getCreated());
        //插入ContentCategory表数据
        contentCategoryMapper.insert(contentCategory);
        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
        if(!parent.getIsParent()){
            parent.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKeySelective(parent);
        }
        //返回TaotaoResult 包含内容分类的id 需要主键返回
        return TaotaoResult.ok(contentCategory);
    }
}
