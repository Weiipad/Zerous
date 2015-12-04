package com.zerous.zerous.entity;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.math.*;

public class Entity extends GameObject
{
	Vec2 position;
	Vec2 velocity;
	Bitmap body;
	
	float x, y;
	
	enum State
	{
		Forward, Back, Left, Right, Fall, Jump, Idle
	}
	
	public Entity(Bitmap body, Vec2 position)
	{
		this.position = position;
		this.body = body;
		this.velocity = new Vec2(0, 0);
	}
	
	public Entity(Vec2 pos)
	{
		position = pos;
		velocity = new Vec2(0, 0);
	}
	
	public void set(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void up()
	{
		position.y -= velocity.y;
	}
	
	public void down()
	{
		position.y += velocity.y;
	}
	
	public void right()
	{
		position.x += velocity.x;
	}
	
	public void left()
	{
		position.x -= velocity.x;
	}
	
	public Vec2 getPosition()
	{
		return position;
	}
	
	public void setPosition(Vec2 pos)
	{
		position = pos;
	}
	
	public void setPosition(float x, float y)
	{
		position = new Vec2(x, y);
	}
	
	@Override
	public void draw(Canvas c)
	{
		c.drawBitmap(body, position.x * x, position.y * y, null);
	}
}
