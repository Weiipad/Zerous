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
		
		
		if(Settings.DEBUG)
		{
			/*
			Utils.drawBox(c, (int)Math.rint(position.x) * x, (int)(Math.rint(position.y) - 1) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)Math.rint(position.x) * x, (int)(Math.rint(position.y) + 1) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)(Math.rint(position.x) + 1) * x, (int)Math.rint(position.y) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)(Math.rint(position.x) - 1) * x, (int)Math.rint(position.y) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			*/
			Utils.drawBox(c, (int)(position.x) * x, (int)(position.y - 1) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)(position.x) * x, (int)(position.y + 1) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)(position.x + 1) * x, (int)(position.y) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)(position.x - 1) * x, (int)(position.y) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)(position.x + 1) * x, (int)(position.y - 1) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)(position.x + 1) * x, (int)(position.y + 1) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)(position.x + 1) * x, (int)(position.y + 1) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
			Utils.drawBox(c, (int)(position.x - 1) * x, (int)(position.y + 1) * y, Info.TILE_WIDTH, Info.TILE_HEIGHT);
		}
		if(Settings.TILEPLACER_MODE)
			c.drawBitmap(tile, (int)(position.x + tp) * x, (int)(position.y) * y, null);
	}
	
	public void jump()
	{	
		if(landed && !world.hasBlock((int)position.x, (int)position.y - 1))
		{
			velocity.y = -0.2f;
			landed = false;
		}
		//velocity.y = -0.2f;
	}
}
