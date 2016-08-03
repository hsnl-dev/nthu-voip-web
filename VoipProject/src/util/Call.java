package util;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

public class Call {
	private String token;
	public Call(String token)  {	
		this.token = token;
	}
	public  void initCall (String callee,String cardId) throws KitsException, IOException{
		String url = "/v0/Call/"+this.token+"/callRequest";
		
		
		HashMap<String,String> reqMap = new HashMap<String,String>(2);
		reqMap.put("callee", callee);
		reqMap.put("cardID", cardId);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.post(url, entity,true);
		
	}
}
