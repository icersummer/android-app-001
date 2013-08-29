package com.vjia.vjiafirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

public class ResultActivity extends Activity {
	public final int ALERT = 0;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//
		this.showDialog(ALERT);
	}
	
	protected Dialog onCreateDialog(int id){
		if(id==ALERT){
			//
			Builder alert = new AlertDialog.Builder(this);
			// question 1: how to add an drawable-icon
			alert.setIcon(R.drawable.ic_launcher).setTitle("Result Activity inner")
				.setMessage("Target done. \n Press Enter to Return").setPositiveButton("OK", new OnClickListener(){

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						//return to Demo
						Intent intent = new Intent();
						intent.setClass(ResultActivity.this, DemoActivity.class);
						Bundle bundle = new Bundle();
						bundle.putString("age", "12");
						intent.putExtras(bundle);
						startActivity(intent);
					}
					
				});
			return alert.create();
		}
		
		return super.onCreateDialog(id);
		
	}
}
