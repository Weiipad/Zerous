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
	boolean isChecked = false;
	public CheckBox(float x, float y, String name)
	{
		position = new Point(x, y);
		checked = Resources.CHECKBOX_CHECKED;
		unchecked = Resources.CHECKBOX_UNCHECKED;
		this.name = name;
		size = new Size(checked.getWidth(), checked.getHeight());
	}
	
	public boolean isChecked()
	{
		return isChecked;
	}

	@Override
	public void draw(Canvas c)
	{
		boolean t = MathUtil.isInside(position, size);
		boolean s = Input.TOUCH_STATE == Input.TOUCH_STATE_DOWN;
		if(t && s)
		{
			isChecked = !isChecked;
		}
		
		if(isChecked)
			src = checked;
		else
			src = unchecked;
			
		c.drawBitmap(src, position.x - size.w/2, position.y - size.h/2, null);
		c.drawText(name, position.x - size.w*2, position.y, new Paint());
	}
}
