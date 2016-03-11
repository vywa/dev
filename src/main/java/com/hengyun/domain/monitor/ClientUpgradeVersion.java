package com.hengyun.domain.monitor;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 下午3:28:51
* 客户端版本升级
*/
public class ClientUpgradeVersion implements Serializable{

	private String version;						//版本号
	private int level;									//升级类型
	private Date createDate;					//升级时间
	
	
}
