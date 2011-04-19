/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.webclient;

import java.net.URI;
import java.net.URL;

/**
 * @author Denis Migol
 * 
 */
public class WebClientBase implements WebClient {

	private final String endPoint;

	public WebClientBase(final String endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public String getEndPoint() {
		return endPoint;
	}

	@Override
	public String getUrl(final String path) {
		String ret = path;
		if (ret != null) {
			try {
				final URL baseUrl = new URL(endPoint);
				final URI retUrl = new URI(ret);

				String retProtocol = retUrl.getScheme();
				if (retProtocol == null || retProtocol.length() == 0) {
					retProtocol = baseUrl.getProtocol();
				}

				String retPath = retUrl.getPath();
				if (retPath == null || retPath.length() == 0) {
					retPath = baseUrl.getPath();
				}

				String retHost = retUrl.getHost();
				if (retHost == null || retHost.length() == 0) {
					retHost = baseUrl.getHost();
				}

				ret = new URL(retProtocol, retHost, retPath).toString();
			} catch (final Exception e) {
			}
		}
		return ret;
	}

}
