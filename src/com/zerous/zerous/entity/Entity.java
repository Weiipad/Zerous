package com.zerous.zerous.entity;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.math.*;

public class Entity extends GameObject
{
	Vec3 position;
	Bitmap body;
	
	public Entity(Bitmap body, Vec3 position)
	{
		this.position = position;
		this.body = body;
	}
	
	@Override
	public void draw(Canvas c)
	{
		
	}
}
