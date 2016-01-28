package com.hengyun.service.shiro;

import java.util.Map;

/*顶层接口,获取接口实例，update动态更新配置资源
 * 
 * 清空原有配置，更新第三方配置
 * */
public interface FilterChainDefinationService {

	public static final String PERMISSION_STRING = "perms[{0}]";		//资源结构格式
	public static final String ROLE_STRING = "role[{0}]";								//角色结构格式
	
	
	/*初始化框架权限资源配置*/
	public abstract void initPermission();					
	
	/*重新加载框架权限资源配置(强制线程同步)*/
	public abstract void updatePermission();
	
	/*初始化第三方权限资源配置*/
	public abstract Map<String,String>initOtherPermission();
	
}
