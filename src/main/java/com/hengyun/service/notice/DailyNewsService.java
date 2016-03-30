package com.hengyun.service.notice;

import com.hengyun.domain.notice.DailyNews;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 下午2:25:24
* 每日消息业务接口
*/
public interface DailyNewsService extends BaseService<DailyNews,Integer>{

	/*
	 * 
	 *  添加咨讯
	 * 
	 * */
	public void add(DailyNews dn);
	
	/*
	 * 
	 *  查询资讯
	 * 
	 * */
	public DailyNews query(int id);
}
