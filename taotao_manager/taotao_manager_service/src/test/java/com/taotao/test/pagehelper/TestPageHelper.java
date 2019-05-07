//package com.taotao.test.pagehelper;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.taotao.mapper.TbItemMapper;
//import com.taotao.pojo.TbItem;
//import com.taotao.pojo.TbItemExample;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import java.util.List;
//
///**
// * @author LM_Code
// * @create 2019-04-15-16:47
// */
//public class TestPageHelper {
//    @Test
//    public void testHelper(){
//        //初始化spring容器
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_dao.xml");
//        //获取mapper的代理对象
//        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
//        //设置分页信息
//        PageHelper.startPage(1, 3);
//        //调用方法查询数据
//        TbItemExample example = new TbItemExample();//设置查询条件
//        List<TbItem> list = itemMapper.selectByExample(example);
//        List<TbItem> list2 = itemMapper.selectByExample(example);
//        //取分页的信息
//        PageInfo<TbItem> info = new PageInfo<>(list);
//        //遍历结果集
//        System.out.println(list.size());
//        System.out.println(list2.size());
//        System.out.println(info.getTotal());
//        for (TbItem tbItem : list) {
//            System.out.println(tbItem.getId() + "    " + tbItem.getTitle());
//        }
//    }
//}
