package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserManger {

	public UserManger() {
		// TODO Auto-generated constructor stub
	}
	/***
	 * register personal user 
	 * @param mail E-mail of user
	 * @param number phone number of user
	 * @param unitName department name of user
	 * @param userName name of user
	 * @throws KitsException Check Duplicated
	 * @throws IOException network failed
	 */
	public static void regPersonUser(String mail,String number,String unitName,String userName) throws KitsException, IOException{
		String url = "/Account";
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("mail", mail);
		reqMap.put("number", number);
		reqMap.put("unitUuid", unitName);
		reqMap.put("name", userName);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.post(url, entity);
	}
	
	public static void regLeaderUser(String mail,String number,String userName,String unitName) throws KitsException, IOException{
		String url = "/Account/admin";
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("mail", mail);
		reqMap.put("number", number);
		reqMap.put("serverHandshake", Utility.SYSTEMHANDSHAKE);
		reqMap.put("unitName", unitName);
		reqMap.put("name", userName);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.post(url, entity);
	}
	public static void verifyUser(String userName,String authCode) throws KitsException, IOException{
		String url = "/Account/verification";
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("userName", userName);
		reqMap.put("authCode", authCode);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);
	}
	/***
	 * 
	 * @param name phone number
	 * @throws KitsException
	 * @throws IOException
	 */
	public static void sendVerificaion(String name) throws KitsException, IOException{
		String url = "/Account/verification";
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("userName", name);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.post(url, entity);
	}
	public static void approveUser(String name) throws KitsException, IOException{
		String url = "/Account/approval";
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("userName", name);
		reqMap.put("approval", "accept");
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);
	}
	/***
	 * deny unit leader 
	 * @param name phone number
	 * @throws KitsException
	 * @throws IOException
	 */
	public static void denyUser(String name) throws KitsException, IOException{
		String url = "/Account/approval";
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("userName", name);
		reqMap.put("approval", "deny");
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);
	}
	public static void delUser(String name) throws KitsException, IOException{
		String url = "/Account/admin/"+name+"?serverHandshake=superuserfor6talkWeb2013";
		Remote.delete(url);
	}
	public static void resetPassword(String name) throws KitsException, IOException{
		String url = "/Account/password";
		HashMap<String,String> reqMap = new HashMap<String,String>();
		reqMap.put("username", name);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.post(url, entity);
	}
	public static List<Nation> getNation() throws KitsException, IOException, JSONException{
		String url = "/Account/nationList";
		JSONObject res= Remote.get(url);
		JSONArray nations = res.getJSONArray("nationList");
		ArrayList<Nation> nationsList = new ArrayList<Nation>();
		for(int i= 0 ;i<nations.length();i++){
			nationsList.add(new Nation(nations.getJSONObject(i)));
		}
		return nationsList;
	}
	public static List<Unit> getUnitList() throws KitsException, IOException, JSONException{
		String url = "/Account/unitList?serverHandshake=superuserfor6talkWeb2013";
		JSONObject res= Remote.get(url);
		System.out.println(res);
		JSONArray units = res.getJSONArray("unitList");
		ArrayList<Unit> nationsList = new ArrayList<Unit>();
		for(int i= 0 ;i<units.length();i++){
			nationsList.add(new Unit(units.getJSONObject(i)));
		}
		return nationsList;
	}
}
