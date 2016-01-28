package com.hengyun.service.impl.shiro;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengyun.service.shiro.FilterChainDefinationService;

/*
 *  安全框架角色，资源配置服务类
 * */
public abstract class AbstractFilterChainDefinitionService implements FilterChainDefinationService{

	private final static Logger log = LoggerFactory.getLogger(AbstractFilterChainDefinitionService.class);
	private String definitions = "";
	
	@Resource 
	private ShiroFilterFactoryBean shiroFilterFactoryBean;
	
	
	@PostConstruct
	@Override
	public void initPermission() {
		// TODO Auto-generated method stub
		shiroFilterFactoryBean.setFilterChainDefinitionMap(obtainPermission());
		log.debug("initialize shiro permission success ...");
	}

	@Override
	public void updatePermission() {
		// TODO Auto-generated method stub
		synchronized(shiroFilterFactoryBean){
			AbstractShiroFilter shiroFilter = null;
			try {
				shiroFilter = (AbstractShiroFilter)shiroFilterFactoryBean.getObject();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e.getMessage());
			}
			
			//获取过滤管理器
			PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver)shiroFilter.getFilterChainResolver();
			DefaultFilterChainManager manager = (DefaultFilterChainManager)filterChainResolver.getFilterChainManager();
			
			//清空初始权限配置
			manager.getFilterChains().clear();
			shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
			
			//重新构建生成
			shiroFilterFactoryBean.setFilterChainDefinitions(definitions);
			Map<String ,String > chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
			
			for(Map.Entry<String, String> entry : chains.entrySet()){
					String url = entry.getKey();
					String chainDefinition = entry.getValue().trim().replace(" ","");
					manager.createChain(url, chainDefinition);
			}
			log.debug("update shiro permission success ...");
		}
	}

	/*
	 *   读取配置资源　
	 * */
	private Section obtainPermission(){
		Ini ini = new Ini();
		ini.load(definitions);				//加载资源文件节点串
		Section section = ini.getSection("urls");		//使用默认节点
		if(CollectionUtils.isEmpty(section)){
			section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		}
		
		Map<String,String> permissionMap = initOtherPermission();
		if(permissionMap != null && !permissionMap.isEmpty()){
			section.putAll(permissionMap);
		}
		return section;
	}
	
	public abstract Map<String,String> initOtherPermission();

	public String getDefinitions() {
		return definitions;
	}

	public void setDefinitions(String definitions) {
		this.definitions = definitions;
	}

	
}
