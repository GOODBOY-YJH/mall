package com.imooc.mall.listener;

import com.google.gson.Gson;
import com.imooc.mall.pojo.PayInfo;
import com.imooc.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "payNotify")
@Slf4j
public class PayMegListener {
    @Autowired
    private IOrderService orderService;
    /**
     * 关于payInfo 正确姿势： pay项目提高client.jar mall项目引用jar包
     * @param msg
     */
    @RabbitHandler
    public void process(String msg){
        log.info("接收到消息=>{}",msg);
        PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
        if (payInfo.getPlatformStatus().equals("SUCCESS")){
            // 修改订单里的状态
            orderService.paid(payInfo.getOrderNo());
        }
    }
}
