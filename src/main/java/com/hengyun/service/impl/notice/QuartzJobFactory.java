package com.hengyun.service.impl.notice;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.hengyun.domain.notice.ScheduleJob;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月23日 上午10:44:54
* 定时任务运行工厂类
*/
public class QuartzJobFactory implements Job{

	private static final Logger log = LoggerFactory.getLogger(QuartzJobFactory.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtil.invokMethod(scheduleJob);
	}

}
