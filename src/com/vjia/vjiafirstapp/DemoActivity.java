package com.vjia.vjiafirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class DemoActivity extends Activity {
	DemoView view;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		view=new DemoView(this);
		//quanping
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//
		this.setContentView(view);
	}
}
