package com.zerous.zerous.math;

public class Vec2
{
	public float x, y;
	public Vec2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vec2 add(Vec2 v)
	{
		x += v.x;
		y += v.y;
		return this;
	}
	
	public Vec2 sub(Vec2 v)
	{
		x -= v.x;
		y -= v.y;
		return this;
	}

	@Override
	public String toString()
	{
		return "x:" + x + "y:" + y;
	}
}
