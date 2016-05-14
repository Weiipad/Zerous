package com.zerous.zerous;

import android.view.*;
import android.content.*;
import android.graphics.*;
import com.zerous.zerous.screens.*;
import android.util.*;
import android.widget.*;
import com.zerous.zerous.io.*;
import java.io.*;
import android.os.*;
import com.zerous.zerous.input.*;

public class GameView extends SurfaceView implements Runnable
{
	Paint p;
	volatile boolean running = false;
	SurfaceHolder holder;
	Thread gt;
	Bitmap framebuffer;
	
	Canvas c;
	
	Screen currentScreen;
	
	public android.content.res.Resources androidRes;
	
	public GameScreen gameScreen;
	public MainScreen mainScreen;
	public PlayScreen playScreen;
	public SettingScreen settingScreen;
	public AboutScreen aboutScreen;
	public DebugScreen debugScreen;
	
	public Context context;
	
	Input input;
	
	public GameView(Context c, Bitmap framebuffer)
	{
		super(c);
		holder = this.getHolder();
		
		context = c;
		Core.input = new AndroidInput(this);
		
		if(!new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Info.GAME_PATH).exists())
			new File(Environment.getExternalStorageDirectory()
								.getAbsolutePath() 
								+ "/" 
								+ Info.GAME_PATH).mkdirs();
		Settings.load();
		
		this.framebuffer = framebuffer;
		
		androidRes = c.getResources();
		
		Utils.init(c);
		Resources.init();
		
		
		mainScreen = new MainScreen(this);
		gameScreen = new GameScreen(this, mainScreen);
		playScreen = new PlayScreen(this, mainScreen);
		settingScreen = new SettingScreen(this, mainScreen);
		aboutScreen = new AboutScreen(this, mainScreen);
		debugScreen = new DebugScreen(this, settingScreen);
		
		
		p = new Paint();
		p.setColor(Color.BLACK);
		
		Log.i("GAMEVIEW", "Inited");
	}
	
	public void resume()
	{
		
		running = true;
		//setScreen(debugScreen);
		if(Settings.QUICK_START)
			setScreen(gameScreen);
		else
			setScreen(mainScreen);
		gt = new Thread(this);
		gt.start();
		Settings.load();
	}
	
	public void pause()
	{
		Settings.save();
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
			currentScreen.drawChildren(c);
			
			if(c != null)
				holder.unlockCanvasAndPost(c);
		}
	}

	public boolean onBackPressed()
	{
		if(currentScreen.parent != null) 
		{
			setScreen(currentScreen.parent);
			return false;
		}
		return true;
	}
	
	public Input getInput()
	{
		return input;
	}
	
	public void setScreen(Screen scr)
	{
		currentScreen = scr;
	}
}
