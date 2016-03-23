package com.hengyun.service.impl.notice;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.hengyun.domain.notice.ScheduleJob;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月23日 下午3:37:41
* 类说明
*/
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {
	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtil.invokMethod(scheduleJob);

	}
}