/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.logging;

import android.util.Log;

/**
 * @author Denis Migol
 * 
 */
public class SimpleLog {

	private final String tag;

	/**
	 * @param tag
	 */
	public SimpleLog(final String tag) {
		super();
		this.tag = tag;
	}

	public void info(final String message) {
		Log.println(Log.INFO, tag, message);
	}

	public void info(final String message, final Throwable tr) {
		Log.println(Log.INFO, tag, message + '\n' + Log.getStackTraceString(tr));
	}
}
