package com.hengyun.domain.hospital;

import java.util.List;

import com.hengyun.domain.docter.Docter;
import com.hengyun.domain.location.Location;

/*
 *  医院信息
 * 
 * 

 * */
public class Hospital {

	private int id;																//医院ID
	private String hospitalName;									//医院名称
	private String address;												//医院地址
	private List<AdministrativeOffice> administrativeOfficeList;		//医院科室列表
	private String telephone;											//医院电话
	private String email;													//医院邮件
	private String hospitalIM;										//医院即时通讯号
	private String WeiChatPublicNumber;				//医院公众号
	private List<Docter> docterList;							//医生列表
	private Location	location;										//医院坐标
}
