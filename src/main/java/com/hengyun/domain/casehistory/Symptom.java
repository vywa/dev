package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午8:01:52
* 病人症状
*/
public class Symptom implements Serializable{

	private int caseHistoryId;										//病历号
	
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	private boolean headDam;									//头晕
	private boolean headHeart;									//头痛
	private boolean headExpand;								//头胀
	private boolean earNoise;										//耳鸣
	private boolean eyeExpand;								//眼胀痛
	private boolean memoryDecline;						//记忆力下降
	private boolean noSleep;										//失眠
	private boolean manyDream;								//多梦
	private boolean feelingWave;								//情绪波动大
	private boolean chestBreath;								//胸闷
	private boolean chestHeart;									//胸痛
	
	private boolean heartHop;									//心悸
	private boolean breathShort;								//气短
	
	private boolean tired;												//乏力
	private boolean backNeck;									//后颈部疼痛
	
	private boolean eyeFade;										//视力模糊
	private boolean pillorAche;									//后枕部有搏动感
	
	private boolean sweat;											//汗水
	private boolean frequentUrine;								//频尿
	
	private boolean harryUrine;									//尿急
	private boolean acheUrine;									//尿痛
	private boolean bloodUrine;								//血尿
	
	private boolean proteinUrine;								//蛋白尿
	private boolean smallUrine;									//少尿
	private boolean thineUrine;									//尿流变细
	
	private boolean nightUrine;									//夜尿增多
	private boolean manyDrink;								//多饮
	private boolean manyEat;										//多食
	private boolean manyUrine;								//多尿
	private boolean thin;												//消瘦
	
	private boolean bottomTired;								//下肢无力
	private boolean cycleNum;									//周期下肢无力
	
	private boolean mensesUnregular;					//月经紊乱
	private boolean cycleUpperNum;						//周期上肢麻痹
	
	private boolean manySleepDay;							//白天嗜睡
	private boolean weakNight;									//夜间憋醒
	
