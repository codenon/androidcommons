/**
 * Copyright (C) 2011 Android Commons
 * 
 * http://www.androidcommons.com/
 */
package com.androidcommons.logging.demo;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author Denis Migol
 * 
 */
public class DemoActivity extends Activity {

	private static final Log LOG = Log.getInstance();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		LOG.debug("onCreate");
	}

	@Override
	protected void onStart() {
		super.onStart();
		LOG.debug("onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		LOG.debug("onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		LOG.debug("onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		LOG.debug("onStop");
	}

	@Override
	protected void onDestroy() {
		LOG.debug("onDestroy");
		super.onDestroy();
	}

}
