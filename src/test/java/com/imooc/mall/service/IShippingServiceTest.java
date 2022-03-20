package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
// @Transactional
@Slf4j
public class IShippingServiceTest {

    @Autowired
    private IShippingService service;

    private Integer uid = 1;

    @Test
    public void add() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("狗东西2");
        form.setReceiverAddress("我家");
        form.setReceiverCity("北京");
        form.setReceiverMobile("123456789");
        form.setReceiverPhone("345678990");
        form.setReceiverProvince("xx区");
        form.setReceiverDistrict("海淀区");
        form.setReceiverZip("00000");
        ResponseVo<Map<String, Integer>> add = service.add(uid, form);
        log.info("add={}", add);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), add.getStatus());
    }

    @Test
    public void delete() {
        Integer shippingId = 9;
        ResponseVo responseVo = service.delete(uid, shippingId);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
        Integer shippingId = 7;
        ShippingForm form = new ShippingForm();
        form.setReceiverName("狗东西2");
        form.setReceiverAddress("我家");
        form.setReceiverCity("北京");
        form.setReceiverMobile("123456789");
        form.setReceiverPhone("345678990");
        form.setReceiverProvince("xx区");
        form.setReceiverDistrict("海淀区");
        form.setReceiverZip("00000");
        ResponseVo<Map<String, Integer>> responseVo = service.update(uid, shippingId, form);
        log.info("responseVo={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = service.list(uid, 1, 10);
        log.info("responseVo={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}