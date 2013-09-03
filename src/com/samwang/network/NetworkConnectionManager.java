package com.samwang.network;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

public class NetworkConnectionManager {

	private static final String TAG = "NetworkConnectionManager";

	private static HttpClient getHttpClient(boolean usingSSL) {
		HttpClient httpclient = null;
		if (usingSSL) {
			Log.d(TAG, "getHttpClient:: SSLHttpClient");
			httpclient = CustomSSLSocketFactory.createSSLHttpClient();
		} else {
			Log.d(TAG, "getHttpClient:: DefaultHttpClient");
			httpclient = new DefaultHttpClient();
		}
		return httpclient;
	}

	public static CustomHttpResponse postJsonData(String uri, HashMap<String, String> headers, JSONObject obj) throws Exception {
		Object jResult = null;
		CustomHttpResponse gResponse = null;
		if (uri != null && obj != null) {
			HttpClient httpclient = getHttpClient((uri.indexOf("https://") == 0) ? true : false);
			Log.d(TAG, "postJsonData:: uri=" + uri + ", jsonObj=" + obj.toString());
			HttpParams myParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(myParams, 10000);
			HttpConnectionParams.setSoTimeout(myParams, 10000);

			String json = obj.toString();
			HttpPost httppost = new HttpPost(uri.toString());
			httppost.setHeader(HTTP.CONTENT_TYPE, "application/json");
			
			Iterator<String> it = headers.keySet().iterator();
			while(it.hasNext()){
			    String key = it.next();
			    String value = headers.get(key);
			    httppost.setHeader(key, value);
			}
			
			StringEntity se = new StringEntity(json);
			se.setContentType("application/json");
			httppost.setEntity(se);

			HttpResponse response = httpclient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();
			String result = EntityUtils.toString(response.getEntity());
			
			Log.d(TAG, "statusCode=" + statusCode + ", result=" + result);
			
			if (null != result && result.length() > 0) {
				Object jsonObj = new JSONTokener(result).nextValue();
				if (jsonObj instanceof JSONObject) {
					// you have an object
					jResult = (JSONObject)jsonObj;
				} else if (jsonObj instanceof JSONArray) {
					// you have an array
					jResult = (JSONArray)jsonObj;
				}
			}
			gResponse = new CustomHttpResponse();
			gResponse.setStatusCode(statusCode);
			gResponse.setJsonObj(jResult);
		}
		return gResponse;
	}

