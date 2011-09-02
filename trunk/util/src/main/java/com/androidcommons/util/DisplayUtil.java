/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.util;

import android.content.Context;

/**
 * @author Denis Migol
 * 
 */
public final class DisplayUtil {
	private DisplayUtil() {
	}

	public static int dipToPx(final Context context, final int dip) {
		return (int) (dip * context.getResources().getDisplayMetrics().density + 0.5f);
	}
}
