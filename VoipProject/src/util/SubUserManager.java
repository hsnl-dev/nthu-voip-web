package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubUserManager {
	private final String token;
	public SubUserManager(String token) {
		this.token = token;
	}
	public void addSubUser(List<SubUser> user) throws JSONException, KitsException, IOException{
		String url = "/SubUser/"+this.token;
		JSONArray userList = new JSONArray();
		for(SubUser one:user){
			userList.put(one.prepareAdd());
		}
		JSONObject reqMap = new JSONObject();
		reqMap.put("accList", userList);
		JsonEntity entity = new JsonEntity(reqMap);
		Remote.post(url, entity);

	}
	public List<SubUser> getAllSubUser() throws JSONException, KitsException, IOException{
		String url = "/SubUser/"+this.token;
		
		JSONObject jsonList = Remote.get(url);
		System.out.println(jsonList);
		JSONArray accJSON = jsonList.getJSONArray("userList");
		List<SubUser> accList = new ArrayList<SubUser>();
		for(int i = 0;i<accJSON.length();i++){
			accList.add(new SubUser(accJSON.getJSONObject(i)));
		}
		return accList;

	}
	public void updateSubUser(SubUser modified) throws JSONException, KitsException, IOException{
		String url = "/SubUser/"+this.token+"/"+modified.getAccountUuid();
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("name", modified.getName());
		reqMap.put("regMail", modified.getRegMail());
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);

	}

	public void updateSubUserLimitPoint(SubUser modified,float limitedPoint) throws JSONException, KitsException, IOException{
		String url = "/SubUser/"+this.token+"/"+modified.getAccountUuid();
		HashMap<String,Object> reqMap = new HashMap<String,Object>(2);
		reqMap.put("name", modified.getName());
		reqMap.put("regMail", modified.getRegMail());
		reqMap.put("limitPoint", limitedPoint);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);
	}
	public void upgradeSubUser(String userId,String parentUuid) throws JSONException, KitsException, IOException{
		String url = "/SubUser/"+this.token+"/"+userId+"/level";
		HashMap<String,Object> reqMap = new HashMap<String,Object>(2);
		reqMap.put("level", true);
		reqMap.put("newParentUuid", parentUuid);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);
	}
	
	public void downgradeSubUser(String userId) throws JSONException, KitsException, IOException{
		String url = "/SubUser/"+this.token+"/"+userId+"/level";
		HashMap<String,Object> reqMap = new HashMap<String,Object>(2);
		reqMap.put("level", false);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);
	}
	public SubUser getSubUser(String userid) throws JSONException, KitsException, IOException{
		String url = "/SubUser/"+this.token+"/"+userid;
		return new SubUser(Remote.get(url));

	}
	public void delSubUser(String userid) throws JSONException, KitsException, IOException{
		String url = "/SubUser/"+this.token+"/"+userid;
		Remote.delete(url);

	}
}
