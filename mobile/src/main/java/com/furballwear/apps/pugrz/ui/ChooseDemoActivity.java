package com.furballwear.apps.pugrz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.activities.BaseActivity;
import com.furballwear.apps.pugrz.activities.GameActivity;

public class ChooseDemoActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_demo);

		Button toDoDemo = (Button) findViewById(R.id.button_todo);
		toDoDemo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ChooseDemoActivity.this, GameActivity.class);
				startActivity(intent);
			}
		});
		
		Button fileDemo = (Button) findViewById(R.id.button_file_sample);
		fileDemo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ChooseDemoActivity.this, ChooseFileDemoActivity.class);
				startActivity(intent);
			}
		});
		
		Button logout = (Button) findViewById(R.id.btnLogout);
		logout.setOnClickListener(new OnClickListener() {
			@Override
				public void onClick(View v) {
				 logout();
			}
		});
	}
}



