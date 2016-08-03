package util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Contact {
	private boolean MVPN;
	private String officePhone;
	private String mobilePhone;
	private String name;
	private String pic;
	private String uuid;
	private int order;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Contact(JSONObject resObj) {
		this.setMVPN(resObj.optBoolean("MVPN", false));
		this.setOfficePhone(resObj.optString("officePhone", ""));
		this.setMobilePhone(resObj.optString("mobilePhone", ""));
		this.setName(resObj.optString("name", ""));
		this.setPic(resObj.optString("pic", ""));
		this.setUuid(resObj.optString("uuid", ""));
		this.setOrder(resObj.optInt("order", -100));
	}

	/***
	 * 
	 */
	public Contact() {

	}

	public JSONObject prepareAdd() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("officePhone", this.officePhone);
		obj.put("mobilePhone", this.mobilePhone);
		obj.put("name", this.name);
		obj.put("pic", this.pic);
		return obj;
	}
	public JSONObject prepareModify() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("officePhone", this.officePhone);
		obj.put("mobilePhone", this.mobilePhone);
		obj.put("name", this.name);
		obj.put("pic", this.pic);
		obj.put("uuid", this.uuid);
		return obj;
	}
	/**
	 * 
	 * @return The MVPN
	 */
	public boolean isMVPN() {
		return MVPN;
	}

	/**
	 * 
	 * @param MVPN
	 *            The MVPN
	 */
	public void setMVPN(boolean MVPN) {
		this.MVPN = MVPN;
	}

	public Contact withMVPN(boolean MVPN) {
		this.MVPN = MVPN;
		return this;
	}

	/**
	 * 
	 * @return The officePhone
	 */
	public String getOfficePhone() {
		return officePhone;
	}

	/**
	 * 
	 * @param officePhone
	 *            The officePhone
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public Contact withOfficePhone(String officePhone) {
		this.officePhone = officePhone;
		return this;
	}

	/**
	 * 
	 * @return The mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * 
	 * @param mobilePhone
	 *            The mobilePhone
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Contact withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Contact withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 
	 * @return The pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * 
	 * @param pic
	 *            The pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	public Contact withPic(String pic) {
		this.pic = pic;
		return this;
	}

	/**
	 * 
	 * @return The uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * 
	 * @param uuid
	 *            The uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Contact withUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	/**
	 * 
	 * @return The order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * 
	 * @param order
	 *            The order
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	public Contact withOrder(int order) {
		this.order = order;
		return this;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Contact withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}
