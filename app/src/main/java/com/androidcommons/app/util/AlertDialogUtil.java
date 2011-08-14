/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.app.util;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;

/**
 * @author Denis Migol
 * 
 */
public class AlertDialogUtil {

	/**
	 * Don't let anyone instantiate this class.
	 */
	private AlertDialogUtil() {
	}

	//
	// dialog with OK button
	//

	public static void showOkDialog(final Builder builder, final CharSequence title, final CharSequence message) {
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton(android.R.string.ok, null);
		builder.show();
	}

	public static void showOkDialog(final Builder builder, final int titleId, final int messageId) {
		builder.setTitle(titleId);
		builder.setMessage(messageId);
		builder.setPositiveButton(android.R.string.ok, null);
		builder.show();
	}

	//
	// dialog with OK/Cancel buttons
	//

	public static void showOkCancelDialog(final Builder builder, final CharSequence title, final CharSequence message,
			final OnClickListener okListener, final OnClickListener cancelListener) {
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton(android.R.string.ok, okListener);
		builder.setNegativeButton(android.R.string.cancel, cancelListener);
		builder.show();
	}

	public static void showOkCancelDialog(final Builder builder, final int titleId, final int messageId,
			final OnClickListener okListener, final OnClickListener cancelListener) {
		builder.setTitle(titleId);
		builder.setMessage(messageId);
		builder.setPositiveButton(android.R.string.ok, okListener);
		builder.setNegativeButton(android.R.string.cancel, cancelListener);
		builder.show();
	}

	//
	// dialog with Yes/No buttons
	//

	public static void showYesNoDialog(final Builder builder, final CharSequence title, final CharSequence message,
			final OnClickListener yesListener, final OnClickListener noListener) {
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton(android.R.string.yes, yesListener);
		builder.setNegativeButton(android.R.string.no, noListener);
		builder.show();
	}

	public static void showYesNoDialog(final Builder builder, final int titleId, final int messageId,
			final OnClickListener yesListener, final OnClickListener noListener) {
		builder.setTitle(titleId);
		builder.setMessage(messageId);
		builder.setPositiveButton(android.R.string.yes, yesListener);
		builder.setNegativeButton(android.R.string.no, noListener);
		builder.show();
	}

	//
	// alert
	//

	public static Builder alertBuilder(final Context context) {
		return new AlertDialog.Builder(context).setIcon(android.R.drawable.ic_dialog_alert);
	}

	//
	// dialer
	//

	public static Builder dialerBuilder(final Context context) {
		return new AlertDialog.Builder(context).setIcon(android.R.drawable.ic_dialog_dialer);
	}

	//
	// email
	//

	public static Builder emailBuilder(final Context context) {
		return new AlertDialog.Builder(context).setIcon(android.R.drawable.ic_dialog_email);
	}

	//
	// info
	//

	public static Builder infoBuilder(final Context context) {
		return new AlertDialog.Builder(context).setIcon(android.R.drawable.ic_dialog_info);
	}

	//
	// map
	//

	public static Builder mapBuilder(final Context context) {
		return new AlertDialog.Builder(context).setIcon(android.R.drawable.ic_dialog_map);
	}

}
