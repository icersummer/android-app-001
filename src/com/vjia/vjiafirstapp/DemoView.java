package com.vjia.vjiafirstapp;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DemoView extends View implements OnTouchListener{
	
	private int sx, sy;
	
	private boolean moving;
	// target
	private int ex, ey;

	public DemoView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
