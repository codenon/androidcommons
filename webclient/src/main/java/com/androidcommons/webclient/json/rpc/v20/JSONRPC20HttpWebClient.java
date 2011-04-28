/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.webclient.json.rpc.v20;

import java.io.IOException;

import org.apache.http.HttpException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.androidcommons.webclient.json.JSONHttpWebClient;
import com.androidcommons.webclient.json.rpc.JSONRPCException;

/**
 * @author Denis Migol
 * 
 */
public class JSONRPC20HttpWebClient extends JSONHttpWebClient {

	/**
	 * 
	 */
	private static final String RESULT = "result";

	/**
	 * @param endPoint
	 */
	public JSONRPC20HttpWebClient(final String endPoint) {
		super(endPoint);
	}

	/**
	 * 
	 * @param path
	 * @param method
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 * @throws JSONException
	 * @throws JSONRPCException
	 */
	protected JSONObject executeJSONRPC(final String path, final String method, final JSONObject params)
			throws IOException, HttpException, JSONException, JSONRPCException {
		final JSONObject jsRequest = new JSONObject();
		jsRequest.put("jsonrpc", "2.0");
		jsRequest.put("method", method);
		if (params != null) { // This member MAY be omitted
			jsRequest.put("params", params);
		}
		jsRequest.put("id", 1);
		final JSONObject jsResponse = executeJSON(path, jsRequest);
		if (jsResponse.has("error")) {
			final JSONObject error = jsResponse.getJSONObject("error");
			if (null != error) {
				throw new JSONRPCException(error.getInt("code") + " " + error.getString("message"));
			}
		}
		return jsResponse;
	}

	protected JSONObject executeJSONRPC(final String path, final String method) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(path, method, null);
	}

	protected JSONObject executeJSONRPC(final String method, final JSONObject params) throws IOException,
			HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(null, method, params);
	}

	protected JSONObject executeJSONRPC(final String method) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(null, method, null);
	}

	//
	// Methods that return java.lang.Object
	//

	public Object call(final String path, final String method, final JSONObject params) throws IOException,
			HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(path, method, params).get(RESULT);
	}

	public Object call(final String path, final String method) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(path, method, null).get(RESULT);
	}

	public Object call(final String method, final JSONObject params) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(null, method, params).get(RESULT);
	}

	public Object call(final String method) throws IOException, HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(null, method, null).get(RESULT);
	}

	//
	// Methods that return JSONObject
	//

	public JSONObject callJSONObject(final String path, final String method, final JSONObject params)
			throws IOException, HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(path, method, params).getJSONObject(RESULT);
	}

	public JSONObject callJSONObject(final String path, final String method) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(path, method, null).getJSONObject(RESULT);
	}

	public JSONObject callJSONObject(final String method, final JSONObject params) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(null, method, params).getJSONObject(RESULT);
	}

	public JSONObject callJSONObject(final String method) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(null, method, null).getJSONObject(RESULT);
	}

	//
	// Methods that return JSONArray
	//

	public JSONArray callJSONArray(final String path, final String method, final JSONObject params) throws IOException,
			HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(path, method, params).getJSONArray(RESULT);
	}

	public JSONArray callJSONArray(final String path, final String method) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(path, method, null).getJSONArray(RESULT);
	}

	public JSONArray callJSONArray(final String method, final JSONObject params) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(null, method, params).getJSONArray(RESULT);
	}

	public JSONArray callJSONArray(final String method) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(null, method, null).getJSONArray(RESULT);
	}

	//
	// Methods that return String
	//

	public String callString(final String path, final String method, final JSONObject params) throws IOException,
			HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(path, method, params).getString(RESULT);
	}

	public String callString(final String path, final String method) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(path, method, null).getString(RESULT);
	}

	public String callString(final String method, final JSONObject params) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(null, method, params).getString(RESULT);
	}

	public String callString(final String method) throws IOException, HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(null, method, null).getString(RESULT);
	}

	//
	// Methods that return double
	//

	public double callDouble(final String path, final String method, final JSONObject params) throws IOException,
			HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(path, method, params).getDouble(RESULT);
	}

	public double callDouble(final String path, final String method) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(path, method, null).getDouble(RESULT);
	}

	public double callDouble(final String method, final JSONObject params) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(null, method, params).getDouble(RESULT);
	}

	public double callDouble(final String method) throws IOException, HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(null, method, null).getDouble(RESULT);
	}

	//
	// Methods that return long
	//

	public long callLong(final String path, final String method, final JSONObject params) throws IOException,
			HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(path, method, params).getLong(RESULT);
	}

	public long callLong(final String path, final String method) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(path, method, null).getLong(RESULT);
	}

	public long callLong(final String method, final JSONObject params) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(null, method, params).getLong(RESULT);
	}

	public long callLong(final String method) throws IOException, HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(null, method, null).getLong(RESULT);
	}

	//
	// Methods that return int
	//

	public int callInt(final String path, final String method, final JSONObject params) throws IOException,
			HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(path, method, params).getInt(RESULT);
	}

	public int callInt(final String path, final String method) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(path, method, null).getInt(RESULT);
	}

	public int callInt(final String method, final JSONObject params) throws IOException, HttpException, JSONException,
			JSONRPCException {
		return executeJSONRPC(null, method, params).getInt(RESULT);
	}

	public int callInt(final String method) throws IOException, HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(null, method, null).getInt(RESULT);
	}

	//
	// Methods that return boolean
	//

	public boolean callBoolean(final String path, final String method, final JSONObject params) throws IOException,
			HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(path, method, params).getBoolean(RESULT);
	}

	public boolean callBoolean(final String path, final String method) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(path, method, null).getBoolean(RESULT);
	}

	public boolean callBoolean(final String method, final JSONObject params) throws IOException, HttpException,
			JSONException, JSONRPCException {
		return executeJSONRPC(null, method, params).getBoolean(RESULT);
	}

	public boolean callBoolean(final String method) throws IOException, HttpException, JSONException, JSONRPCException {
		return executeJSONRPC(null, method, null).getBoolean(RESULT);
	}

}
