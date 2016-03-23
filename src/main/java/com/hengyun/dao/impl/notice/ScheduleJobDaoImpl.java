package com.hengyun.dao.impl.notice;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.notice.ScheduleJobDao;
import com.hengyun.domain.notice.ScheduleJob;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月23日 上午11:18:09
* 任务类数据访问接口
*/
public class ScheduleJobDaoImpl extends BaseMongodbDaoImpl<ScheduleJob,Integer> implements ScheduleJobDao{

	@Override
	protected Class<ScheduleJob> getEntityClass() {
		// TODO Auto-generated method stub
		return ScheduleJob.class;
	}

}
