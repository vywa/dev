package com.hengyun.service.impl.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.hengyun.domain.message.Mail;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月26日 下午2:14:48
* 消息类型转换器
*/
public class MailMessageConverter implements MessageConverter{

	private static transient Logger log = LoggerFactory.getLogger(MailMessageConverter.class);
	//将消息转换为类
	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		// TODO Auto-generated method stub
		if(message instanceof ObjectMessage){
			ObjectMessage om = (ObjectMessage)message;
			if(om instanceof ActiveMQObjectMessage){
				ActiveMQObjectMessage amsg = (ActiveMQObjectMessage)om;
				try{
					Mail mail = (Mail)amsg.getObject();
					return mail;
				}catch(Exception e){
					throw new JMSException("Message:["+message+"] 类型不正确");
				}

		} else {
			throw new JMSException("Message:["+message+"] 类型不正确");
		}
		}else {
			throw new JMSException("Message:["+message+"] 类型不正确");
		}
		
	}

	//将类转换为消息
	@Override
	public Message toMessage(Object obj, Session session) throws JMSException, MessageConversionException {
		// TODO Auto-generated method stub
		if(obj instanceof Mail){
			ActiveMQObjectMessage msg = (ActiveMQObjectMessage)session.createObjectMessage();
			msg.setObject((Mail)obj);
			return msg;
		} else {
			throw new JMSException("Object:["+obj+"] 类型不正确");
		}
		
	}

}
