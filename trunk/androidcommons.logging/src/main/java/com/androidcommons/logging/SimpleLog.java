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

	public void verbose(final String message) {
		Log.println(Log.VERBOSE, tag, message);
	}

	public void verbose(final String message, final Throwable tr) {
		Log.println(Log.VERBOSE, tag, message + '\n' + Log.getStackTraceString(tr));
	}

	public void debug(final String message) {
		Log.println(Log.DEBUG, tag, message);
	}

	public void debug(final String message, final Throwable tr) {
		Log.println(Log.DEBUG, tag, message + '\n' + Log.getStackTraceString(tr));
	}

	public void info(final String message) {
		Log.println(Log.INFO, tag, message);
	}

	public void info(final String message, final Throwable tr) {
		Log.println(Log.INFO, tag, message + '\n' + Log.getStackTraceString(tr));
	}

	public void warn(final String message) {
		Log.println(Log.WARN, tag, message);
	}

	public void warn(final String message, final Throwable tr) {
		Log.println(Log.WARN, tag, message + '\n' + Log.getStackTraceString(tr));
	}

	public void error(final String message) {
		Log.println(Log.ERROR, tag, message);
	}

	public void error(final String message, final Throwable tr) {
		Log.println(Log.ERROR, tag, message + '\n' + Log.getStackTraceString(tr));
	}
}
