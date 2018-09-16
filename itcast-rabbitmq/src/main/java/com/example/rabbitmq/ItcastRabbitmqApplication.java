package com.example.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class ItcastRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItcastRabbitmqApplication.class, args);
	}

	/*
	* (1)Failed to declare queue(s):[test_queue_springboot_auto]
	* (2)no queue 'test_queue_springboot_auto' in vhost '/taotao'
	* (3) 有了下面的myQueue配置：测试通过， 但是还是拿不到数据
	*     no exchange 'test_exchange_springboot_auto' in vhost '/taotao'
	*     在界面上可以看到test_queue_springboot_auto被创建出来了
	* (4)
	* */
	@Bean
	public Queue myQueue(){
		return new Queue("test_queue_springboot_auto");
	}

	// 配置了test_exchange_springboot_auto的TopicExchange
	@Bean
	public FanoutExchange exchange() {
		return new FanoutExchange("test_exchange_springboot_auto");
	}
	// fanoutExchange与queue绑定起来
	// queue，exchange创建好，然后绑定起来，最后测试，可以得到消息数据了
	@Bean
	public Binding bindingExchangeB(){
		return BindingBuilder.bind(myQueue()).to(exchange());
	}
}
