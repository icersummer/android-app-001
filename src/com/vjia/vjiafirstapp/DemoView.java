package com.vjia.vjiafirstapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DemoView extends View implements OnTouchListener{
	
	private int sx, sy;
	
	private boolean moving;
	// target
	private int ex, ey;
	
	private Handler handler;

	public DemoView(Context context) {
		super(context);
		// initial position
		sx = sy = 50;
		moving = false;
		handler = new Handler();
		// set listener
		setOnTouchListener(this);
	}
	
	//re-write it
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		//
		logic();
		// 
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		//
		Rect screen = new Rect(0,0,320,480);
		//
		canvas.drawRect(screen, paint);
		//
		Rect sq = new Rect(sx, sy, sx+20, sy+20);
		paint.setColor(Color.BLUE);
		//
		canvas.drawRect(sq, paint);
	}

	//control moving
	private void logic() {
		// TODO Auto-generated method stub
		if(sx < ex){
			sx ++;
		}
		
		if(sx > ex){
			sx --;
		}
		if(sy < ey){
			sy ++;
		}
		if(sy > ey){
			sy --;
		}
		
		if(sx ==ex && sy==ey){
			//
			handler.removeCallbacks(moveThread);
			moving = false;
			Intent intent = new Intent();
			intent.setClass(getContext(), ResultActivity.class);
			getContext().startActivity(intent);
		}
	}
	

	@Override
	public boolean onTouch(View view, MotionEvent me) {
		// TODO Auto-generated method stub
		if(!moving){
			//
			ex = (int) me.getX();
			ey = (int) me.getY();
			moving = !moving;
			// first time
			handler.postAtTime(moveThread, 1);
			System.out.println("pos:" + ex + "," + ey + "," + "sx" +"," +"sy");
		}
		return true;
	}
	
	private Runnable moveThread = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			invalidate();
			handler.postDelayed(moveThread, 10);
		}
		
	};

}
