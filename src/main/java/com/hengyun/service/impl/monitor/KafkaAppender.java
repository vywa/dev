package com.hengyun.service.impl.monitor;



import java.util.Properties;

import javax.xml.rpc.encoding.Serializer;

import com.hengyun.service.monitor.Formatter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月24日 下午3:08:39
* logback kafka　日志接收类
*/
public class KafkaAppender extends AppenderBase<ILoggingEvent>{

	private String topic ;
	private String zookeeperHost;
	
//	private Producer<String,String> producer;
	private Formatter formatter;
	
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getZookeeperHost() {
		return zookeeperHost;
	}

	public void setZookeeperHost(String zookeeperHost) {
		this.zookeeperHost = zookeeperHost;
	}

	public Formatter getFormatter() {
		return formatter;
	}

	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}

	@Override
	protected void append(ILoggingEvent event) {
		// TODO Auto-generated method stub
		String payload = this.formatter.format(event);
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		if(this.formatter == null){
			this.formatter = new MessageFormatter();
		}
		super.start();
		Properties props = new Properties();
		props.put("zk.connect", this.zookeeperHost);
		props.put(Serializer.class, "Kafka.serializer.StringEncoder");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

}
