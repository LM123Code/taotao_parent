package com.taotao.content.service.impl;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LM_Code
 * @create 2019-05-18-17:37
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    TbContentMapper contentMapper;
    @Override
    public TaotaoResult saveContent(TbContent content) {
        //注入mapper
        //补全其他属性
        content.setCreated(new Date());
        content.setUpdated(content.getCreated());
        //插入内容表中
        contentMapper.insertSelective(content);
        return TaotaoResult.ok();
    }
}
