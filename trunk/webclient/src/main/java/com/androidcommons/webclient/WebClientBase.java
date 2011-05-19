/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.webclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

/**
 * @author Denis Migol
 * 
 */
public abstract class WebClientBase {

	protected final String endPoint;

	/**
	 * 
	 * @param endPoint
	 */
	public WebClientBase(final String endPoint) {
		if (endPoint == null) {
			throw new NullPointerException("endPoint == null");
		}
		this.endPoint = endPoint;
	}

	/**
	 * 
	 * @return endPoint
	 */
	public String getEndPoint() {
		return endPoint;
	}

	/**
	 * 
	 * @param uri
	 * @return
	 */
	public String getFullUrl(final String uri) {
		String ret = uri;
		if (ret != null) {
			try {
				final URL baseUrl = new URL(endPoint);
				final URI retUrl = new URI(ret);

				String retProtocol = retUrl.getScheme();
				if (retProtocol == null || retProtocol.length() == 0) {
					retProtocol = baseUrl.getProtocol();
				}

				String retHost = retUrl.getHost();
				if (retHost == null || retHost.length() == 0) {
					retHost = baseUrl.getHost();
				}

				int retPort = retUrl.getPort();
				if (retPort == -1) {
					retPort = baseUrl.getPort();
				}

				String retPath = retUrl.getPath();
				if (retPath == null || retPath.length() == 0) {
					retPath = baseUrl.getPath();
				}

				ret = new URL(retProtocol, retHost, retPort, retPath).toString();
			} catch (final Exception e) {
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public String getFullPathUrl(final String path) {
		String ret = endPoint;
		if ((path != null && path.trim().length() > 0)) {
			final String correctPath = (path.charAt(0) == '/') ? path.substring(1) : path;
			ret = (ret.charAt(ret.length() - 1) == '/') ? ret + correctPath : ret + '/' + correctPath;
		}
		return ret;
	}

	/**
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public abstract InputStream getInputStream(String uri) throws IOException;
}
