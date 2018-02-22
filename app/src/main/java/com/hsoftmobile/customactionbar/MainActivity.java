package com.hsoftmobile.customactionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
			ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT);
			actionBar.setCustomView(customView, layoutParams);
			actionBar.setDisplayShowCustomEnabled(true);

			// bind views
			TextView labelTitle = (TextView) customView.findViewById(R.id.label_title);
			ImageButton btnBack = (ImageButton) customView.findViewById(R.id.btn_back);
			ImageButton btnFwd = (ImageButton) customView.findViewById(R.id.btn_fwd);

			// set title
			labelTitle.setText("My action bar");

			// set buttons click listeners
			btnBack.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					showToast("Clicked back button");
				}
			});
			btnFwd.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					showToast("Clicked forward button");
				}
			});
		}
	}

	private void showToast(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
}
