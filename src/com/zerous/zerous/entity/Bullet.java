package com.zerous.zerous.entity;
import android.graphics.*;
import com.zerous.zerous.math.*;
import com.zerous.zerous.world.*;

public class Bullet extends Entity
{
	boolean destoryed = false;
	World w;
	public Bullet(Bitmap body, Vec2 position, World world)
	{
		super(body, position);
		velocity.x = velocity.y = 0.5f;
		w = world;
	}
	
	public void shoot(Vec2 direct)
	{
		velocity.mul(direct);
	}

	@Override
	public void draw(Canvas c)
	{
		if(!destoryed)
		{
			super.draw(c);
			if(w.hasBlock((int)position.x, (int)position.y))
			{
				w.placeBlock((int)position.x, (int)position.y, 0);
				destoryed = true;
			}
		}
		else
		{
			body = null;
			velocity = null;
			position = null;	
		}
	}
}
