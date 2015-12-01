package com.zerous.zerous.ui;

import com.zerous.zerous.*;
import android.graphics.*;

public class List extends Ui
{
	public float listY;
	float a, b;
	public List()
	{
		
	}
	
	public List(float x, float y, float w, float h)
	{
		
	}
	
	@Override
	public void draw(Canvas c)
	{
		if(Input.TOUCH_STATE == Input.TOUCH_STATE_DOWN)
		{
			a = Input.TOUCH_Y - listY;
			//b = Input
			
		}
		else if(Input.TOUCH_STATE == Input.TOUCH_STATE_MOVE)
		{
			listY = Input.TOUCH_X - a;
		}
		
		//c.drawText("T", 0, listY, new Paint());
	}
}
