package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Admin {
	public static List<User> getLeaderList() throws KitsException, JSONException, IOException{
		String url = "/Account/admin?serverHandshake="+Utility.SYSTEMHANDSHAKE;
		
		JSONObject response = Remote.get(url);
		JSONArray accList;
		List<User> accListRes = new ArrayList<User>();
		
		accList = response.getJSONArray("accList");
		System.out.println(accList);
		for(int i = 0; i<accList.length(); i++){
			accListRes.add(new User(accList.getJSONObject(i)));
		}

		return accListRes;
		
	}
}
