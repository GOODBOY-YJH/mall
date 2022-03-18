package com.imooc.mall.dao;

import com.imooc.mall.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest  {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void contextLoads() {
        Category category = categoryMapper.findById(100002);
        System.out.println(category);
    }

    @Test
    public void queryByIdTest() {
        Category category = categoryMapper.queryById(100002);
        System.out.println(category);
    }
}