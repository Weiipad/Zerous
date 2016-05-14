package com.zerous.zerous.entity;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.math.*;

public class Entity extends GameObject
{
	public Vec2 velocity;
	public boolean landed;
	public Vec2 position;
	public Vec2 drawingPosition, worldPosition;
	public Bitmap body;
	
	float x = 1, y = 1;
	
	
	public enum State
	{
		Right, Left;
	}
	
	public Entity(Bitmap body, Vec2 position)
	{
		this.position = position;
		this.body = body;
		this.velocity = new Vec2(0, 0);
		this.drawingPosition = new Vec2(0, 0);
	}
	
	public Entity(Vec2 pos)
	{
		position = pos;
		velocity = new Vec2(0, 0);
		this.drawingPosition = new Vec2(0, 0);
	}
	
	public void setVelocity(Vec2 v)
	{
		velocity = v;
	}
	
	public float getVelocityY()
	{
		return velocity.y;
	}
	
	public float getVelocityX()
	{
		return velocity.x;
	}
	
	public void setWorldPosition(Vec2 pos)
	{
		worldPosition = pos;
	}
	
	//设置坐标系
	public void set(float x, float y)
	{
		this.x = x;
		this.y = y;
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
		position.add(velocity);
		c.drawBitmap(body, worldPosition.x + (int)position.x * x, worldPosition.y + (int)position.y * y, null);
	}
}
