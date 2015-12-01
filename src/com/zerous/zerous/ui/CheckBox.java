package com.zerous.zerous.ui;

import android.graphics.*;
import com.zerous.zerous.math.*;

import com.zerous.zerous.math.Point;
import com.zerous.zerous.*;

public class CheckBox extends Ui
{
	Point position;
	String name;
	Size size;
	Bitmap src, checked, unchecked;
	boolean isChecked = false, clickFlag;
	public CheckBox(float x, float y, String name)
	{
		position = new Point(x, y);
		checked = Resources.CHECKBOX_CHECKED;
		unchecked = Resources.CHECKBOX_UNCHECKED;
		this.name = name;
		size = new Size(checked.getWidth(), checked.getHeight());
		paint = new Paint();
		paint.setTextSize(32);
	}
	
	public boolean isChecked()
	{
		return isChecked;
	}
	
	public void setState(boolean state)
	{
		isChecked = state;
	}

	@Override
	public void draw(Canvas c)
	{
		boolean t = MathUtil.isInside(position, size);
		boolean s = Input.TOUCH_STATE == Input.TOUCH_STATE_DOWN || Input.TOUCH_STATE == Input.TOUCH_STATE_MOVE;
		if(t && s)
		{
			clickFlag = false;
		}
		else
		{
			if(Input.TOUCH_STATE == Input.TOUCH_STATE_UP && t && !clickFlag)
			{
				isChecked = !isChecked;
				clickFlag = true;
			}
		}
		
		if(isChecked)
			src = checked;
		else
			src = unchecked;
			
		c.drawBitmap(src, position.x - size.w/2, position.y - size.h/2, null);
		c.drawText(name, position.x + size.w/2 + Info.GUI_ZOOM, position.y, paint);
	}
	
}
