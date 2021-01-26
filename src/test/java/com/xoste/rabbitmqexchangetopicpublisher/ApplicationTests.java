package com.xoste.rabbitmqexchangetopicpublisher;

import com.xoste.rabbitmqexchangetopicpublisher.publisher.OrderPublisher;
import com.xoste.rabbitmqexchangetopicpublisher.publisher.ProductPublisher;
import com.xoste.rabbitmqexchangetopicpublisher.publisher.UserPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserPublisher userPublisher;
    @Autowired
    private ProductPublisher productPublisher;
    @Autowired
    private OrderPublisher orderPublisher;

	@Test
	void contextLoads() {
	    this.userPublisher.userPublish("发送userPublisher的消息");
	    this.productPublisher.productPublish("发送productPublisher的消息");
	    this.orderPublisher.orderPublish("发送orderPublisher的消息");
	}

}
