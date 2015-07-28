package com.furballwear.apps.pugrz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.activities.BaseActivity;

public class ChooseFileDemoActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_file_demo);
	}


	public void fileUploadDemo(View view){
		Intent intent =  new Intent(ChooseFileDemoActivity.this, UploadFileDemo.class);
		startActivity(intent);
	}
	
	public void remoteFileDemo(View view){
		Intent intent =  new Intent(ChooseFileDemoActivity.this, RemoteFileDemo.class);
		startActivity(intent);
	}
}
