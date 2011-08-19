/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.app.util;

import android.content.DialogInterface;

/**
 * @author Denis Migol
 * 
 */
public final class DialogUtil {

	/**
	 * Don't let anyone instantiate this class.
	 */
	private DialogUtil() {
	}

	public static void dismiss(final DialogInterface dialog) {
		try {
			dialog.dismiss();
		} catch (final Exception e) {
			// ignore
		}
	}
}
