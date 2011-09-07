/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;

/**
 * @author Denis Migol
 * 
 */
public final class BitmapUtil {
	private BitmapUtil() {
	}

	private static final int UNCONSTRAINED = -1;

	//
	// BitmapFactory.decodeXXX wrappers
	//

	public static Bitmap decodeFile(final String pathName) {
		try {
			return BitmapFactory.decodeFile(pathName);
		} catch (final OutOfMemoryError e) {
			System.gc();
			return BitmapFactory.decodeFile(pathName);
		}
	}

	public static Bitmap decodeFile(final String pathName, final BitmapFactory.Options opts) {
		try {
			return BitmapFactory.decodeFile(pathName, opts);
		} catch (final OutOfMemoryError e) {
			System.gc();
			return BitmapFactory.decodeFile(pathName, opts);
		}
	}

	public static Bitmap decodeResource(final Resources res, final int id) {
		try {
			return BitmapFactory.decodeResource(res, id);
		} catch (final OutOfMemoryError e) {
			System.gc();
			return BitmapFactory.decodeResource(res, id);
		}
	}

	public static Bitmap decodeResource(final Resources res, final int id, final BitmapFactory.Options opts) {
		try {
			return BitmapFactory.decodeResource(res, id, opts);
		} catch (final OutOfMemoryError e) {
			System.gc();
			return BitmapFactory.decodeResource(res, id, opts);
		}
	}

	public static Bitmap decodeStream(final InputStream is, final Rect outPadding, final BitmapFactory.Options opts)
			throws IOException {
		try {
			return BitmapFactory.decodeStream(is, outPadding, opts);
		} catch (final OutOfMemoryError e) {
			System.gc();
			final Bitmap bitmap = BitmapFactory.decodeStream(is, outPadding, opts);
			is.close();
			return bitmap;
		} finally {
			is.close();
		}
	}

	public static Bitmap decodeStream(final ContentResolver resolver, final Uri uri, final BitmapFactory.Options opts)
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

	//
	// Methods for calculation sample
	//

	private static int computeInitialSampleSize(final BitmapFactory.Options options, final int minSideLength,
			final int maxNumOfPixels) {
		final double w = options.outWidth;
		final double h = options.outHeight;

		final int lowerBound = (maxNumOfPixels == UNCONSTRAINED) ? 1 : (int) Math.ceil(Math
				.sqrt(w * h / maxNumOfPixels));
		final int upperBound = (minSideLength == UNCONSTRAINED) ? 128 : (int) Math.min(Math.floor(w / minSideLength),
				Math.floor(h / minSideLength));

		if (upperBound < lowerBound) {
			// return the larger one when there is no overlapping zone.
			return lowerBound;
		}

		if ((maxNumOfPixels == UNCONSTRAINED) && (minSideLength == UNCONSTRAINED)) {
			return 1;
		} else if (minSideLength == UNCONSTRAINED) {
			return lowerBound;
		} else {
			return upperBound;
		}
	}

	/*
	 * Compute the sample size as a function of minSideLength and
	 * maxNumOfPixels. minSideLength is used to specify that minimal width or
	 * height of a bitmap. maxNumOfPixels is used to specify the maximal size in
	 * pixels that is tolerable in terms of memory usage.
	 * 
	 * The function returns a sample size based on the constraints. Both size
	 * and minSideLength can be passed in as UNCONSTRAINED, which indicates no
	 * care of the corresponding constraint. The functions prefers returning a
	 * sample size that generates a smaller bitmap, unless minSideLength =
	 * UNCONSTRAINED.
	 * 
	 * Also, the function rounds up the sample size to a power of 2 or multiple
	 * of 8 because BitmapFactory only honors sample size this way. For example,
	 * BitmapFactory downsamples an image by 2 even though the request is 3. So
	 * we round up the sample size to avoid OOM.
	 */
	public static int computeSampleSize(final BitmapFactory.Options options, final int minSideLength,
			final int maxNumOfPixels) {
		final int initialSize = computeInitialSampleSize(options, minSideLength, maxNumOfPixels);

		int roundedSize;
		if (initialSize <= 8) {
			roundedSize = 1;
			while (roundedSize < initialSize) {
				roundedSize <<= 1;
			}
		} else {
			roundedSize = (initialSize + 7) / 8 * 8;
		}

		return roundedSize;
	}

