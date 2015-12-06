package com.zerous.zerous.entity;

import com.zerous.zerous.math.*;
import com.zerous.zerous.*;
import android.graphics.*;

public class Player extends Entity
{
	Animation running;
	public Player(Bitmap body, Vec2 position)
	{
		super(body, position);
		
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
			velocity.y += 0.005f;
		
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
	}
}
