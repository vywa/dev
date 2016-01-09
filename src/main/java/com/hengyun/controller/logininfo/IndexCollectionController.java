package com.hengyun.controller.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hengyun.dao.logininfo.IndexCollectiontDao;
import com.hengyun.domain.common.IndexCollection;


/*
 *  系统索引，系统管理用
 * */

@Controller
@RequestMapping("index")
public class IndexCollectionController {

	@Resource 
	private IndexCollectiontDao indexCollectionDao;
	
	@RequestMapping("/init")
	@ResponseBody
	public String init(){
		indexCollectionDao.load();
		return "init success";
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String show(){
		Query query = new Query(Criteria.where("_id").exists(true));
		List<IndexCollection> list = indexCollectionDao.queryList(query);
		return JSON.toJSONString(list);
	}
}
