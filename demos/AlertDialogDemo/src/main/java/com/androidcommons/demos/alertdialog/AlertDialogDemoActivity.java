package com.androidcommons.demos.alertdialog;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidcommons.app.util.AlertDialogUtil;

/**
 * @author Denis Migol
 * 
 */
public class AlertDialogDemoActivity extends Activity {

	private LinkedHashMap<String, Runnable> createTitleDialogMap() {
		final LinkedHashMap<String, Runnable> ret = new LinkedHashMap<String, Runnable>();
		final Context context = this;

		ret.put("OK dialog", new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.alertBuilder(context), R.string.dialog_title,
						R.string.dialog_message);
			}
		});

		ret.put("OK/Cancel dialog", new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkCancelDialog(AlertDialogUtil.alertBuilder(context), R.string.dialog_title,
						R.string.dialog_message, null, null);
			}
		});

		ret.put("Yes/No dialog", new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showYesNoDialog(AlertDialogUtil.alertBuilder(context), R.string.dialog_title,
						R.string.dialog_message, null, null);
			}
		});

		ret.put("Dialer dialog", new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.dialerBuilder(context), R.string.dialog_title,
						R.string.dialog_message);
			}
		});

		ret.put("Email dialog", new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.emailBuilder(context), R.string.dialog_title,
						R.string.dialog_message);
			}
		});

		ret.put("Info dialog", new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.infoBuilder(context), R.string.dialog_title,
						R.string.dialog_message);
			}
		});

		ret.put("Map dialog", new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.mapBuilder(context), R.string.dialog_title,
						R.string.dialog_message);
			}
		});

		return ret;
	}

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		setupListView((ListView) findViewById(R.id.list));
	}

	private void setupListView(final ListView listView) {
		final LinkedHashMap<String, Runnable> titleDialogMap = createTitleDialogMap();
		final ArrayList<String> titles = new ArrayList<String>(titleDialogMap.keySet());

		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,
				titles));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
				titleDialogMap.get(titles.get(position)).run();
			}
		});
	}

}