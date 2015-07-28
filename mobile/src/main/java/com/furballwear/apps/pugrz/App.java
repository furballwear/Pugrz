package com.furballwear.apps.pugrz;

import android.app.Application;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;



import com.furballwear.apps.pugrz.message.MyWakeupListener;

import com.magnet.mmx.client.MMXClient;

import java.util.Random;

public class App extends MultiDexApplication{



	private static App sInstance;

	private static MultiDexApplication multiDexApplication;

	public static App getInstance(){
		return sInstance;
	}



		@Override
	protected void attachBaseContext(Context base) {
			super.attachBaseContext(base);
			MultiDex.install(this);
		}


	public static Context getAppContext() {
		return sInstance.getApplicationContext();
	}


	public static final String API_KEY_ROTTEN_TOMATOES="pugrz";
	@Override
	public void onCreate() {
		super.onCreate();
		sInstance = this;




		MMXClient.registerWakeupListener(this, MyWakeupListener.class);
		 MMXClient.setWakeupInterval(this, 60 * 1000);



	}
	public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(preferenceName, preferenceValue);
		editor.apply();
	}

	public static void saveToPreferences(Context context, String preferenceName, boolean preferenceValue) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putBoolean(preferenceName, preferenceValue);
		editor.apply();
	}

	public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
		return sharedPreferences.getString(preferenceName, defaultValue);
	}

	public static boolean readFromPreferences(Context context, String preferenceName, boolean defaultValue) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
		return sharedPreferences.getBoolean(preferenceName, defaultValue);
	}






	protected void log(String message) {
		System.out.println("log: " + message);
	}








}
