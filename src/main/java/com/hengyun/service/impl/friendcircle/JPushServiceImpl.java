package com.hengyun.service.impl.friendcircle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月14日 下午8:12:56
* 消息推送服务
*/
public class JPushServiceImpl {

	private static final Logger Log = LoggerFactory.getLogger(JPushServiceImpl.class);
	private static final String masterSecret =  "345068636976b9699fe17727";
	private static final String appKey = "c64872178fa2d308a98bbebf"; 
	public static void main(String[] args){
		JPushClient jpushClient = new JPushClient(masterSecret,appKey,3);
		PushPayload payload = buildPushObject_all_all_alert();
		try{
			PushResult result = jpushClient.sendPush(payload);
			Log.info("get result :"+result);
		} catch(APIConnectionException e){
			 Log.error("Connection error, should retry later", e);
		} catch(APIRequestException e){
			Log.error("Should review the error, and fix the request", e);
			Log.info("HTTP Status: " + e.getStatus());
			Log.info("Error Code: " + e.getErrorCode());
			Log.info("Error Message: " + e.getErrorMessage());
		}
	}
	
	public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll("hello");
        
    }
}
