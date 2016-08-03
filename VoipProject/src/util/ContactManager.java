package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactManager {
	private String token;
	public ContactManager(String token) {
		this.token = token;
	}
	public void addContact (List<Contact> contacts) throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token;
		JSONArray contactList = new JSONArray();
		for(Contact one:contacts){
			contactList.put(one.prepareAdd());
		}
		JSONObject reqMap = new JSONObject();
		reqMap.put("accList", contactList);
		JsonEntity entity = new JsonEntity(reqMap);
		Remote.post(url, entity);

	}
	public List<Contact> getAllContact() throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token;
		
		JSONObject jsonList = Remote.get(url);
		System.out.println(jsonList);
		JSONArray accJSON = jsonList.getJSONArray("contactList");
		List<Contact> conList = new ArrayList<Contact>();
		for(int i = 0;i<accJSON.length();i++){
			conList.add(new Contact(accJSON.getJSONObject(i)));
		}
		return conList;

	}
	/*public void updateContactOrder(List<Contact> modifiedOrder) throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token+"/order";
		JSONArray orderUuidList = new JSONArray();
		for(Contact one: modifiedOrder){
			orderUuidList.put(one.getUuid());
		}
		HashMap<String,Object> reqMap = new HashMap<String,Object>(2);
		reqMap.put("userUuidList",orderUuidList);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);

	}*/
	public void updateContactOrder(List<String> modifiedUuid) throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token+"/order";
		HashMap<String,Object> reqMap = new HashMap<String,Object>(1);
		reqMap.put("userUuidList",modifiedUuid);
		JsonEntity entity = new JsonEntity(new JSONObject(reqMap));
		Remote.put(url, entity);

	}
	public void updateContact(Contact modified) throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token+"/"+modified.getUuid();
		JSONObject one = modified.prepareModify();
		JSONObject req = new JSONObject();
		req.put("webContact", one);
		JsonEntity entity = new JsonEntity(req);
		Remote.put(url, entity);

	}
	public void delContact(String uuid) throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token+"/"+uuid;
		
		Remote.delete(url);

	}
	
	
	public void addDefaultContact (List<Contact> contacts) throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token+"/default";
		JSONArray contactList = new JSONArray();
		for(Contact one:contacts){
			contactList.put(one.prepareAdd());
		}
		JSONObject reqMap = new JSONObject();
		reqMap.put("accList", contactList);
		JsonEntity entity = new JsonEntity(reqMap);
		Remote.post(url, entity);

	}
	
	public List<Contact> getAllDefalutContact() throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token+"/default";
		JSONObject jsonList = Remote.get(url);
		System.out.println(jsonList);
		JSONArray accJSON = jsonList.getJSONArray("defaultContactList");
		List<Contact> conList = new ArrayList<Contact>();
		for(int i = 0;i<accJSON.length();i++){
			conList.add(new Contact(accJSON.getJSONObject(i)));
		}
		return conList;

	}
	
	public void updateDefalutContact(Contact modified) throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token+"/default";
		JSONObject one = modified.prepareModify();
		JSONObject req = new JSONObject();
		req.put("webContact", one);
		JsonEntity entity = new JsonEntity(req);
		Remote.put(url, entity);

	}
	public void delDefalutContact(String uuid) throws JSONException, KitsException, IOException{
		String url = "/Contact/"+this.token+"/default/"+uuid;		
		Remote.delete(url);

	}
}
