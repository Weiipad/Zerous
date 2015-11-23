package com.zerous.zerous.math;

import com.zerous.zerous.*;

public class MathUtil
{
	public static boolean isInside(float x, float y, float w, float h)
	{
		if(Input.TOUCH_X > x&&Input.TOUCH_X < x + w&&Input.TOUCH_Y > y&&Input.TOUCH_Y < y + h
		   ||Input.TOUCH_2_X > x&&Input.TOUCH_2_X < x + w&&Input.TOUCH_2_Y > y&&Input.TOUCH_2_Y < y + h)
			return true;
		
		return false;
	}
	
	public static boolean isInside(Point position, Size size)
	{
		if(Input.TOUCH_X > position.x - size.w/2&&Input.TOUCH_X < position.x + size.w/2&&Input.TOUCH_Y > position.y - size.h/2&&Input.TOUCH_Y < position.y + size.h/2 
		   ||Input.TOUCH_2_X > position.x - size.w&&Input.TOUCH_2_X < position.x + size.w/2&&Input.TOUCH_2_Y > position.y - size.h/2&&Input.TOUCH_2_Y < position.y + size.h/2)
			return true;
		
		return false;
	}
}
