package com.hengyun.controller.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hengyun.controller.BaseController;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.common.IndexCollection;


/*
 *  系统索引，系统管理用
 * */

@Controller
@RequestMapping("index")
public class IndexCollectionController extends BaseController{

	@Resource 
	private IndexCollectionDao indexCollectionDao;
	
	@RequestMapping("/init")
	@ResponseBody
	public String init(){
		indexCollectionDao.load();
		return "init success";
	}
	
	/*
	 * 显示所有索引
	 * 
	 * */
	@RequestMapping("/show")
	@ResponseBody
	public String show(){
		Query query = new Query(Criteria.where("_id").exists(true));
		List<IndexCollection> list = indexCollectionDao.queryList(query);
		return JSON.toJSONString(list);
	}
}
