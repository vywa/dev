package com.hengyun.service.im;

import java.util.List;

import com.hengyun.domain.im.IMContent;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月6日 上午8:23:40
* 类说明
*/
public interface IMContentService extends BaseService<IMContent,Integer>{

	/*
	 *  保存某个聊天记录
	 * */
	public int collect(IMContent imContent,int userId);
	
	/*
	 *  查看某人的聊天记录
	 * */
	public List<IMContent> viewList(int userId);
	
}
