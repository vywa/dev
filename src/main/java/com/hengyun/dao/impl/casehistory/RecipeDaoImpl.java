package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.RecipeDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.Recipe;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 下午2:17:59
* 处方数据访问层
*/
public class RecipeDaoImpl extends BaseMongodbDaoImpl<Recipe,Integer> implements RecipeDao{

	@Override
	protected Class<Recipe> getEntityClass() {
		// TODO Auto-generated method stub
		return Recipe.class;
	}

}
