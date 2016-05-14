package com.zerous.zerous.ui;
import android.graphics.*;

public class InputField extends Ui
{
	int x, y, w, h;
	public InputField(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.w = width;
		this.h = height;
		paint.setStyle(Paint.Style.STROKE);
	}

	@Override
	public void draw(Canvas c)
	{
		c.drawRect(x, y, x + w, y + h, paint);
	}
}
