package com.zerous.zerous.utils;
import android.util.*;
import android.graphics.*;

public class FPSCounter
{
	long startTime = System.nanoTime();
	int frames = 0;
	int fps;
	
	Paint p;
	
	public FPSCounter()
	{
		p = new Paint();
		p.setTextSize(64);
		p.setTextAlign(Paint.Align.LEFT);
	}
	
	public int drawFPS(Canvas c)
	{
		frames++;
		//int fps;
		if(System.nanoTime() - startTime >= 1000000000)
		{
			fps = frames;
			Log.i("FPS", ""+frames);
			
			frames = 0;
			startTime = System.nanoTime();
		}
		c.drawText("FPS:" + fps, 0, 71, p);
		return fps;
	}
}
