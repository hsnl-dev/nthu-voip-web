package util;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {
	private String token;
	private String date;
	private String authCode;
	private String regMail;
	private String unitName;
	private String level;
	private boolean approval;
	private JSONArray phoneList;
	private String usename;
	private String picPath;
	private String cardId;
	private String name;// name of unit;
	private String password;
	private String unitUUID;
	private String accountUuid;
	private double costPoint;
	private double initPoint;
	private double currentPoint;
	private double limitPoint;
	private boolean validation;
	public User(String token)  {	
		this.token = token;
	}
	public User(JSONObject resObj)  {
		genUser(resObj);
	}
	
	private void genUser(JSONObject resObj){
		this.setDate(resObj.optString("date",""));
		this.setAuthCode(resObj.optString("authCode",""));
		this.setRegMail(resObj.optString("regMail",""));
		this.setUnitName(resObj.optString("unitName",""));
		this.setLevel(resObj.optString("level",""));
		this.setApproval(resObj.optBoolean("approval",false));
		this.setPhoneList(resObj.optJSONArray("phoneList"));
		this.setUsename(resObj.optString("usename",""));
		this.setPicPath(resObj.optString("picPath",""));
		this.setCardId(resObj.optString("cardId",""));
		this.name = resObj.optString("name","");
		this.setValidation(resObj.optBoolean("validation",false));
		this.setPassword(resObj.optString("password",""));
		this.setUnitUUID(resObj.optString("unitUUID",""));
		this.setAccountUuid(resObj.optString("accountUuid",""));
		this.setInitPoint(resObj.optDouble("initPoint",0.0d));
		this.setCurrentPoint(resObj.optDouble("currentPoint",0.0d));
		this.setLimitPoint(resObj.optDouble("limitPoint",0.0d));
		this.setCostPoint(resObj.optDouble("costPoint",0.0d));
	}

	public void updateInfo() throws KitsException, IOException{
		String url = "/Account/"+this.token;
		JSONObject resObj = Remote.get(url);
		genUser(resObj);
		System.out.println(resObj);
	}
	/***
	 * Change phone of user
	 * @param username phone number
	 * @throws KitsException duplication or 500
	 * @throws IOException 
	 */
	public void chgUserName(String username) throws KitsException, IOException{
		String url = "/Account/"+this.token;
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("userName", username);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);
	}
	public void chgUnitName(String unitName) throws KitsException, IOException{
		String url = "/Account/"+this.token;
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("unitName", unitName);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);
	}
	/**
	 * change the user password
	 * @param oldPassword old password hash 
	 * @param newPassword new password raw
	 * @throws KitsException not 200OK
	 * @throws IOException network problem
	 */
	public void chgWebUserPassword(String oldPassword,String newPassword) throws KitsException, IOException{
		String url = "/Account/"+this.token;
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("oldPassword", oldPassword);
		reqMap.put("newPassword", newPassword);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);
	}
	
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getRegMail() {
		return regMail;
	}
	public void setRegMail(String regMail) {
		this.regMail = regMail;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public boolean isApproval() {
		return approval;
	}
	public void setApproval(boolean approval) {
		this.approval = approval;
	}
	public JSONArray getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(JSONArray phoneList) {
		this.phoneList = phoneList;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public boolean isValidation() {
		return validation;
	}
	public void setValidation(boolean validation) {
		this.validation = validation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getUnitUUID() {
		return unitUUID;
	}


	public void setUnitUUID(String unitUUID) {
		this.unitUUID = unitUUID;
	}


	public String getAccountUuid() {
		return accountUuid;
	}


	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}


	public double getInitPoint() {
		return initPoint;
	}


	public void setInitPoint(double initPoint) {
		this.initPoint = initPoint;
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
