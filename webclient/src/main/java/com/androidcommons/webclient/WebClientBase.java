/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.webclient;

/**
 * @author Denis Migol
 * 
 */
public abstract class WebClientBase {
	protected final String endPoint;

	public WebClientBase(final String endPoint) {
		this.endPoint = endPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}
}
