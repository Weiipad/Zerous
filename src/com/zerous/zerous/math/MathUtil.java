package com.zerous.zerous.math;

import com.zerous.zerous.*;

public class MathUtil
{
	public static boolean isInside(float x, float y, float w, float h)
	{
		if((Core.input.getTouchX(0) > x&&Core.input.getTouchX(0) < x + w&&Core.input.getTouchY(0) > y&&Core.input.getTouchY(0) < y + h)
		   ||(Core.input.getTouchX(1) > x&&Core.input.getTouchX(1) < x + w&&Core.input.getTouchY(1) > y&&Core.input.getTouchY(1) < y + h))
			return true;
		
		return false;
	}
	
	public static boolean isInside(Point position, Size size)
	{
		if((Core.input.getTouchX(0) > position.x - size.w/2&&Core.input.getTouchX(0) < position.x + size.w/2&&Core.input.getTouchY(0) > position.y - size.h/2&&Core.input.getTouchY(0) < position.y + size.h/2 )
		   ||(Core.input.getTouchX(1) > position.x - size.w&&Core.input.getTouchX(1) < position.x + size.w/2&&Core.input.getTouchY(1) > position.y - size.h/2&&Core.input.getTouchY(1) < position.y + size.h/2))
			return true;
		
		return false;
	}
}
