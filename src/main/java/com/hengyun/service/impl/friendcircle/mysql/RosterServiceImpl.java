package com.hengyun.service.impl.friendcircle.mysql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.hengyun.dao.friendcircle.mysql.RosterDao;
import com.hengyun.domain.friendcircle.Roster;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.UserAccountService;

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
	
	@Resource
	private UserAccountService userAccountService;
	/*
	 *  获取医生
	 * */
	@Override
	public int getDoctor(String username) {
		// TODO Auto-generated method stub
		List<Roster> roster = rosterDao.getRoster(username);
		List<Integer> idList = new ArrayList<Integer>();
		for(Roster temp : roster){
			String name = temp.getJid();
			
			int index = name.indexOf("@");
			String idstr = name.substring(0, index);
			if(idstr.startsWith("1000")){
				return Integer.valueOf(idstr);	
			}
			
		}
		return 0;
	}
	
	/*
	 *  获取好友
	 * */
	@Override
	public List<Integer> getFriendList(String username) {
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

	/*
	 *  模糊查询
	 * */
	@Override
	public List<Integer> searchFriendList(String username, String searchName) {
		// TODO Auto-generated method stub
		//获得好友列表
		List<Integer> roster = getFriendList(username);
		List<Integer> idList = new ArrayList<Integer>();
		
			String regex="([\u4e00-\u9fa5]+)";
			Matcher matcher = Pattern.compile(regex).matcher(searchName);
			
			Pattern pattern = Pattern.compile("[0-9]*");
		
			boolean mobile= pattern.matcher(searchName).matches(); 
			if(mobile){
				Query query = new Query();
				Pattern pattern1 = Pattern.compile("^" + searchName + ".*$", Pattern.CASE_INSENSITIVE);
				query =query.addCriteria(Criteria.where("mobilephone").regex(pattern1)).addCriteria(Criteria.where("id").in(roster));
				List<UserAccount> ulist = userAccountService.queryList(query);
				for(UserAccount account:ulist){
					idList.add(account.getId());
				}
			}
			else if(matcher.find()){
				Query query = new Query();
				Pattern pattern2 = Pattern.compile("^" + searchName + ".*$", Pattern.CASE_INSENSITIVE);
				query =query.addCriteria(Criteria.where("trueName").regex(pattern2)).addCriteria(Criteria.where("userId").in(roster));
				 List<Information> tempList = informationService.queryList(query);
				 for(Information temp2 : tempList){
					 idList.add(temp2.getUserId());
				 } 
			} else {
				Query query = new Query();
				Pattern pattern2 = Pattern.compile("^" + searchName + ".*$", Pattern.CASE_INSENSITIVE);
				query =query.addCriteria(Criteria.where("trueName").regex(pattern2)).addCriteria(Criteria.where("userId").in(roster));
				 List<Information> tempList = informationService.queryList(query);
				 for(Information temp2 : tempList){
					
						idList.add(temp2.getUserId());
				 }
		
		}
		return idList;
		
	}

	/*
	 *  查询某两个人是否是好友
	 * */
	@Override
	public boolean makeFriend(String person1, String person2) {
		// TODO Auto-generated method stub
		List<Roster> roster = rosterDao.getRoster(person1);
		
		for(Roster temp : roster){
			String name = temp.getJid();
			int index = name.indexOf("@");
			String idstr = name.substring(0, index);
			if(idstr.equals(person2)){
				return true;
			}
			
		}
		return false;
	}

	/*
	 *  查询所有病人列表
	 * */
	@Override
	public List<Integer> searchPatient(String searchName) {
		// TODO Auto-generated method stub
		List<Integer> idList = new ArrayList<Integer>();
		
		String regex="([\u4e00-\u9fa5]+)";
		Matcher matcher = Pattern.compile(regex).matcher(searchName);
		
		Pattern pattern = Pattern.compile("[0-9]*");
	
		boolean mobile= pattern.matcher(searchName).matches(); 
		if(mobile){
			Query query = new Query();
			Pattern pattern1 = Pattern.compile("^" + searchName + ".*$", Pattern.CASE_INSENSITIVE);
			query =query.addCriteria(Criteria.where("mobilephone").regex(pattern1)).addCriteria(Criteria.where("catagory").is("patient"));
			List<UserAccount> ulist = userAccountService.queryList(query);
			for(UserAccount account:ulist){
				idList.add(account.getId());
			}
		}
		else if(matcher.find()){
			Query query = new Query();
			Pattern pattern2 = Pattern.compile("^" + searchName + ".*$", Pattern.CASE_INSENSITIVE);
			query =query.addCriteria(Criteria.where("trueName").regex(pattern2));
			 List<Information> tempList = informationService.queryList(query);
			 for(Information temp2 : tempList){
				 int userId = temp2.getUserId();
				 Query query2 = Query.query(Criteria.where("userId").is(userId).andOperator(Criteria.where("catagory").is("patient")));
				 UserAccount userAccount = userAccountService.queryOne(query2);
				 if(userAccount !=null){
					 idList.add(temp2.getUserId());
					 }
				 }
		} else {
			Query query = new Query();
			Pattern pattern2 = Pattern.compile("^" + searchName + ".*$", Pattern.CASE_INSENSITIVE);
			query =query.addCriteria(Criteria.where("trueName").regex(pattern2));
			 List<Information> tempList = informationService.queryList(query);
			 for(Information temp2 : tempList){

				 int userId = temp2.getUserId();
				 Query query2 = Query.query(Criteria.where("userId").is(userId).andOperator(Criteria.where("catagory").is("patient")));
				 UserAccount userAccount = userAccountService.queryOne(query2);
				 if(userAccount !=null){
					 idList.add(temp2.getUserId());
					 }
				 
			 }
	}
			return idList;
	}
	

}
