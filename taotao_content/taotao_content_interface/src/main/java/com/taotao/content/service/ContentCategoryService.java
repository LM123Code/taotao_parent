package com.taotao.content.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.utils.TaotaoResult;

import java.util.List;

/**
 * @author LM_Code
 * @create 2019-05-15-15:43
 */
public interface ContentCategoryService {
    //通过结点的id查询该节点的子节点列表
    public List<EasyUITreeNode> getContentCategoryList(Long parentId);
    //添加内容分类
    public TaotaoResult createContentCategory(Long parentId, String name);
}
