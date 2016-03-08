package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/*
 * 
 * 体格检查
 * 
 * */
public class PhysicalExamination implements Serializable{

	private int caseHistoryId;						//病历id

	private List<HashMap<Integer,Integer>> sitBloodPressure;				//座位血压
	private List<HashMap<Integer,Integer>> dynamic;								//动态血压
	
	
	private List<HashMap<Integer,Integer>> lowLimbBloodPressure;		//下肢血压
	private int heartBeat;							//心率
	
	private boolean heartRegular;				//心律
	private int weight;										//体重
	private int height;										//身高
	private float waistline;								//腰围
	private int weightIndex;							//体重指数
	private boolean pale;								//面色苍白
	private boolean edema;							//浮肿
	private boolean anemia;						//贫血
	private boolean hypertrophy;				//扁桃体肥大
	private boolean palate;							//软腭松弛
	
	private List<HashMap<String ,Boolean>> thyroidGland;		//甲状腺
	private List<HashMap<String ,Boolean>> kidney;		//肾脏
	private boolean lowLimbEdema;						//下肢水肿
	private boolean cushingFace;								
	private boolean hyperthyroidismExophthalmos;		//甲亢突眼症
	private boolean cerebralInfarction;									//脑梗后遗症
	private boolean brainBlood;												//脑出血后遗症
	
	private  List<HashMap<String,Boolean>> noise;				//杂音
	
	private int eyeDamage;															//眼底损害几级
	private String dynamicPulse;													//动脉搏动
	private String nerveSystem;													//神经系统
	
	private String other;																	//其他
	
	
}
