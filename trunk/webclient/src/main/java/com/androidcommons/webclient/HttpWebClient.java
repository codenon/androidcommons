/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.webclient;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author Denis Migol
 * 
 */
public class HttpWebClient extends WebClientBase {

	protected final HttpClient httpClient;

	/**
	 * 
	 * @param endPoint
	 */
	public HttpWebClient(final String endPoint) {
		this(endPoint, new DefaultHttpClient());
	}

	/**
	 * 
	 * @param endPoint
	 * @param httpClient
	 */
	public HttpWebClient(final String endPoint, final HttpClient httpClient) {
		super(endPoint);
		this.httpClient = httpClient;
	}

	@Override
	public InputStream getInputStream(final String uri) throws IOException {
		return httpClient.execute(new HttpGet(uri)).getEntity().getContent();
	}

}
