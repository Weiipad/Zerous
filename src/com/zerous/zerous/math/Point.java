package com.zerous.zerous.math;

public class Point
{
	public int x, y;
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Point(Vec2 vector)
	{
		x = (int)vector.x;
		y = (int)vector.y;
	}
}
