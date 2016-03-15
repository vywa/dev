package com.hengyun.dao.impl.notice;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.notice.MedicalNoticeDao;
import com.hengyun.domain.notice.MedicalNotice;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月15日 下午5:04:38
* 医疗通知类数据访问层
*/
public class MedicalNoticeDaoImpl extends BaseMongodbDaoImpl<MedicalNotice,Integer> implements MedicalNoticeDao{

	@Override
	protected Class<MedicalNotice> getEntityClass() {
		// TODO Auto-generated method stub
		return MedicalNotice.class;
	}

}
