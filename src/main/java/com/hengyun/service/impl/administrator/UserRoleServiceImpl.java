package com.hengyun.service.impl.administrator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.administrator.UserRoleDao;
import com.hengyun.domain.administrator.Permission;
import com.hengyun.domain.administrator.Resources;
import com.hengyun.domain.administrator.Roles;
import com.hengyun.domain.administrator.UserRole;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.administrator.RolesService;
import com.hengyun.service.administrator.UserRoleService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.UserAccountService;
import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:22:09
* 用户角色资源业务层
*/
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole,Integer> implements UserRoleService{

	private static final Logger log = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	@Resource
	private UserRoleDao userRoleDao;
	
	@Resource
	private RolesService rolesService;
	
	@Resource
	private UserAccountService userAccountService;
	
	//获取资源默认的权限列表
	private List<Permission> getDefaultPermission(Resources resource){
		return null;
	}
	
	//获取角色默认的资源列表
	private List<Resources> getDefaultResource(Roles roles){
		return null;
	}
	
	//获取默认角色
	private List<Roles> getDefaultRoles(){
		return null;
	}
	
	//添加角色
	@Override
	public void addUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").is(userRole.getUserId()));
		
		UserAccount userAccount = userAccountService.queryOne(query);
		String catagory = userAccount.getCatagory();
	
		Query query2 = Query.query(Criteria.where("roleName").is(catagory));
		
		Roles roles = rolesService.queryOne(query2); 
		List<Roles> rolesList = new ArrayList<Roles>();
		rolesList.add(roles);
		userRole.setRoles(rolesList);
		userRoleDao.save(userRole);
		
		log.info("添加用户角色");

		
	}

	
	//查询用户角色
	@Override
	public List<UserRole> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").exists(true));
		List<UserRole> userRoleList = userRoleDao.queryList(query);
		return userRoleList;
	}
	
	
	
	//用户删除角色
	@Override
	public void deleteUserRole(Roles role ,int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		
		UserRole temp = userRoleDao.queryOne(query);
		if(temp != null){
			List<Roles> roleList = temp.getRoles();
			CopyOnWriteArrayList<Roles> list = new CopyOnWriteArrayList<Roles>(roleList);
			for(Roles rl : list){
				if(rl.getRoleName().equals(role.getRoleName())){
					list.remove(rl);
					break;
				}
			}
			roleList = list;
			Update update = Update.update("roles", roleList);
			userRoleDao.updateFirst(query, update);
		} else {
			
		}
		
	
	}

	//给用户添加角色
	@Override
	public boolean addRole(Roles role, int userId) {
		// TODO Auto-generated method stu
		Query query = Query.query(Criteria.where("userId").is(userId));
		UserRole userRole = userRoleDao.queryOne(query);
		List<Roles> roleList = userRole.getRoles();
		if(roleList == null){
			roleList = new ArrayList<Roles>();
			roleList.add(role);
		} else {
			for(Roles temp : roleList){
				if(temp.getRoleName().equals(role.getRoleName())){
					log.error("该身份已经存在，不能添加.");
					return false;
				}
			}
			roleList.add(role);
		}
		
		Update update = Update.update("roles", roleList);
		userRoleDao.updateFirst(query, update);
		
		return true;
		
	}

	@Override
	public boolean delete(Roles role, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		UserRole userRole = userRoleDao.queryOne(query);
		List<Roles> roleList = userRole.getRoles();
		CopyOnWriteArrayList<Roles> list = new CopyOnWriteArrayList<Roles>(roleList);
		boolean success = false;
		for(Roles temp : list){
			if(temp.getRoleName().equals(role.getRoleName())){
				list.remove(temp);
				success = true;
			}
		}
		return success;
	}

	@Override
	public boolean addResource(Resources resource, Roles role, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
			
		UserRole userRole = userRoleDao.queryOne(query);
		boolean roleExist = false;
		boolean resourceExsit= false;
		boolean success = false;
		
		if(userRole == null){
			log.info("该用户不存在，不能添加");
			return false;
		} else {
			List<Roles> roleList = userRole.getRoles();
			
			if(roleList == null){
				//用户角色表为空
				roleList = new ArrayList<Roles>();
				List<Resources> rl = new ArrayList<Resources>();
				rl.add(resource);
				role.setResourceList(rl);
				roleList.add(role);
			} else {
			
			for(Roles temp : roleList){
				if(temp.getRoleName().equals(role.getRoleName())){
					List<Resources> resources = temp.getResourceList();
					for(Resources rtemp : resources){
						if(rtemp.getResourceName().equals(resource.getResourceName())){
							log.info("该资源已经存在，不能添加");
							return false;
						}
					}	
					resources.add(resource);
					role.setResourceList(resources);
					roleList.add(role);
					Update update = Update.update("roles", roleList);
					userRoleDao.updateFirst(query, update);
				}
				break;
				
			}
			if(!roleExist ){
				log.info("该角色不存在,不能添加");
				return false;
			} else {
				
			}
			}
		}
		
		return true;
	}

	
	@Override
	public void deleteResource(Resources resource, Roles role, int userId) {
		// TODO Auto-generated method stub
		Query model = Query.query(Criteria.where("userId").is(userId).
				andOperator(Criteria.where("roles.roleName").is(role.getRoleName()).
						andOperator(Criteria.where("roles.resourceList.resourceName").is(resource.getResourceName()))));
		Query query = Query.query(Criteria.where("userId").is(userId));
		
		UserRole userRole = userRoleDao.queryOne(query);
		List<Roles> rlist;
		List<Resources> resourceList;
		if(userRole != null){
			 rlist = userRole.getRoles();
			 CopyOnWriteArrayList<Roles> temp = new CopyOnWriteArrayList<Roles>(rlist);
			for(Roles rtemp : temp){
				
				if(rtemp.getRoleName().equals(role.getRoleName())){
					
					resourceList = role.getResourceList();
					CopyOnWriteArrayList<Resources>  list = new CopyOnWriteArrayList<Resources>(resourceList);
					for(Resources resouceTemp : list ){
						if(resouceTemp.getResourceName().equals(resource.getResourceName())){
							
							list.remove(resouceTemp);
							break;
						}
						
						
					}
					rlist = temp;
					Update update = Update.update("roles", rlist);
					userRoleDao.updateFirst(query, update);
				}
				break;
			}
		}
		
	}

	//给资源添加权限
	@Override
	public void addPermission(Permission permission, Resources resource, Roles role, int userId) {
		// TODO Auto-generated method stub
		Query model = Query.query(Criteria.where("userId").is(userId).
				andOperator(Criteria.where("roles.roleName").is(role.getRoleName()).
						andOperator(Criteria.where("roles.resourceList.resourceName").is(resource.getResourceName()))));
		UserRole userRole = userRoleDao.queryOne(model);
		if(userRole == null){
			log.error("用户不存在该资源");
		} else {
			List<Roles> roleList = userRole.getRoles();
			for(Roles rtemp : roleList){
				if(rtemp.getRoleName().equals(role.getRoleName())){
					List<Resources> resourceList = rtemp.getResourceList();
					CopyOnWriteArrayList<Resources> cpResource = new CopyOnWriteArrayList<Resources>(resourceList);
					for(Resources rs : cpResource){
						if(rs.getResourceName().equals(resource.getResourceName())){
							List<Permission> permissionList = rs.getPermissionList();
							if(permissionList == null){
								permissionList = new ArrayList<Permission>();
								permissionList.add(permission);
							} else {
								permissionList.add(permission);
							}
							
						}
						
					}
				}
			}
		}
	}

	@Override
	public void deletePermission(Permission permission, Resources resource, Roles role, int userId) {
		// TODO Auto-generated method stub
		Query model = Query.query(Criteria.where("userId").is(userId).
				andOperator(Criteria.where("roles.roleName").is(role.getRoleName()).
						andOperator(Criteria.where("roles.resourceList.resourceName").is(resource.getResourceName()))));
		UserRole userRole = userRoleDao.queryOne(model);
		if(userRole == null){
			log.error("用户不存在该资源");
		}
	}

	//设置该权限
	@Override
	public void setPermission(Permission permission, Resources resource, Roles role, int userId, boolean available) {
		// TODO Auto-generated method stub
		Query model = Query.query(Criteria.where("userId").is(userId).
				andOperator(Criteria.where("roles.roleName").is(role.getRoleName()).
						andOperator(Criteria.where("roles.resourceList.resourceName").is(resource.getResourceName()))));
		UserRole userRole = userRoleDao.queryOne(model);
		if(userRole == null){
			
		}
	}

	@Override
	public boolean hasRole(Roles role, int userId) {
		// TODO Auto-generated method stub
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.or(new BasicDBObject("name","write"),new BasicDBObject("available","true"));

		//构造返回字段
		BasicDBObject fieldObject=new BasicDBObject();
		fieldObject.put("name", 1);
		fieldObject.put("available", 1);
		
		Query query = new BasicQuery(queryBuilder.get(),fieldObject);
		Query model = Query.query(Criteria.where("userId").is(userId).
				andOperator(Criteria.where("roles.roleName").is(role.getRoleName())));
		UserRole userRole = userRoleDao.queryOne(model);
		if(userRole == null ){
			return false;	
		} else {
			return true;
		}
	}

	
	@Override
	public boolean hasResource(Resources resource, int userId) {
		// TODO Auto-generated method stub
		Query model = Query.query(Criteria.where("userId").is(userId).
				andOperator(Criteria.where("roles.resourceList.resourceName").is(resource.getResourceName())));
		UserRole userRole = userRoleDao.queryOne(model);
		if(userRole == null){
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public boolean hasResourceForRole(Resources resource, Roles role, int userId) {
		// TODO Auto-generated method stub
		Query model = Query.query(Criteria.where("userId").is(userId).
				andOperator(Criteria.where("roles.roleName").is(role.getRoleName()).
						andOperator(Criteria.where("roles.resourceList.resourceName").is(resource.getResourceName()))));
		UserRole userRole = userRoleDao.queryOne(model);
		if(userRole == null){
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public boolean hasPermission(Permission permission, Resources resource, Roles role, int userId) {
		// TODO Auto-generated method stub
		Query model = Query.query(Criteria.where("userId").is(userId).
				andOperator(Criteria.where("roles.roleName").is(role.getRoleName()).
						andOperator(Criteria.where("roles.resourceList.resourceName").is(resource.getResourceName()).andOperator(
						Criteria.where("roles.resourceList.permissionList.name").is(permission.getName())))));
		
		UserRole userRole = userRoleDao.queryOne(model);
		if(userRole == null){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Roles> RolebyId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
