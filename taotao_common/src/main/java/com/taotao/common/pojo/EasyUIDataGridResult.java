package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 商品列表查询的返回的数据类
 * @author LM_Code
 * @create 2019-04-15-17:25
 */
public class EasyUIDataGridResult implements Serializable {
    private Integer total;
    private List rows;
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
}
