package com.zerous.zerous.ui;

import android.graphics.*;
import com.zerous.zerous.math.*;

import com.zerous.zerous.math.Vec2;
import com.zerous.zerous.*;

public class CheckBox extends Ui
{
	Vec2 position;
	String name;
	Size size;
	Bitmap src, checked, unchecked;
	boolean isChecked = false;
	int count;
	public CheckBox(float x, float y, String name)
	{
		position = new Vec2(x, y);
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
		boolean s = Core.input.isTouchDown(0) || Core.input.isTouchDown(1);

		if(t && s)
		{
			count++;
			if(count <= 1)
			{
				isChecked = !isChecked;
			}
		}
		else
		{
			count = 0;
		}
		
		
		if(isChecked)
			src = checked;
		else
			src = unchecked;
			
		c.drawBitmap(src, position.x - size.w/2, position.y - size.h/2, null);
		c.drawText(name, position.x + size.w/2 + Info.GUI_ZOOM, position.y, paint);
	}
	
}
