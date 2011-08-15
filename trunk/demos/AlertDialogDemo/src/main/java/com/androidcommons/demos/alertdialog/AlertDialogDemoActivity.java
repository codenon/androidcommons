package com.androidcommons.demos.alertdialog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * @author Denis Migol
 * 
 */
public class AlertDialogDemoActivity extends Activity {

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final ListView listView = (ListView) findViewById(R.id.list);
	}
}