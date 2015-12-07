package com.zerous.zerous.entity;

import com.zerous.zerous.math.*;
import com.zerous.zerous.*;
import android.graphics.*;

public class Player extends Entity
{
	Animation running, right;
	Bitmap[] runningLeftBitmaps = new Bitmap[4], runningRightBitmaps = new Bitmap[4];
	Bitmap tile;
	
	public int tp;
	
	public Player(Bitmap body, Vec2 position)
	{
		super(body, position);
		
		for(int i = 0;i < runningRightBitmaps.length;i++)
		{
			runningLeftBitmaps[i] = Resources.PlayerAnimation.playerFrames[i];
			runningRightBitmaps[i] = Resources.scale(Resources.PlayerAnimation.playerFrames[i], -1, 1);
		}
		
		running = new Animation(runningLeftBitmaps);
		running.setSpeed(10);
		
		right = new Animation(runningRightBitmaps, 10);
		
		tile = Resources.TILE_PLACER;
	}

	@Override
	public void draw(Canvas c)
	{	
		super.draw(c);
		if(Settings.DEBUG)
		{
			c.drawLine(0, 6 * y, Info.SCREEN_WIDTH, 6 *y, new Paint());
		}
		if(position.y + velocity.y >= 5)
		{
			landed = true;
			velocity.y = 0;
			position.y = 5;
		}
		else
		{
			velocity.y += 0.005f;
			
		}
		
		if(state == State.Left)
		{
			body = running.getFrame();
			tp = -2;
		}
		else if(state == State.Right)
		{
			body = right.getFrame();
			tp = 3;
		}
		
		if(Settings.TILEPLACER_MODE)
			c.drawBitmap(tile, (int)(position.x + tp) * x, (int)(position.y) * y, null);
		
		/*if(position.x >= 5)
			velocity.x = 0;
		else
			velocity.x -= 0.003f;*/
	}
	
	public void jump()
	{	
		if(landed)
		{
			velocity.y = -0.2f;
			landed = false;
		}
		//velocity.y = -0.2f;
	}
}
