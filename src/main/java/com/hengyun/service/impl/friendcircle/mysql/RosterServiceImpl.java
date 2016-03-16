package com.hengyun.service.impl.friendcircle.mysql;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hengyun.dao.friendcircle.mysql.RosterDao;
import com.hengyun.domain.friendcircle.Roster;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.information.InformationService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 下午1:37:55
* 花名册业务实现类
*/
@Service
public class RosterServiceImpl implements RosterService{

	@Resource
	private RosterDao rosterDao;
	
	@Resource
	private InformationService informationService; 
	
	
	@Override
	public List<Integer> getFriendList(String username) {
		// TODO Auto-generated method stub
		List<Roster> roster = rosterDao.getRoster(username);
		List<Integer> idList = new ArrayList<Integer>();
		for(Roster temp : roster){
			String name = temp.getJid();
			
			int index = name.indexOf("@");
			String idstr = name.substring(0, index);
			System.out.println(idstr);
			idList.add(Integer.valueOf(idstr));
		}
		return idList;
	}

	/*
	 *  模糊查询
	 * */
	@Override
	public List<Integer> searchFriendList(String username, String searchName) {
		// TODO Auto-generated method stub
		List<Roster> roster = rosterDao.getRoster(username);
		List<Integer> idList = new ArrayList<Integer>();
		for(Roster temp : roster){
			String name = temp.getJid();
			int index = name.indexOf("@");
			String idstr = name.substring(0, index);
			idList.add(Integer.valueOf(idstr));
		}
		return idList;
		
	}

}
