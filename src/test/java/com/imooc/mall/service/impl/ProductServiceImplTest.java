package com.imooc.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.service.IProductService;
import com.imooc.mall.vo.ProductDetailVo;
import com.imooc.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ProductServiceImplTest {
    @Autowired
    private IProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void list() {
        ResponseVo<PageInfo> list = productService.list(null, 1, 2);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), list.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo<ProductDetailVo> detail = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), detail.getStatus());
    }
}