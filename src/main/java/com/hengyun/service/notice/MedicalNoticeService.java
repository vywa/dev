package com.hengyun.service.notice;

import java.util.List;

import com.hengyun.domain.notice.MedicalNotice;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月15日 下午5:17:46
* 医疗通知业务层
*/
public interface MedicalNoticeService extends BaseService<MedicalNotice,Integer>{

	/*
	 *  添加医疗通知
	 * */
	public void addNotice(MedicalNotice medicalNotice);
	
	/*
	 *  处理医疗通知
	 * */
	public void handleNotice(int noticeId);
	
	/*
	 *  查询某个医生的医疗通知
	 * */
	public List<MedicalNotice> queryNotice(int noticeFromId);
	
	/*
	 *  查询某个医生的某个病人的医疗通知
	 * */
	public MedicalNotice query(int noticeFromId,int noticeToId);
}
