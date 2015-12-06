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
		if(position.y >= 5)
			velocity.y = 0;
		else
			velocity.y += 0.003f;
	}
}
