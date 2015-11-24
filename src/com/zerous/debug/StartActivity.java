package com.zerous.debug;

import android.app.*;
import android.os.*;
import android.content.*;
import com.zerous.zerous.*;
import android.widget.*;

public class StartActivity extends Activity
{
	TextView t;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		t = new TextView(this);
		t.setText("A");
		setContentView(t);
		
		
		new Handler().postDelayed(new Runnable()
			{
				@Override 
				public void run()
				{
					Intent intent = new Intent(StartActivity.this,MainActivity.class); //跳转
					startActivity(intent); 
					StartActivity.this.finish();//
				}
			}, 10);
	}
}
