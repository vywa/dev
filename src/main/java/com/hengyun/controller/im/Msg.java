package com.hengyun.controller.im;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月4日 上午10:04:23
* 类说明
*/
@XStreamAlias("msg")
public class Msg implements Serializable {
 
    private static final long serialVersionUID = 3196422897798539811L;
     
    @XStreamAsAttribute
    private String toUid;
    @XStreamAsAttribute
    private String fromUid;
    @XStreamAsAttribute
    private String flag;
    @XStreamAsAttribute
    private String time;
    @XStreamAlias("content")
    private String content;
    @XStreamAlias("user")
    private String user;
    
    
	public String getToUid() {
		return toUid;
	}
	public void setToUid(String toUid) {
		this.toUid = toUid;
	}
	public String getFromUid() {
		return fromUid;
	}
	public void setFromUid(String fromUid) {
		this.fromUid = fromUid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
   
    
}