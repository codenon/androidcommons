/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.webclient;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
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

	/**
	 * 
	 * @return
	 */
	public HttpClient getHttpClient() {
		return httpClient;
	}

	@Override
	public InputStream getInputStream(final String uri) throws IOException {
		return httpClient.execute(new HttpGet(uri)).getEntity().getContent();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	protected HttpGet newGet(final String path) {
		return new HttpGet(getFullPathUrl(path));
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	protected HttpPost newPost(final String path) {
		return new HttpPost(getFullPathUrl(path));
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	protected HttpPut newPut(final String path) {
		return new HttpPut(getFullPathUrl(path));
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	protected HttpDelete newDelete(final String path) {
		return new HttpDelete(getFullPathUrl(path));
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	protected HttpHead newHead(final String path) {
		return new HttpHead(getFullPathUrl(path));
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	protected HttpOptions newOptions(final String path) {
		return new HttpOptions(getFullPathUrl(path));
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	protected HttpTrace newTrace(final String path) {
		return new HttpTrace(getFullPathUrl(path));
	}
}
