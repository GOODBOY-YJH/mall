package com.imooc.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private IOrderService orderService;

    private Integer uid = 1;

    private Integer shippingId = 4;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void create() {
        ResponseVo<OrderVo> orderVoResponseVo = orderService.create(uid, shippingId);
        log.info("orderVoResponseVo={}", gson.toJson(orderVoResponseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), orderVoResponseVo.getStatus());
    }
    public ResponseVo<OrderVo> create1() {
        ResponseVo<OrderVo> orderVoResponseVo = orderService.create(uid, shippingId);
        log.info("orderVoResponseVo={}", gson.toJson(orderVoResponseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), orderVoResponseVo.getStatus());
        return orderVoResponseVo;
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = orderService.list(uid, 1, 10);
        log.info("orderVoResponseVo={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo<OrderVo> vo = create1();
        ResponseVo<OrderVo> responseVo = orderService.detail(uid, vo.getData().getOrderNo());
        log.info("detailVoResponseVo={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void cancel() {
        ResponseVo<OrderVo> vo = create1();
        ResponseVo<OrderVo> responseVo = orderService.cancel(uid, vo.getData().getOrderNo());
        log.info("detailVoResponseVo={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}