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
public interface WebClient {

	/**
	 * 
	 * @return
	 */
	public String getEndPoint();

	/**
	 * 
	 * @param path
	 * @return
	 */
	public String getUrl(String path);
}
