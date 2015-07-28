package com.furballwear.apps.pugrz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.api.UserApi;
import com.furballwear.apps.pugrz.model.Login;
import com.furballwear.apps.pugrz.model.Session;
import com.furballwear.apps.pugrz.utils.IAppConstants;
import com.furballwear.apps.pugrz.utils.PrefUtil;

public class SplashActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		new StartLogin().execute();
	}

	private class StartLogin extends AsyncTask<Void, Void, Boolean>{
		@Override
		protected Boolean doInBackground(Void... params) {
			boolean validSession = false;
			String oldSessionKey = PrefUtil.getString(getApplicationContext(), IAppConstants.SESSION_ID, null);
			String userID = PrefUtil.getString(getApplicationContext(), IAppConstants.EMAIL, null);
			String userPass = PrefUtil.getString(getApplicationContext(), IAppConstants.PWD, null);
			String dspUrl = PrefUtil.getString(getApplicationContext(), IAppConstants.DSP_URL, null);

			if(oldSessionKey == null &&  userID == null && userPass == null && dspUrl == null){ 
				// show splash for 2 secs and go to login
				try { 
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}else{ // previously logged in, check if still valid
				try{
					UserApi userApi = new UserApi();
					userApi.addHeader("X-DreamFactory-Application-Name", IAppConstants.APP_PUGRZ);
					Login login = new Login();
					login.setEmail(userID);
					login.setPassword(userPass);
					userApi.setBasePath(dspUrl + IAppConstants.DSP_URL_SUFIX);
					Session session = userApi.login(login);
					PrefUtil.putString(getApplicationContext(), IAppConstants.SESSION_ID, session.getSession_id());
					validSession = true;
				}catch(Exception e){
					PrefUtil.putString(getApplicationContext(), IAppConstants.SESSION_ID, "");
					PrefUtil.putString(getApplicationContext(), IAppConstants.EMAIL, "");
					PrefUtil.putString(getApplicationContext(), IAppConstants.PWD, "");
				}
			}
			return Boolean.valueOf(validSession);
		}
		@Override
		protected void onPostExecute(Boolean isVaildSession) {
			if(isVaildSession.booleanValue()){

				Intent in= new Intent(SplashActivity.this, MainActivity.class);
				startActivity(in);
				SplashActivity.this.finish();
			}
			else {
				Intent in=new Intent(SplashActivity.this, LoginActivity.class);
				startActivity(in);
				SplashActivity.this.finish();
			}		
			finish();
		}
	} 
}
