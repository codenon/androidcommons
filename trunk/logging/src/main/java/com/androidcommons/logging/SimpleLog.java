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

	/**
	 * 
	 * @param message
	 */
	public void verbose(final String message) {
		Log.println(Log.VERBOSE, tag, message);
	}

	/**
	 * 
	 * @param message
	 * @param tr
	 */
	public void verbose(final String message, final Throwable tr) {
		Log.println(Log.VERBOSE, tag, message + '\n' + Log.getStackTraceString(tr));
	}

	/**
	 * 
	 * @param tr
	 */
	public void verbose(final Throwable tr) {
		Log.println(Log.VERBOSE, tag, tr.getMessage() + '\n' + Log.getStackTraceString(tr));
	}

	/**
	 * 
	 * @param message
	 */
	public void debug(final String message) {
		Log.println(Log.DEBUG, tag, message);
	}

	/**
	 * 
	 * @param message
	 * @param tr
	 */
	public void debug(final String message, final Throwable tr) {
		Log.println(Log.DEBUG, tag, message + '\n' + Log.getStackTraceString(tr));
	}

	/**
	 * 
	 * @param tr
	 */
	public void debug(final Throwable tr) {
		Log.println(Log.DEBUG, tag, tr.getMessage() + '\n' + Log.getStackTraceString(tr));
	}

	/**
	 * 
	 * @param message
	 */
	public void info(final String message) {
		Log.println(Log.INFO, tag, message);
	}

	/**
	 * 
	 * @param message
	 * @param tr
	 */
	public void info(final String message, final Throwable tr) {
		Log.println(Log.INFO, tag, message + '\n' + Log.getStackTraceString(tr));
	}

	/**
	 * 
	 * @param tr
	 */
	public void info(final Throwable tr) {
		Log.println(Log.INFO, tag, tr.getMessage() + '\n' + Log.getStackTraceString(tr));
	}

	/**
	 * 
	 * @param message
	 */
	public void warn(final String message) {
		Log.println(Log.WARN, tag, message);
	}

	/**
	 * 
	 * @param message
	 * @param tr
	 */
	public void warn(final String message, final Throwable tr) {
		Log.println(Log.WARN, tag, message + '\n' + Log.getStackTraceString(tr));
	}

	/**
	 * 
	 * @param tr
	 */
	public void warn(final Throwable tr) {
		Log.println(Log.WARN, tag, tr.getMessage() + '\n' + Log.getStackTraceString(tr));
	}

	/**
	 * 
	 * @param message
	 */
	public void error(final String message) {
		Log.println(Log.ERROR, tag, message);
	}

	/**
	 * 
	 * @param message
	 * @param tr
	 */
	public void error(final String message, final Throwable tr) {
		Log.println(Log.ERROR, tag, message + '\n' + Log.getStackTraceString(tr));
	}

	/**
	 * 
	 * @param tr
	 */
	public void error(final Throwable tr) {
		Log.println(Log.ERROR, tag, tr.getMessage() + '\n' + Log.getStackTraceString(tr));
	}
}
