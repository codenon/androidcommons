package com.androidcommons.demos.alertdialog;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
		final Resources res = getResources();

		final String message = res.getString(R.string.dialog_message);

		final String okDialog = res.getString(R.string.ok_dialog);
		ret.put(okDialog, new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.alertBuilder(context), okDialog, message);
			}
		});

		final String okCancelDialog = res.getString(R.string.ok_cancel_dialog);
		ret.put(okCancelDialog, new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkCancelDialog(AlertDialogUtil.alertBuilder(context), okCancelDialog, message,
						null, null);
			}
		});

		final String yesNoDialog = res.getString(R.string.yes_no_dialog);
		ret.put(yesNoDialog, new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showYesNoDialog(AlertDialogUtil.alertBuilder(context), yesNoDialog, message, null, null);
			}
		});

		final String dialerDialog = res.getString(R.string.dialer_dialog);
		ret.put(dialerDialog, new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.dialerBuilder(context), dialerDialog, message);
			}
		});

		final String emailDialog = res.getString(R.string.email_dialog);
		ret.put(emailDialog, new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.emailBuilder(context), emailDialog, message);
			}
		});

		final String infoDialog = res.getString(R.string.info_dialog);
		ret.put(infoDialog, new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.infoBuilder(context), infoDialog, message);
			}
		});

		final String mapDialog = res.getString(R.string.map_dialog);
		ret.put(mapDialog, new Runnable() {

			@Override
			public void run() {
				AlertDialogUtil.showOkDialog(AlertDialogUtil.mapBuilder(context), mapDialog, message);
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