package com.hengyun.dao.impl.patient;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.patient.HabitInfoDao;
import com.hengyun.domain.casehistory.HabitInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月1日 下午3:58:54
* 健康习惯数据访问层
*/
public class HabitInfoDaoImpl extends BaseMongodbDaoImpl<HabitInfo,Integer> implements HabitInfoDao{

	@Override
	protected Class<HabitInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return HabitInfo.class;
	}


}
