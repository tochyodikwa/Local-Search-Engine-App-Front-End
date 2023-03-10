package com.tochy.magictips;

import java.util.ArrayList;
import java.util.HashMap;


import com.tochy.magictrik.R;

import framework.AlertDialogManager;
import framework.BaseActivity;
import framework.ConnectionDetector;

import android.os.Bundle;
import android.os.PowerManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.Window;


public class Splash extends BaseActivity {
	public int progressBarStatus = 0;
	final String PREFS_NAME = "MyPrefsFile";
	SharedPreferences settings;
	PowerManager.WakeLock wl;
	
	AlertDialogManager alert = new AlertDialogManager();
	
	// Internet detector
	ConnectionDetector cd;
	ArrayList<HashMap<String, String>> mainmenuarray,adsArray;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
		wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Do not screen off");
		
		
		cd = new ConnectionDetector(getApplicationContext());
		  settings = getSharedPreferences(PREFS_NAME, 0);
		  
		  Thread background = new Thread() {
	            public void run() {
	                 
	                try {
	                    // Thread will sleep for 5 seconds
	                    sleep(2*1000);
	                    //Remove activity
	                    Intent intent = new Intent(Splash.this,HomeActiviry.class);
	            		startActivity(intent);
	                } catch (Exception e) {
	                }
	            }
		  };
	         
	        // start thread
		  background.start();
		
		
	      		    
		    // firstT.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		    // startActivity(firstT);
		     

		     
		     
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		super.onDestroy();
	}
	
	
	

	//Destroy Welcome_screen.java after it goes to next activity
	@Override
	protected void onPause() 
	    {
	    // TODO Auto-generated method stub
	    super.onPause();
	    	finish();
	    	
	    	
	    }
}
