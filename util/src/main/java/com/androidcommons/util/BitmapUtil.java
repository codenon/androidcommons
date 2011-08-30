/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.util;

import java.io.IOException;
import java.io.InputStream;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

/**
 * @author Denis Migol
 * 
 */
public class BitmapUtil {
	private BitmapUtil() {
	}

	public Bitmap decodeStream(final InputStream is, final BitmapFactory.Options opts) throws IOException {
		try {
			return BitmapFactory.decodeStream(is, null, opts);
		} catch (final OutOfMemoryError e) {
			System.gc();
			final Bitmap bitmap = BitmapFactory.decodeStream(is, null, opts);
			is.close();
			return bitmap;
		} finally {
			is.close();
		}
	}

	public Bitmap decodeStream(final ContentResolver resolver, final Uri uri, final BitmapFactory.Options opts)
			throws IOException {
		InputStream is = resolver.openInputStream(uri);
		try {
			return BitmapFactory.decodeStream(is, null, opts);
		} catch (final OutOfMemoryError e) {
			System.gc();
			is = resolver.openInputStream(uri);
			final Bitmap bitmap = BitmapFactory.decodeStream(is, null, opts);
			is.close();
			return bitmap;
		} finally {
			is.close();
		}
	}
}
