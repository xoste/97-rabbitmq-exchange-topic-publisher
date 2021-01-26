package com.xoste.rabbitmqexchangetopicpublisher.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户服务
 * @author Leon
 */
@Component
public class UserPublisher {

    @Autowired
    private AmqpTemplate rabbitmqAmqpTemplate;
    /**
     * 交换器的名称
     * */
    @Value("${rabbitmq.config.exchange}")
    private String exchange;

    /**
     * 发送消息的方法
     * */
    public void userPublish(String msg) {
        /**
         * 向消息队列发送消息
         * 参数一：交换器名称
         * 参数二：路由键
         * 参数三：消息内容
         * */
        this.rabbitmqAmqpTemplate.convertAndSend(this.exchange, "user.log.debug", "user.log.debug......" + msg);
        this.rabbitmqAmqpTemplate.convertAndSend(this.exchange, "user.log.info", "user.log.info......" + msg);
        this.rabbitmqAmqpTemplate.convertAndSend(this.exchange, "user.log.warn", "user.log.warn......" + msg);
        this.rabbitmqAmqpTemplate.convertAndSend(this.exchange, "user.log.error", "user.log.error......" + msg);
    }
}
