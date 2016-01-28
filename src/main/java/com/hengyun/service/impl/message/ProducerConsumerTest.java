package com.hengyun.service.impl.message;

import javax.annotation.Resource;
import javax.jms.Destination;




import com.hengyun.service.message.ProducerService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
public class ProducerConsumerTest {

	@Resource
	private ProducerService producerService;
	@Resource

	 private Destination adapterQueue;   
	
	
	public void testSend(){
		for(int i=0;i<2;i++){
	//		producerService.sendMessage(destination, "你好，生产者，这是消息: "+(i+1));
		//	producerService.sendMessage(sessionAwareQueue, " 测试SessionAwareMessageListener");
			producerService.sendMessage(adapterQueue, "测试MessageListenerAdapter");
		}
	}
}
