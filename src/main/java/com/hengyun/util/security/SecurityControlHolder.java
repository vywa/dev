package com.hengyun.util.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.hengyun.util.annotation.SecurityControl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月21日 下午2:40:04
* 权限持有类
*/
public class SecurityControlHolder {



	private static final ThreadLocal<Set<String>> roles = new ThreadLocal<Set<String>>();
	private static final ThreadLocal<Set<String>> perms = new ThreadLocal<Set<String>>();
	
	//对于角色初始化
	public static void init(String p1,String p2){
		
	}
	
	public static void set(Set<String> rs,Set<String> ps){
		roles.set(rs);
		perms.set(ps);
	}
	
	public static Set<String> getRoles(){
		return roles.get();
	}
	
	public static Set<String> getPerms(){
		return roles.get();
	}
	
	public static void clear(){
		roles.set(null);
		perms.set(null);
	}
	

	public static void checkPermission(SecurityControl sc){
		if(checkRoles(sc)||checkPerms(sc)){
			return;
		}
		throw new SecurityControlException("访问操作拒绝");
	}
	
	private static boolean checkRoles(SecurityControl sc){
		if(sc == null){
			return true;
		}
		String[] roles = sc.role();
		if(roles == null || roles.length==0){
			return true;
		}
		List<String> list = new ArrayList<String>();
		for(String role:roles){
			if(role!=null && role.trim().length()>0){
				list.add(role.trim());
			}
		}
		if(list.isEmpty()){
			return true;
		}

		Set<String> rs = getRoles();
		if(sc.roleOr()){
			for(String role:roles){
				//检查是否是响应的角色
				if(rs.contains(role)){
					return true;
				}
			}
		}else  {
			for(String role:roles){
				if(!rs.contains(role)){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	
	private static boolean checkPerms(SecurityControl sc){
		if(sc == null){
			return true;
		}
		String[] perms = sc.perm();
		if(perms == null || perms.length==0){
			return true;
		}
		List<String> list = new ArrayList<String>();
		for(String perm:perms){
			if(perm!=null || perm.trim().length()>0){
				list.add(perm.trim());
			}
		}
		if(list.isEmpty()){
			return true;
		}
		
		Set<String> ps = getPerms();
		if(sc.permOr()){
			for(String perm:perms){
				if(ps.contains(perm)){
					return true;
				}
			}
		}else {
			for(String perm :perms){
				if(!ps.contains(perm)){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
}
