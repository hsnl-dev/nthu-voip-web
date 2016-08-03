package util;

import org.json.JSONException;
import org.json.JSONObject;

public class Unit {
	private String unitUuid;
	private String unitName;
	public Unit(JSONObject obj) throws JSONException{
		setUnitUuid(obj.getString("unitUuid"));
		setUnitName(obj.getString("unitName"));
	}
	public String getUnitUuid() {
		return unitUuid;
	}
	public void setUnitUuid(String unitUuid) {
		this.unitUuid = unitUuid;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
}