	public static int getSample(final BitmapFactory.Options sourceSizes, final int width, final int height) {
		int w = sourceSizes.outWidth;
		int h = sourceSizes.outHeight;

		int sample = 1;
		while (true) {
			if (w / 2 < width || h / 2 < height)
				break;
			w /= 2;
			h /= 2;
			sample <<= 1;
		}
		return sample;
	}

	//
	// scale
	//

	public static double computeScale(final int srcWidth, final int srcHeight, final int dstWidth, final int dstHeight) {
		final double scaleWidth = dstWidth == UNCONSTRAINED ? 1.0 : (double) srcWidth / dstWidth;
		final double scaleHeight = dstHeight == UNCONSTRAINED ? 1.0 : (double) srcHeight / dstHeight;
		return Math.max(scaleWidth, scaleHeight);
	}

	public static BitmapFactory.Options getScaledSizes(final BitmapFactory.Options srcSizes, final int dstWidth,
			final int dstHeight) {
		return getScaledSizes(srcSizes.outWidth, srcSizes.outHeight, dstWidth, dstHeight);
	}

	public static BitmapFactory.Options getScaledSizes(final int srcWidth, final int srcHeight, final int dstWidth,
			final int dstHeight) {
		final double scale = computeScale(srcWidth, srcHeight, dstWidth, dstHeight);
		return getScaledSizes(srcWidth, srcHeight, scale);
	}

	public static BitmapFactory.Options getScaledSizes(final int srcWidth, final int srcHeight, final double scale) {
		final BitmapFactory.Options ret = new BitmapFactory.Options();
		if (scale != 1.0) {
			ret.outWidth = (int) (srcWidth / scale);
			ret.outHeight = (int) (srcHeight / scale);
		} else {
			ret.outWidth = srcWidth;
			ret.outHeight = srcHeight;
		}
		return ret;
	}

	//
	// equals sizes
	//

	// private static boolean equalsSizes(final BitmapFactory.Options sizes1,
	// final BitmapFactory.Options sizes2) {
	// return (sizes1.outWidth == sizes2.outWidth) && (sizes1.outHeight ==
	// sizes2.outHeight);
	// }

	public static boolean equalsSizes(final int width1, final int height1, final int width2, final int height2) {
		return width1 == width2 && height1 == height2;
	}

	//
	//
	//

	public static Bitmap decodeSampledFile(final String pathName, final int width, final int height) {
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(pathName, opts);

		final int sample = getSample(opts, width, height);
		opts = new BitmapFactory.Options();
		opts.inSampleSize = sample;

		return decodeFile(pathName, opts);
	}

	public static Bitmap decodeSampledResource(final Resources res, final int id, final int width, final int height) {
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, id, opts);

		final int sample = getSample(opts, width, height);
		opts = new BitmapFactory.Options();
		opts.inSampleSize = sample;

		return decodeResource(res, id, opts);
	}

	//
	// decode scaled bitmaps - methods for avoiding OOM
	//

	public static Bitmap createScaledBitmap(final Bitmap bitmap, final int dstWidth, final int dstHeight,
			final boolean recycleBitmap) {
		final Bitmap ret;
		if (bitmap != null) {
			if (!equalsSizes(bitmap.getWidth(), bitmap.getHeight(), dstWidth, dstHeight)) {
				final BitmapFactory.Options sizes = getScaledSizes(bitmap.getWidth(), bitmap.getHeight(), dstWidth,
						dstHeight);
				ret = Bitmap.createScaledBitmap(bitmap, sizes.outWidth, sizes.outHeight, true);
				if (recycleBitmap)
					bitmap.recycle();
			} else {
				ret = bitmap;
			}
		} else {
			ret = null;
		}
		return ret;
	}

	public static Bitmap decodeScaledResource(final Resources res, final int id, final int maxSize) {
		return createScaledBitmap(decodeResource(res, id), maxSize, maxSize, true);
	}

	//
	// other utilities
	//

	public static boolean setInNativeAllocTrue(final BitmapFactory.Options options) {
		boolean ret = false;
		if (options != null) {
			final Class<?> clazz = options.getClass();
			try {
				final Field inNativeAlloc = clazz.getDeclaredField("inNativeAlloc");
				inNativeAlloc.setAccessible(true);
				inNativeAlloc.setBoolean(options, Boolean.TRUE);
				ret = true;
			} catch (final SecurityException e) {
			} catch (final NoSuchFieldException e) {
			} catch (final IllegalArgumentException e) {
			} catch (final IllegalAccessException e) {
			}
		}
		return ret;
	}
}
