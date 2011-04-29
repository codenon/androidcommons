/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * @author Denis Migol
 * 
 */
public abstract class ProgressDialogTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

	protected Context context;
	private final ProgressDialog dialog;
	private final String message;

	public ProgressDialogTask(final Context context) {
		this(context, null);
	}

	public ProgressDialogTask(final Context context, final String message) {
		this.context = context;
		dialog = new ProgressDialog(context);
		dialog.setCancelable(false);
		this.message = message;
	}

	@Override
	protected void onPreExecute() {
		if (message != null) {
			dialog.setMessage(message);
		}
		dialog.show();
	}

	@Override
	protected void onPostExecute(final Result result) {
		try {
			dialog.dismiss();
		} catch (final Exception e) {
		}
	}

}
