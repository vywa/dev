package com.hengyun.service.impl.forum.util;

import java.util.List;

import com.hengyun.domain.forum.Subject;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月6日 下午3:03:46
* 类说明
*/
public class SubjectToResponse {

	public static Subject transfer(Subject subject,int userId){
//		Subject newSubject = subject.
		List<Integer> list = subject.getCollectPersons();
	
		if(list!=null){
		
		for(int temp:list){
			System.out.println(temp+"");
			if(temp==userId) {
				subject.setCollection(true);
				
			}
		}
		}
		
		list = subject.getLikePersons();
		if(list!=null){
			
		for(int temp:list){
			if(temp==userId)  subject.setLiked(true);
		}
		}
		subject.setCollectPersons(null);
		subject.setLikePersons(null);
		return subject;
	}
}
