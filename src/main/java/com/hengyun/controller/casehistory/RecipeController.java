package com.hengyun.controller.casehistory;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.controller.BaseController;
import com.hengyun.domain.casehistory.Recipe;
import com.hengyun.domain.casehistory.response.RecipeResponse;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.casehistory.RecipeService;
import com.hengyun.util.json.JSONUtil;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月22日 下午5:03:28
* 处方控制器
*/
@Controller
@RequestMapping("/recipe")
public class RecipeController extends BaseController{

	@Resource
	private RecipeService recipeService;
	
	/*
	 *  添加随访情况
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addRecipe(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSONUtil.parseObject(data);
		Recipe recipe = JSONUtil.toJavaObject(jsonObject, Recipe.class);
		int userId = (int)request.getAttribute("userId");
		recipe.setDoctorId(userId);
		recipeService.addRecipe(recipe);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加处方成功");
		return JSON.toJSONString(response);
	}
	

	/*
	 *   查询随访情况
	 * */
	@RequestMapping(value="queryList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String query(HttpServletRequest request,@RequestParam(required=false) String data){
		JSONObject jsonObject =JSONUtil.parseObject(data);
		int userId = (int)request.getAttribute("userId");
		int patientId = jsonObject.getIntValue("patientId");
		List<Recipe> recipeList = recipeService.getPatientRecipe(patientId, userId);
		RecipeResponse response = new RecipeResponse();
		response.setRecipeList(recipeList);
		response.setCode("206");
		response.setMessage("查询处方成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *   查询随访情况
	 * */
	@RequestMapping(value="patient/queryList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pquery(HttpServletRequest request){
	//	JSONObject jsonObject =JSON.parseObject(data);
		int userId = (int)request.getAttribute("userId");
	//	int patientId = jsonObject.getIntValue("patientId");
		List<Recipe> recipeList = recipeService.patientSelf(userId);
		RecipeResponse response = new RecipeResponse();
		response.setRecipeList(recipeList);
		response.setCode("206");
		response.setMessage("查询处方成功");
		return JSON.toJSONString(response);
	}
	
}
