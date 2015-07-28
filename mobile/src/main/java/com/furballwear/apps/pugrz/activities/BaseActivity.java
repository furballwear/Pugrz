package com.furballwear.apps.pugrz.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import java.util.Random;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.utils.IAppConstants;
import com.furballwear.apps.pugrz.utils.PrefUtil;

public class BaseActivity extends AppCompatActivity {
	protected String dsp_url;
	protected String session_id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle(" ");

		dsp_url = PrefUtil.getString(this, IAppConstants.DSP_URL);
		dsp_url += IAppConstants.DSP_URL_SUFIX;
		session_id = PrefUtil.getString(this, IAppConstants.SESSION_ID);

	}

	protected void log(String message) {
		System.out.println("log: " + message);
	}

	protected void logout() {
		PrefUtil.putString(getApplicationContext(), IAppConstants.SESSION_ID, "");
		PrefUtil.putString(getApplicationContext(), IAppConstants.EMAIL, "");
		PrefUtil.putString(getApplicationContext(), IAppConstants.PWD, "");
		Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("EXIT", true);
		startActivity(intent);
		finish();
	}




		private static final Random RANDOM = new Random();

		public static int getRandomCheeseDrawable() {
			switch (RANDOM.nextInt(10)) {
				default:
				case 0:
					return R.drawable.mindgames;
				case 1:
					return R.drawable.magic;
				case 2:
					return R.drawable.magic2;
				case 3:
					return R.drawable.ct;
				case 4:
					return R.drawable.dnd;
				case 5:
					return R.drawable.steampunk_dinosaurs;
				case 6:
					return R.drawable.mindgames;
				case 7:
					return R.drawable.game;
				case 8:
					return R.drawable.tabletop;
				case 9:
					return R.drawable.dnd;
			}
		}

	}

