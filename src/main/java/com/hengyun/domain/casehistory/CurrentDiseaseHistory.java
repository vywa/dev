package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月7日 下午4:43:34
* 病人现病史
*/
public class CurrentDiseaseHistory implements Serializable{

	/*
	 * 起病时间、缓急，可能的病因和诱因（必要时包括起病前的一些情况）
	 * 主要症状（或体征）出现的时间、部位、性质、程度及其演变过程。
	 * 伴随症状的特点及变化，对具有鉴别诊断意义的重要阳性和阴性症状（或体征）亦应加以说明
	 * 对患有与本病有关的慢性病者或旧病复发者，应着重了解其初发时的情况和重大变化以及最近复发的情况
	 * 发病以来曾在何处做何种诊疗（包括诊疗日期，检查结果，用药名称及其剂量、用法，手术方式，疗效等）
	 * 与本科疾病无关的未愈仍需诊治的其他科重要伤病，应另段叙述
	 * 发病以来的一般情况，如精神、食欲、食量、睡眠、大小便 、体力和体重的变化等。
	 * */
	
	private String details;
	private String cure;
	
	private Date date;
	
	
}
