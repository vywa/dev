package com.hengyun.domain.loginInfo;

import java.io.Serializable;

/*
 *  用户账号基本信息
 * */
public class UserAccount implements Serializable{


	/**
	 * 
	 */

	private int id;																			//用户ID
	private String 							catagory; 								//用户类型（系统管理员=1,用户管理员，医生2，病人3，游客）
	private String 							username;							//用户名
	private String 							mobilephone;					//用户手机号
	private String 							email;									//用户邮箱
	private String							workNum;							//工号
	private String 							QQ;										//QQ
	private String							weiChat;								//weiChat
	private String							weiBo;									//weiBo
	
	private String							password;							//用户密码
	private String 							status;									//用户账号状态
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getWorkNum() {
		return workNum;
	}


	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}


	public String getCatagory() {
		return catagory;
	}


	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}


	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getMobilephone() {
		return mobilephone;
	}


	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



		public UserAccount() {
		super();
	}


		public String getQQ() {
			return QQ;
		}


		public void setQQ(String qQ) {
			QQ = qQ;
		}


		public String getWeiChat() {
			return weiChat;
		}


		public void setWeiChat(String weiChat) {
			this.weiChat = weiChat;
		}


		public String getWeiBo() {
			return weiBo;
		}


		public void setWeiBo(String weiBo) {
			this.weiBo = weiBo;
		}


		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Id"+id+"\n");
			sb.append("Catagory"+catagory+"\n");
			sb.append("Username"+username+"\n");
			sb.append("Mobilephone"+mobilephone+"\n");
			sb.append("Email"+email+"\n");
			sb.append("WorkNum"+workNum+"\n");
			sb.append("QQ"+QQ+"\n");
			sb.append("WeiChat"+weiChat+"\n");
			sb.append("WeiBo"+weiBo+"\n");
			sb.append("Wassword"+password+"\n");
			sb.append("Wtatus"+status+"\n");
			return sb.toString();
		}

	
	
}

