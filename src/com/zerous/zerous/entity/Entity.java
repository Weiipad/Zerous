package com.zerous.zerous.entity;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.math.*;

public class Entity extends GameObject
{
	Vec3 position;
	Vec3 velocity;
	Bitmap body;
	
	public Entity(Bitmap body, Vec3 position)
	{
		this.position = position;
		this.body = body;
		this.velocity = new Vec3(0, 0, 0);
	}
	
	public Entity(Vec3 pos)
	{
		position = pos;
		velocity = new Vec3(0, 0, 0);
	}
	
	public Vec3 getPosition()
	{
		return position;
	}
	
	public void setPosition(Vec3 pos)
	{
		position = pos;
	}
	
	public void setPosition(float x, float y, float z)
	{
		position = new Vec3(x, y, z);
	}
	
	@Override
	public void draw(Canvas c)
	{
		c.drawBitmap(body, position.x, position.z + position.y, null);
	}
}
