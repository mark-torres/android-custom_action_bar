package com.hsoftmobile.customactionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

// SOURCE: http://stacktips.com/tutorials/android/actionbar-with-custom-view-example-in-android

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setSupportActionBar((Toolbar) findViewById(R.id.toolbar_custom));
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			// disable home button
			actionBar.setDisplayShowHomeEnabled(false);
			// disable title
			actionBar.setDisplayShowTitleEnabled(false);


			LayoutInflater inflater = LayoutInflater.from(this);
			View customView = inflater.inflate(R.layout.custom_action_bar, null);
			TextView labelTitle = (TextView) customView.findViewById(R.id.label_title);
			labelTitle.setText("My action bar");

			ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT);
			actionBar.setCustomView(customView, layoutParams);
			actionBar.setDisplayShowCustomEnabled(true);
		}
	}
}
