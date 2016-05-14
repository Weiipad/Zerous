package com.zerous.zerous.ui;

import com.zerous.zerous.*;
import android.graphics.*;

public class GameList extends Ui
{
	public float listY;
	float a, b;
	public GameList()
	{
		
	}
	
	public GameList(float x, float y, float w, float h)
	{
		
	}
	
	@Override
	public void draw(Canvas c)
	{
		if(OldInput.TOUCH_STATE == OldInput.TOUCH_STATE_DOWN)
		{
			//a = OldInput.TOUCH_Y - listY;
			//b = Input
			
		}
		else if(OldInput.TOUCH_STATE == OldInput.TOUCH_STATE_MOVE)
		{
			//listY = OldInput.TOUCH_X - a;
		}
		
		//c.drawText("T", 0, listY, new Paint());
	}
}
