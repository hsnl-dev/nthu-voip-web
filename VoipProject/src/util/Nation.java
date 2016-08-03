package util;

import org.json.JSONException;
import org.json.JSONObject;

public class Nation {
	private String nationalPreCode;
	private String nation;
	public Nation(JSONObject obj) throws JSONException{
		nationalPreCode = obj.getString("nationalPreCode");
		nation = obj.getString("nation");
	}
	public String getNationalPreCode() {
		return nationalPreCode;
	}
	public void setNationalPreCode(String nationalPreCode) {
		this.nationalPreCode = nationalPreCode;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
}
