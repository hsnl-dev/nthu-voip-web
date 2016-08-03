package util;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

public class JsonEntity extends StringEntity {
   
	public JsonEntity(JSONObject jsonObject) throws UnsupportedEncodingException{
            super(jsonObject.toString(),"utf8");
    }

    @Override
    public Header getContentType(){
           return new BasicHeader(HTTP.CONTENT_TYPE, "application/json");
    }       
}