	public static CustomHttpResponse delJsonData(String uri, HashMap<String, String> headers, JSONObject obj) throws Exception {
		Object jResult = null;
		CustomHttpResponse gResponse = null;
		if (uri != null && obj != null) {
			HttpClient httpclient = getHttpClient((uri.indexOf("https://") == 0) ? true : false);
			Log.d(TAG, "delJsonData:: uri=" + uri + ", jsonObj=" + obj.toString());
			HttpParams myParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(myParams, 10000);
			HttpConnectionParams.setSoTimeout(myParams, 10000);

			String json = obj.toString();
			HttpDeleteWithBody delete = new HttpDeleteWithBody(uri.toString());
			delete.setHeader(HTTP.CONTENT_TYPE, "application/json");
			
			Iterator<String> it = headers.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                String value = headers.get(key);
                delete.setHeader(key, value);
            }
			
			StringEntity se = new StringEntity(json, HTTP.UTF_8);
			se.setContentType("application/json");
			delete.setEntity(se);

			HttpResponse response = httpclient.execute(delete);
			int statusCode = response.getStatusLine().getStatusCode();
			String result = EntityUtils.toString(response.getEntity());
			Log.d(TAG, "statusCode=" + statusCode + ", result=" + result);
			
			if (null != result && result.length() > 0) {
				Object jsonObj = new JSONTokener(result).nextValue();
				if (jsonObj instanceof JSONObject) {
					// you have an object
					jResult = (JSONObject)jsonObj;
				} else if (jsonObj instanceof JSONArray) {
					// you have an array
					jResult = (JSONArray)jsonObj;
				}
			}
			gResponse = new CustomHttpResponse();
			gResponse.setStatusCode(statusCode);
			gResponse.setJsonObj(jResult);
		}
		return gResponse;
	}
	
	public static CustomHttpResponse putJsonData(String uri, HashMap<String, String> headers, JSONObject obj) throws Exception {
		Object jResult = null;
		CustomHttpResponse gResponse = null;
		if (uri != null && obj != null) {
			HttpClient httpclient = getHttpClient((uri.indexOf("https://") == 0) ? true : false);
			Log.d(TAG, "putJsonData:: uri=" + uri + ", jsonObj=" + obj.toString());
			HttpParams myParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(myParams, 10000);
			HttpConnectionParams.setSoTimeout(myParams, 10000);

			String json = obj.toString();
			HttpPutWithBody put = new HttpPutWithBody(uri.toString());
			put.setHeader(HTTP.CONTENT_TYPE, "application/json");
			
			Iterator<String> it = headers.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                String value = headers.get(key);
                put.setHeader(key, value);
            }
			
			StringEntity se = new StringEntity(json, HTTP.UTF_8);
			se.setContentType("application/json");
			put.setEntity(se);

			HttpResponse response = httpclient.execute(put);
			int statusCode = response.getStatusLine().getStatusCode();
			String result = EntityUtils.toString(response.getEntity());
			Log.d(TAG, "statusCode=" + statusCode + ", result=" + result);
			
			if (null != result && result.length() > 0) {
				Object jsonObj = new JSONTokener(result).nextValue();
				if (jsonObj instanceof JSONObject) {
					// you have an object
					jResult = (JSONObject)jsonObj;
				} else if (jsonObj instanceof JSONArray) {
					// you have an array
					jResult = (JSONArray)jsonObj;
				}
			}
			gResponse = new CustomHttpResponse();
			gResponse.setStatusCode(statusCode);
			gResponse.setJsonObj(jResult);
		}
		return gResponse;
	}

	public static CustomHttpResponse getJsonData(String uri, HashMap<String, String> headers, JSONObject obj) throws Exception {
		Object jResult = null;
		CustomHttpResponse gResponse = null;
		if (uri != null && obj != null) {
			HttpClient httpclient = getHttpClient((uri.indexOf("https://") == 0) ? true : false);
			Log.d(TAG, "getJsonData:: uri=" + uri + ", jsonObj=" + obj.toString());
			HttpParams myParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(myParams, 10000);
			HttpConnectionParams.setSoTimeout(myParams, 10000);

			String json = obj.toString();
			HttpGetWithBody get = new HttpGetWithBody(uri.toString());
			get.setHeader(HTTP.CONTENT_TYPE, "application/json");
			
			Iterator<String> it = headers.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                String value = headers.get(key);
                get.setHeader(key, value);
            }
			
			StringEntity se = new StringEntity(json, HTTP.UTF_8);
			se.setContentType("application/json");
			get.setEntity(se);

			HttpResponse response = httpclient.execute(get);
			int statusCode = response.getStatusLine().getStatusCode();
			String result = EntityUtils.toString(response.getEntity());
			Log.d(TAG, "statusCode=" + statusCode + ", result=" + result);
			if (null != result && result.length() > 0) {
				Object jsonObj = new JSONTokener(result).nextValue();
				if (jsonObj instanceof JSONObject) {
					// you have an object
					jResult = (JSONObject)jsonObj;
				} else if (jsonObj instanceof JSONArray) {
					// you have an array
					jResult = (JSONArray)jsonObj;
				}
			}
			gResponse = new CustomHttpResponse();
			gResponse.setStatusCode(statusCode);
			gResponse.setJsonObj(jResult);
		}
		return gResponse;
	}

	public static CustomHttpResponse getJsonData(String uri, HashMap<String, String> headers) throws Exception {
		Object jResult = null;
		CustomHttpResponse gResponse = null;
		if (uri != null) {
			HttpClient httpclient = getHttpClient((uri.indexOf("https://") == 0) ? true : false);
			Log.d(TAG, "getJsonData:: uri=" + uri);
			HttpParams myParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(myParams, 10000);
			HttpConnectionParams.setSoTimeout(myParams, 10000);

			HttpGet httpget = new HttpGet(uri.toString());
			httpget.setHeader(HTTP.CONTENT_TYPE, "application/json");
            
            Iterator<String> it = headers.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                String value = headers.get(key);
                httpget.setHeader(key, value);
            }

			HttpResponse response = httpclient.execute(httpget);
			int statusCode = response.getStatusLine().getStatusCode();
			String result = EntityUtils.toString(response.getEntity());
			Log.d(TAG, "statusCode=" + statusCode + ", result=" + result);
			
			if (null != result && result.length() > 0) {
				Object jsonObj = new JSONTokener(result).nextValue();
				if (jsonObj instanceof JSONObject) {
					// you have an object
					jResult = (JSONObject)jsonObj;
				} else if (jsonObj instanceof JSONArray) {
					// you have an array
					jResult = (JSONArray)jsonObj;
				}
			}
			gResponse = new CustomHttpResponse();
			gResponse.setStatusCode(statusCode);
			gResponse.setJsonObj(jResult);
		}
		return gResponse;
	}
}
