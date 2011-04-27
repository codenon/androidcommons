/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.webclient.json.rpc.v20;

import java.io.IOException;

import org.apache.http.HttpException;
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
	 * @param endPoint
	 */
	public JSONRPC20HttpWebClient(final String endPoint) {
		super(endPoint);
	}

	protected JSONObject call(final String path, final String method, final JSONObject params) throws IOException,
			HttpException, JSONException, JSONRPCException {
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
				throw new JSONRPCException(error.getInt("code") + error.getString("message"));
			}
		}
		return jsResponse;
	}

}
