/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.logging.demo;

import com.androidcommons.logging.SimpleLog;

/**
 * @author Denis Migol
 * 
 */
public class Log extends SimpleLog {

	private static final String TAG = "Demo";

	private static final Log INSTANCE = new Log();

	public static Log getInstance() {
		return INSTANCE;
	}

	private Log() {
		super(TAG);
	}
}
