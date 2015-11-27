package com.zerous.zerous.ui;

import android.graphics.*;
import com.zerous.zerous.*;

public class Label extends Ui
{
	Button back;
	public float height;
	Bitmap src;
	String text;
	public Label(String text)
	{
		src = Resources.LABEL;
		this.text = text;
		height = src.getHeight();
		back = new Button(height/3 + Resources.BACK_BUTTON_UP.getWidth()/2, height / 2, Resources.BACK_BUTTON_UP, Resources.BACK_BUTTON_DOWN);
		back.size.w += 2*Info.GUI_ZOOM;
		back.size.h += Info.GUI_ZOOM;
		paint = new Paint();
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setTextSize(Info.GUI_ZOOM * 4);
	}
	
	public void setBackButtonClickEvent(Button.OnClickEvent click)
	{
		back.setClickEvent(click);
	}

	@Override
	public void draw(Canvas c)
	{
		c.drawBitmap(src, 0, 0, paint);
		c.drawText(text, Info.SCREEN_WIDTH /2, height/2, paint);
		back.draw(c);
	}
}
