package com.hengyun.service.impl.monitor.logbackFlume;

import java.nio.charset.Charset;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月24日 下午3:43:37
* flume事件记录器
*/
public class FlumeEventWriter {

	private FlumeAppender flumeAppender;
	
	public FlumeEventWriter(FlumeAppender flumeAppender){
		this.flumeAppender = flumeAppender;
	}
	
	public void sendFlumeEvent(ILoggingEvent event){
		/*
		RpcClient rpcClient = null;
		
		try {
			Event flumeEvent = EventBuilder.withBody(flumeAppender.getLayout().doLayout(event),
					Charset.forName("UTF-8"));
			rpcClient = RpcClientFactory.getDefaultInstance(flumeAppender.getHost(), flumeAppender.getPort());
			rpcClient.appender(flumeEvent);
		} catch(EventDeliveryException e){
			flumeAppender.addError("Error sending event to flume: "+e.getMessage());
			
		} finally {
			// TODO: handle finally clause
			if(rpcClient != null){
				try {
					rpcClient.close();
				} catch (FlumeException e) {
					// TODO Auto-generated catch block
					flumeAppender.addError("Error closing RpcClient: "+ e.getMessage());
				}
			}
		}
		*/
	}
	
}
