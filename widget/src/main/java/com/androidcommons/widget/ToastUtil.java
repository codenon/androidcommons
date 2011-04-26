/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.widget;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Denis Migol
 * 
 */
public class ToastUtil {
	private ToastUtil() {
	}

	public static void showText(final Context context, final String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

	public static void showNotImplemented(final Context context) {
		showText(context, "Not yet implemented");
	}
}
