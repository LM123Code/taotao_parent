package com.taotao.mapper;

/**
 * 测试mapper接口，查询当前数据库时间
 * @author LM_Code
 * @create 2019-04-14-16:05
 */
public interface TestMapper {
    /**
     * 查询当前时间
     * @return
     */
    public String queryNow();
}