	private boolean coolLimb;									//肢端发冷
	private boolean intertativeLame;						//间歇性跛行
	public boolean isHeadDam() {
		return headDam;
	}
	public void setHeadDam(boolean headDam) {
		this.headDam = headDam;
	}
	public boolean isHeadHeart() {
		return headHeart;
	}
	public void setHeadHeart(boolean headHeart) {
		this.headHeart = headHeart;
	}
	public boolean isHeadExpand() {
		return headExpand;
	}
	public void setHeadExpand(boolean headExpand) {
		this.headExpand = headExpand;
	}
	public boolean isEarNoise() {
		return earNoise;
	}
	public void setEarNoise(boolean earNoise) {
		this.earNoise = earNoise;
	}
	public boolean isEyeExpand() {
		return eyeExpand;
	}
	public void setEyeExpand(boolean eyeExpand) {
		this.eyeExpand = eyeExpand;
	}
	public boolean isMemoryDecline() {
		return memoryDecline;
	}
	public void setMemoryDecline(boolean memoryDecline) {
		this.memoryDecline = memoryDecline;
	}
	public boolean isNoSleep() {
		return noSleep;
	}
	public void setNoSleep(boolean noSleep) {
		this.noSleep = noSleep;
	}
	public boolean isManyDream() {
		return manyDream;
	}
	public void setManyDream(boolean manyDream) {
		this.manyDream = manyDream;
	}
	public boolean isFeelingWave() {
		return feelingWave;
	}
	public void setFeelingWave(boolean feelingWave) {
		this.feelingWave = feelingWave;
	}
	public boolean isChestBreath() {
		return chestBreath;
	}
	public void setChestBreath(boolean chestBreath) {
		this.chestBreath = chestBreath;
	}
	public boolean isChestHeart() {
		return chestHeart;
	}
	public void setChestHeart(boolean chestHeart) {
		this.chestHeart = chestHeart;
	}
	public boolean isHeartHop() {
		return heartHop;
	}
	public void setHeartHop(boolean heartHop) {
		this.heartHop = heartHop;
	}
	public boolean isBreathShort() {
		return breathShort;
	}
	public void setBreathShort(boolean breathShort) {
		this.breathShort = breathShort;
	}
	public boolean isTired() {
		return tired;
	}
	public void setTired(boolean tired) {
		this.tired = tired;
	}
	public boolean isBackNeck() {
		return backNeck;
	}
	public void setBackNeck(boolean backNeck) {
		this.backNeck = backNeck;
	}
	public boolean isEyeFade() {
		return eyeFade;
	}
	public void setEyeFade(boolean eyeFade) {
		this.eyeFade = eyeFade;
	}
	public boolean isPillorAche() {
		return pillorAche;
	}
	public void setPillorAche(boolean pillorAche) {
		this.pillorAche = pillorAche;
	}
	public boolean isSweat() {
		return sweat;
	}
	public void setSweat(boolean sweat) {
		this.sweat = sweat;
	}
	public boolean isFrequentUrine() {
		return frequentUrine;
	}
	public void setFrequentUrine(boolean frequentUrine) {
		this.frequentUrine = frequentUrine;
	}
	public boolean isHarryUrine() {
		return harryUrine;
	}
	public void setHarryUrine(boolean harryUrine) {
		this.harryUrine = harryUrine;
	}
	public boolean isAcheUrine() {
		return acheUrine;
	}
	public void setAcheUrine(boolean acheUrine) {
		this.acheUrine = acheUrine;
	}
	public boolean isBloodUrine() {
		return bloodUrine;
	}
	public void setBloodUrine(boolean bloodUrine) {
		this.bloodUrine = bloodUrine;
	}
	public boolean isProteinUrine() {
		return proteinUrine;
	}
	public void setProteinUrine(boolean proteinUrine) {
		this.proteinUrine = proteinUrine;
	}
	public boolean isSmallUrine() {
		return smallUrine;
	}
	public void setSmallUrine(boolean smallUrine) {
		this.smallUrine = smallUrine;
	}
	public boolean isThineUrine() {
		return thineUrine;
	}
	public void setThineUrine(boolean thineUrine) {
		this.thineUrine = thineUrine;
	}
	public boolean isNightUrine() {
		return nightUrine;
	}
	public void setNightUrine(boolean nightUrine) {
		this.nightUrine = nightUrine;
	}
	public boolean isManyDrink() {
		return manyDrink;
	}
	public void setManyDrink(boolean manyDrink) {
		this.manyDrink = manyDrink;
	}
	public boolean isManyEat() {
		return manyEat;
	}
	public void setManyEat(boolean manyEat) {
		this.manyEat = manyEat;
	}
	public boolean isManyUrine() {
		return manyUrine;
	}
	public void setManyUrine(boolean manyUrine) {
		this.manyUrine = manyUrine;
	}
	public boolean isThin() {
		return thin;
	}
	public void setThin(boolean thin) {
		this.thin = thin;
	}
	public boolean isBottomTired() {
		return bottomTired;
	}
	public void setBottomTired(boolean bottomTired) {
		this.bottomTired = bottomTired;
	}
	public boolean isCycleNum() {
		return cycleNum;
	}
	public void setCycleNum(boolean cycleNum) {
		this.cycleNum = cycleNum;
	}
	public boolean isMensesUnregular() {
		return mensesUnregular;
	}
	public void setMensesUnregular(boolean mensesUnregular) {
		this.mensesUnregular = mensesUnregular;
	}
	public boolean isCycleUpperNum() {
		return cycleUpperNum;
	}
	public void setCycleUpperNum(boolean cycleUpperNum) {
		this.cycleUpperNum = cycleUpperNum;
	}
	public boolean isManySleepDay() {
		return manySleepDay;
	}
	public void setManySleepDay(boolean manySleepDay) {
		this.manySleepDay = manySleepDay;
	}
	public boolean isWeakNight() {
		return weakNight;
	}
	public void setWeakNight(boolean weakNight) {
		this.weakNight = weakNight;
	}
	public boolean isCoolLimb() {
		return coolLimb;
	}
	public void setCoolLimb(boolean coolLimb) {
		this.coolLimb = coolLimb;
	}
	public boolean isIntertativeLame() {
		return intertativeLame;
	}
	public void setIntertativeLame(boolean intertativeLame) {
		this.intertativeLame = intertativeLame;
	}
	
	
}
