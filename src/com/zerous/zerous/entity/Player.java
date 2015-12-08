package com.zerous.zerous.entity;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.math.*;
import com.zerous.zerous.entity.Entity.State;
import com.zerous.zerous.world.*;

public class Player extends Entity
{
	Animation running, right;
	Bitmap[] runningLeftBitmaps = new Bitmap[4], runningRightBitmaps = new Bitmap[4];
	Bitmap tile;
	World world;
	
	public int tp, count;
	
	public Player(Bitmap body, Vec2 position, World world)
	{
		super(body, position);
		
		this.world = world;
		
		for(int i = 0;i < runningRightBitmaps.length;i++)
		{
			runningLeftBitmaps[i] = Resources.PlayerAnimation.playerFrames[i];
			runningRightBitmaps[i] = Resources.scale(Resources.PlayerAnimation.playerFrames[i], -1, 1);
		}
		
		running = new Animation(runningLeftBitmaps, 10);
		
		right = new Animation(runningRightBitmaps, 10);
		
		tile = Resources.TILE_PLACER;
	}

	@Override
	public void draw(Canvas c)
	{	
		super.draw(c);
		if(world.getBlock((int)position.x, (int)(position.y + 1 + velocity.y)) != 0||world.getBlock((int)position.x + 1, (int)(position.y + 1 + velocity.y)) != 0)
		{
			landed = true;
			velocity.y = 0;
			position.y = position.y - velocity.y;
		}
		else if(world.getBlock((int)position.x, (int)(position.y)) != 0 || world.getBlock((int)position.x + 1, (int)(position.y)) != 0)
		{
			velocity.y = 0;
			position.y = (int)(position.y +1)+ velocity.y;
			velocity.y += 0.005f;
		}
		else
		{
			velocity.y += 0.005f;
			body = running.getFrame();
			
		}
		
		switch(state)
		{
			case Left:
			{
				body = running.getFrame();
				break;
			}
			case Right:
			{
				body = right.getFrame();
				break;
			}
			case Idle:
			{
				body = Resources.I;
			}
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
			//count = 0;
			//state = State.Jump;
		}
		//velocity.y = -0.2f;
	}
}
