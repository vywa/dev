package com.hengyun.dao.notice.mysql;

import java.util.List;

import com.hengyun.domain.notice.ScheduleJob;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月23日 下午3:03:59
* 类说明
*/
public interface JobTaskDao {

	int deleteByPrimaryKey(Long jobId);

	int insert(ScheduleJob record);

	int insertSelective(ScheduleJob record);

	ScheduleJob selectByPrimaryKey(Long jobId);

	int updateByPrimaryKeySelective(ScheduleJob record);

	int updateByPrimaryKey(ScheduleJob record);

	List<ScheduleJob> getAll();
}
