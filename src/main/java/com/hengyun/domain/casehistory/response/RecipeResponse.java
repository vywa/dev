package com.hengyun.domain.casehistory.response;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.casehistory.Recipe;
import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月22日 下午5:09:00
* 处方返回类
*/
public class RecipeResponse extends ResponseCode implements Serializable{

	private List<Recipe> recipeList;

	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	
	
}
