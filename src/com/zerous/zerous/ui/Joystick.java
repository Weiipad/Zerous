package com.zerous.zerous.ui;

import com.zerous.zerous.math.*;
import android.graphics.*;

public class Joystick extends Ui
{
	Vec2 bigPos, smallPos;
	
	float r = 200, sr = 50;
	
	public Joystick(float x, float y)
	{
		bigPos = new Vec2(x, y);
		smallPos = new Vec2(x, y);
	}

	@Override
	public void update(Canvas c)
	{
		smallPos = 
	}

	@Override
	public void draw(Canvas c)
	{
		paint.setAlpha(0x80);
		c.drawCircle(bigPos.x, bigPos.y, r, paint);
		paint.setAlpha(0x40);
		c.drawCircle(smallPos.x, smallPos.y, sr, paint);
	}
}
