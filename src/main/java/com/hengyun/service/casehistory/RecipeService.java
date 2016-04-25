package com.hengyun.service.casehistory;

import java.util.Date;
import java.util.List;

import com.hengyun.domain.casehistory.DoctorAdvice;
import com.hengyun.domain.casehistory.Recipe;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 下午2:19:48
* 类说明
*/
public interface RecipeService extends BaseService<Recipe,Integer>{

	//添加处方
	public  boolean addRecipe(Recipe recipe);
	
	//通过处方id获取处方
	public Recipe queryRecipe(int recipeId);
	
	//获取某个医嘱的所有处方
	public List<Recipe> getPatientRecipe(int patientId,int doctorId);
	
	public List<Recipe> patientSelf(int patientId);
	
	//删除某条处方
	public boolean deleteRecipe(int recipeId);
	
	//更改某条处方
	public boolean updateRecipe(Recipe recipe);
	
	//处方是否到期
	public boolean deadline(Recipe recipe,int day);
	
	//医嘱是否到期
	public boolean adviceDeadline(DoctorAdvice advice,Date date);
}
