package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;




public class SubUser {

	private String date;
	private String authCode;
	private String regMail;
	private String unitName;
	private Integer level;
	private Boolean approval;
	private String accountUuid;
	private List<Object> phoneList = new ArrayList<Object>();
	private String usename;
	private Integer point;
	private String picPath;
	private String password;
	private String cardId;
	private String name;
	private Boolean validation;
	private double currentPoint;
	private double limitPoint;
	private double costPoint;
	
	
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	

    public JSONObject prepareAdd() throws JSONException{
		JSONObject obj = new JSONObject();
		obj.put("userName", this.usename);
		obj.put("name", this.name);
		obj.put("unitName", this.unitName);
		obj.put("level", 1);
		obj.put("regMail",this.regMail);
		return obj;
	}
	public SubUser(){}
	
	public SubUser(JSONObject response){
		this.date =  response.optString("authCode");
		this.authCode = response.optString("date");
		this.regMail =  response.optString("regMail");
		this.unitName = response.optString("unitName");
		this.level = response.optInt("level",-1);
		this.approval = response.optBoolean("approval",false);
		this.accountUuid = response.optString("accountUuid");
		this.usename = response.optString("usename");
		this.point = response.optInt("point");
		this.picPath = response.optString("picPath");
		this.password = response.optString("password");
		this.cardId = response.optString("cardId");
		this.name = response.optString("name");
		this.validation = response.optBoolean("validation",false);
		this.currentPoint = response.optDouble("currentPoint",0.0);
		this.limitPoint = response.optDouble("limitPoint",-100.0);
		this.costPoint = response.optDouble("costPoint",0.0);
	}
	/**
	* 
	* @return
	* The date
	*/
	public String getDate() {
	return date;
	}
	
	/**
	* 
	* @param date
	* The date
	*/
	public void setDate(String date) {
	this.date = date;
	}
	
	/**
	* 
	* @return
	* The authCode
	*/
	public String getAuthCode() {
	return authCode;
	}
	
	/**
	* 
	* @param authCode
	* The authCode
	*/
	public void setAuthCode(String authCode) {
	this.authCode = authCode;
	}
	
	/**
	* 
	* @return
	* The regMail
	*/
	public String getRegMail() {
	return regMail;
	}
	
	/**
	* 
	* @param regMail
	* The regMail
	*/
	public void setRegMail(String regMail) {
	this.regMail = regMail;
	}
	
	/**
	* 
	* @return
	* The unitName
	*/
	public String getUnitName() {
	return unitName;
	}
	
	/**
	* 
	* @param unitName
	* The unitName
	*/
	public void setUnitName(String unitName) {
	this.unitName = unitName;
	}
	
	/**
	* 
	* @return
	* The level
	*/
	public Integer getLevel() {
	return level;
	}
	
	/**
	* 
	* @param level
	* The level
	*/
	public void setLevel(Integer level) {
	this.level = level;
	}
	
	/**
	* 
	* @return
	* The approval
	*/
	public Boolean getApproval() {
	return approval;
	}
	
	/**
	* 
	* @param approval
	* The approval
	*/
	public void setApproval(Boolean approval) {
	this.approval = approval;
	}
	
	/**
	* 
	* @return
	* The accountUuid
	*/
	public String getAccountUuid() {
	return accountUuid;
	}
	
	/**
	* 
	* @param accountUuid
	* The accountUuid
	*/
	public void setAccountUuid(String accountUuid) {
	this.accountUuid = accountUuid;
	}
	
	/**
	* 
	* @return
	* The phoneList
	*/
	public List<Object> getPhoneList() {
	return phoneList;
	}
	
	/**
	* 
	* @param phoneList
	* The phoneList
	public void setPhoneList(List<Object> phoneList) {
	this.phoneList = phoneList;
	}
	
	/**
	* 
	* @return
	* The usename
	*/
	public String getUsename() {
	return usename;
	}
	
	/**
	* 
	* @param usename
	* The usename
	*/
	public void setUsename(String usename) {
	this.usename = usename;
	}
	
	/**
	* 
	* @return
	* The point
	*/
	public Integer getPoint() {
	return point;
	}
	
	/**
	* 
	* @param point
	* The point
	*/
	public void setPoint(Integer point) {
	this.point = point;
	}
	
	/**
	* 
	* @return
	* The picPath
	*/
	public String getPicPath() {
	return picPath;
	}
	
	/**
	* 
	* @param picPath
	* The picPath
	*/
	public void setPicPath(String picPath) {
	this.picPath = picPath;
	}
	
	/**
	* 
	* @return
	* The password
	*/
	public String getPassword() {
	return password;
	}
	
	/**
	* 
	* @param password
	* The password
	*/
	public void setPassword(String password) {
	this.password = password;
	}
	
	/**
	* 
	* @return
	* The cardId
	*/
	public String getCardId() {
	return cardId;
	}
	
	/**
	* 
	* @param cardId
	* The cardId
	*/
	public void setCardId(String cardId) {
	this.cardId = cardId;
	}
	
	/**
	* 
	* @return
	* The name
	*/
	public String getName() {
	return name;
	}
	
	/**
	* 
	* @param name
	* The name
	*/
	public void setName(String name) {
	this.name = name;
	}
	
	/**
	* 
	* @return
	* The validation
	*/
	public Boolean getValidation() {
	return validation;
	}
	
	/**
	* 
	* @param validation
	* The validation
	*/
	public void setValidation(Boolean validation) {
	this.validation = validation;
	}
	
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
	
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
	public double getCurrentPoint() {
		return currentPoint;
	}
	public void setCurrentPoint(double currentPoint) {
		this.currentPoint = currentPoint;
	}
	public double getLimitPoint() {
		return limitPoint;
	}
	public void setLimitPoint(double limitPoint) {
		this.limitPoint = limitPoint;
	}
	public double getCostPoint() {
		return costPoint;
	}
	public void setCostPoint(double costPoint) {
		this.costPoint = costPoint;
	}

}