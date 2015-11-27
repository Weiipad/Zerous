package com.zerous.zerous.ui;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.math.*;

public class SeekBar extends Ui
{
	public float height = 10, x, y, cx, cy, length;
	boolean touched = false;
	public SeekBar(float x, float y, float length)
	{
		this.x = x;
		this.y = y;
		this.length = length;
		paint = new Paint();
		paint.setColor(Color.BLUE);
		cx = this.x - this.length/2;
		cy = this.y;
	}

	@Override
	public void draw(Canvas c)
	{
		paint.setAlpha(255);
		c.drawRect(x - length/2, y - height/2, x + length/2, y + height/2, paint);
		if(MathUtil.isInside(x - length/2, y -  height*8, length, height*16)/*&&Input.TOUCH_STATE == Input.TOUCH_STATE_DOWN*/)
		{
			cx = Input.TOUCH_X;
		}
		
	/*	if(Input.TOUCH_STATE == Input.TOUCH_STATE_UP)
		{
		}*/
		
		
		
		paint.setAlpha(100);
		c.drawCircle(cx, cy, 5*Info.GUI_ZOOM, paint);
		
		if(Settings.DEBUG)
		{
			//c.drawText("" + touched, 200, 300, new Paint());
			Utils.drawBox(c, x - length/2, y -  height*8, length, height*16);
		}
	}
}
