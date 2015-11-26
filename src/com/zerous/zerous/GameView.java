package com.zerous.zerous;

import android.view.*;
import android.content.*;
import android.graphics.*;
import com.zerous.zerous.screens.*;
import android.util.*;
import android.widget.*;
import com.zerous.zerous.io.*;

public class GameView extends SurfaceView implements Runnable
{
	Paint p;
	volatile boolean running = false;
	SurfaceHolder holder;
	Thread gt;
	Bitmap framebuffer;
	
	Canvas c;
	public Canvas mc;
	
	Screen currentScreen;
	
	public android.content.res.Resources ANDROID_RES;
	
	public GameScreen gameScreen;
	public MainScreen mainScreen;
	public PlayScreen playScreen;
	public SettingScreen settingScreen;
	public AboutScreen aboutScreen;
	
	public Context context;
	
	public GameView(Context c, Bitmap framebuffer)
	{
		super(c);
		holder = this.getHolder();
		
		context = c;
		
		//Toast.makeText(c, "AAA", Toast.LENGTH_LONG).show();
		
		this.framebuffer = framebuffer;
		
		ANDROID_RES = c.getResources();
		
		Utils.init(c);
		Resources.init(c);
		FileOutputer.makeDir("/games/com.zerous");
		
		mainScreen = new MainScreen(this);
		gameScreen = new GameScreen(this);
		playScreen = new PlayScreen(this);
		settingScreen = new SettingScreen(this);
		aboutScreen = new AboutScreen(this);
		
		
		p = new Paint();
		p.setColor(Color.BLACK);
		
		Log.i("GAMEVIEW", "Inited");
	}
	
	public void resume()
	{
		running = true;
		setScreen(mainScreen);
		gt = new Thread(this);
		gt.start();
		Utils.makeToast("AAA");
	}
	
	public void pause()
	{
		running = false;
		while(true)
		{
			try
			{
				gt.join();
				break;
			}
			catch(InterruptedException e)
			{
				
			}
		}
	}

	@Override
	public void run()
	{
		//Utils.makeToast("ABC");
		while(running)
		{
			if(!holder.getSurface().isValid())
				continue;
				
			//Input.TOUCH_2_X = Input.TOUCH_2_Y = 0;
			
			c = holder.lockCanvas();
			currentScreen.draw(c);
			
			if(c != null)
				holder.unlockCanvasAndPost(c);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		try
		{
			Input.count = event.getPointerCount();
			
			Input.TOUCH_X = event.getX();
			Input.TOUCH_Y = event.getY();
			
			if(event.getPointerCount() >= 2)
			{
				Input.TOUCH_2_X = event.getX(1);
				Input.TOUCH_2_Y = event.getY(1);
			}
			else
			{
				Input.TOUCH_2_X = Input.TOUCH_2_Y = 0;
			}
		}
		catch(Exception e)
		{
			
		}
		
		if(event.getAction() == event.ACTION_DOWN 
		|| event.getAction() == event.ACTION_POINTER_DOWN )
			Input.TOUCH_STATE = Input.TOUCH_STATE_DOWN;
		else if(event.getAction() == event.ACTION_UP
		||event.getAction() == event.ACTION_POINTER_UP)
		{
			Input.TOUCH_STATE = Input.TOUCH_STATE_UP;
			//Input.TOUCH_X = Input.TOUCH_Y = Input.TOUCH_2_X = Input.TOUCH_2_Y = 0;
		}
		else if(event.getAction() == event.ACTION_MOVE)
		{
			Input.TOUCH_STATE = Input.TOUCH_STATE_MOVE;
		}
			
		//Input.TOUCH_2_X = Input.TOUCH_2_Y = 0;
		return true;
	}
	
	public void setScreen(Screen scr)
	{
		currentScreen = scr;
	}
}
