package com.hengyun.domain.friendcircle;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 上午11:52:46
* 花名册类
*/
public class Roster implements Serializable{

	private  long rosterID;					//花名册id
	private String username;				//用户名
	private String jid;								//jid
	private int sub;				
	private int ask;
	private int recv;
	private String nick;
	public long getRosterID() {
		return rosterID;
	}
	public void setRosterID(long rosterID) {
		this.rosterID = rosterID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public int getSub() {
		return sub;
	}
	public void setSub(int sub) {
		this.sub = sub;
	}
	public int getAsk() {
		return ask;
	}
	public void setAsk(int ask) {
		this.ask = ask;
	}
	public int getRecv() {
		return recv;
	}
	public void setRecv(int recv) {
		this.recv = recv;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
}
