package com.zerous.zerous.entity;

import android.graphics.Canvas;
import android.graphics.Bitmap;

import com.zerous.zerous.*;
import com.zerous.zerous.math.*;
import com.zerous.zerous.ui.*;

public class NEntity extends GameObject
{
	Vec2 position, direct;
	float speed;
	Bitmap body;
	
	Point worldPosition;
	
	Controller controller;
	
	public NEntity()
	{
		init();
	}
	
	public NEntity(float speed)
	{
		init();
		this.speed = speed;
	}
	
	public NEntity(Bitmap body, float speed)
	{
		init();
		this.speed = speed;
		this.body = body;
	}

	@Override
	public void update(Canvas c)
	{
		worldPosition = new Point(position);
		position.add(direct.mul(speed));
	}
	
	@Override
	public void draw(Canvas c)
	{
		
	}
	
	public void setSpeed()
	{
		
	}
	
	private void init()
	{
		position = new Vec2(0, 0);
		direct = new Vec2(0, 0);
	}
}
