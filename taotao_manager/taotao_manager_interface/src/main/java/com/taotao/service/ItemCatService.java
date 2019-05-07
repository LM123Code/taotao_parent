package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;
import java.util.List;

/**
 * 商品分类管理
 * @author LM_Code
 * @create 2019-04-19-15:27
 */
public interface ItemCatService {
    public List<EasyUITreeNode> getItemCatList(long parentId);
}
