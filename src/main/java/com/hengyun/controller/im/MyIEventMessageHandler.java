package com.hengyun.controller.im;

import org.weixin4j.message.OutputMessage;
import org.weixin4j.message.event.ClickEventMessage;
import org.weixin4j.message.event.LocationEventMessage;
import org.weixin4j.message.event.LocationSelectEventMessage;
import org.weixin4j.message.event.PicPhotoOrAlbumEventMessage;
import org.weixin4j.message.event.PicSysPhotoEventMessage;
import org.weixin4j.message.event.PicWeixinEventMessage;
import org.weixin4j.message.event.QrsceneScanEventMessage;
import org.weixin4j.message.event.QrsceneSubscribeEventMessage;
import org.weixin4j.message.event.ScanCodePushEventMessage;
import org.weixin4j.message.event.ScanCodeWaitMsgEventMessage;
import org.weixin4j.message.event.SubscribeEventMessage;
import org.weixin4j.message.event.UnSubscribeEventMessage;
import org.weixin4j.message.event.ViewEventMessage;
import org.weixin4j.message.output.TextOutputMessage;
import org.weixin4j.spi.IEventMessageHandler;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月6日 下午4:25:43
* 事件处理
*/
public class MyIEventMessageHandler implements IEventMessageHandler{

	@Override
	public OutputMessage subscribe(SubscribeEventMessage msg) {
		// TODO Auto-generated method stub
	    TextOutputMessage out = new TextOutputMessage();
	    String text =  "欢迎光临爱情心路。\n这里有唯美的爱情故事，动听的音乐\n"
	            				+ "幽默的笑话，有趣的游戏\n还有更多的知识哦\n在这里我们去一起见证一个更好的自我吧!";
        out.setContent(text);
        return out;
	}

	@Override
	public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage location(LocationEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage click(ClickEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage view(ViewEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage picWeixin(PicWeixinEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage locationSelect(LocationSelectEventMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
