package util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Remote {
	private final static String API_KEY = System.getenv("API_KEY");
	private final static String BASE_URL = System.getenv("BASE_URL");
	private final static String ROOT_BASE_URL = System.getenv("ROOT_BASE_URL");
	
	public static JSONObject post(String url, HttpEntity en,boolean rootUrl) throws KitsException,
		IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(ROOT_BASE_URL+url);
		httpPost.addHeader("apiKey", Remote.API_KEY);
		httpPost.setEntity(en);
		System.out.println(httpPost.toString());
		
		System.out.println(EntityUtils.toString(en));;
		CloseableHttpResponse httpRes = httpClient.execute(httpPost);
		return Remote.proccesResponse(httpRes);
	}
	
	public static JSONObject post(String url, HttpEntity en) throws KitsException,
			IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
	
		HttpPost httpPost = new HttpPost(Remote.BASE_URL + url);
		httpPost.addHeader("apiKey", Remote.API_KEY);
		httpPost.setEntity(en);
		System.out.println(httpPost.toString());
		
		System.out.println(EntityUtils.toString(en));;
		CloseableHttpResponse httpRes = httpClient.execute(httpPost);
		return Remote.proccesResponse(httpRes);
	}

	public static JSONObject put(String url, HttpEntity en) throws KitsException,
			IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPut httpPost = new HttpPut(Remote.BASE_URL + url);
		httpPost.addHeader("apiKey", Remote.API_KEY);
		httpPost.setEntity(en);
		System.out.println(httpPost.toString());
		System.out.println(EntityUtils.toString(en));
		CloseableHttpResponse httpRes = httpClient.execute(httpPost);
		return Remote.proccesResponse(httpRes);
	}

	public static JSONObject get(String url) throws KitsException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(Remote.BASE_URL + url);
		httpGet.addHeader("apiKey", Remote.API_KEY);
		CloseableHttpResponse httpRes = httpClient.execute(httpGet);
		System.out.println(httpGet.toString());
		
		return Remote.proccesResponse(httpRes);
	}

	public static JSONObject delete(String url) throws KitsException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete(Remote.BASE_URL + url);
		httpDelete.addHeader("apiKey", Remote.API_KEY);
		CloseableHttpResponse httpRes = httpClient.execute(httpDelete);
		System.out.println(httpDelete.toString());
		return Remote.proccesResponse(httpRes);
	}

	private static JSONObject proccesResponse(CloseableHttpResponse httpRes)
			throws KitsException, IOException {
		
		if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity1 = httpRes.getEntity();
			try {
				return new JSONObject(EntityUtils.toString(entity1,"utf8"));
			} catch (JSONException e) {
				throw new KitsException("Malformed but remote OK", 200,
						"not correct form");
			}

		} else {
			HttpEntity entity1 = httpRes.getEntity();
			JSONObject describle;
			try {
				describle = new JSONObject(EntityUtils.toString(entity1,"utf8"));
				throw new KitsException(httpRes.getStatusLine()
						.getReasonPhrase(),describle.getInt("status") ,
						describle.getString("description"));
			} catch (JSONException e) {
				/* cannot parse string */
				throw new KitsException(httpRes.getStatusLine()
						.getReasonPhrase(), httpRes.getStatusLine().getStatusCode(),
						"not JSON response");
			}
		}
	}
}
