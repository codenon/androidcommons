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
}
