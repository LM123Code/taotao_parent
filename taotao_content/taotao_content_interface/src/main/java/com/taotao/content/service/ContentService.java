package com.taotao.content.service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * 内容处理的接口
 * @author LM_Code
 * @create 2019-05-18-17:35
 */
public interface ContentService {
    /**
     * 插入内容
     * @param content
     * @return
     */
    public TaotaoResult saveContent(TbContent content);
}
