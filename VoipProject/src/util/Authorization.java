package util;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;


public class Authorization {

	public static String getToken(String account,String password) throws KitsException, IOException{
		String url = "/Account/accessToken";
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("account", account);
		reqMap.put("password", password);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		JSONObject response = Remote.post(url, entity);
		String token;
		try {
			 token = response.getString("token");
		} catch (JSONException e) {
			throw new KitsException("Response MalFormed");
		}
		return token;
	}
	public static void delToken(String token) throws KitsException, IOException{
		String url = "/Account/accessToken/"+token;
		Remote.delete(url);
		
	}

}
