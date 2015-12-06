package com.zerous.zerous;

import android.graphics.*;

public class Animation
{
	private Bitmap[] frames;
	private int frame, fps = 0, speed;
	public Animation(Bitmap[] frames, int speed)
	{
		this.frames = frames;
		this.speed = speed;
	}
	
	public Animation(Bitmap[] frames)
	{
		this.frames = frames;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int getFrameCount()
	{
		return frame;
	}
	
	public Bitmap getFrame()
	{
		fps ++;
		if(fps % speed == 0)
		{
			if(frame < frames.length - 1)
			{
				frame ++;
			}
			else
			{
				frame = 0;
			}
		}
		
		return frames[frame];
	}
}
