package com.zerous.zerous.math;

public class Vec2
{
	public float x, y;
	public Vec2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vec2 cpy()
	{
		return new Vec2(x, y);
	}
	
	public Vec2 add(Vec2 v)
	{
		x += v.x;
		y += v.y;
		return this;
	}
	
	public Vec2 add(float x, float y)
	{
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Vec2 add(float xy)
	{
		x += xy;
		y += xy;
		return this;
	}
	
	public Vec2 sub(Vec2 v)
	{
		x -= v.x;
		y -= v.y;
		return this;
	}
	
	public Vec2 mul(Vec2 v)
	{
		x *= v.x;
		y *= v.y;
		return this;
	}
	
	public Vec2 mul(float xy)
	{
		x *= xy;
		y *= xy;
		return this;
	}

	@Override
	public String toString()
	{
		return "x:" + x + "y:" + y;
	}
}
