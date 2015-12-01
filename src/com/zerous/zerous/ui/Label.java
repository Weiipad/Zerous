package com.zerous.zerous.ui;

import android.graphics.*;
import com.zerous.zerous.*;

public class Label extends Ui
{
	Button back;
	public float height;
	Bitmap src;
	String text;
	GameView game;
	Screen backTo;
	public Label(GameView g, String text)
	{
		game = g;
		src = Resources.LABEL;
		this.text = text;
		height = src.getHeight();
		back = new Button(height/3 + Resources.BACK_BUTTON_UP.getWidth()/2, height / 2, Resources.BACK_BUTTON_UP, Resources.BACK_BUTTON_DOWN);
		back.size.w += 2*Info.GUI_ZOOM;
		back.size.h += 1.5f*Info.GUI_ZOOM;
		paint = new Paint();
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setTextSize(Info.GUI_ZOOM * 4);
	}
	
	public void setBackButtonClickEvent(Button.OnClickEvent click)
	{
		back.setClickEvent(click);
	}
	
	public void setBackButtonTo(Screen s)
	{
		backTo = s;
		back.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(backTo);
			}
		});
	}
	
	@Override
	public void draw(Canvas c)
	{
		c.drawBitmap(src, 0, 0, paint);
		c.drawText(text, Info.SCREEN_WIDTH /2, height/2, paint);
		back.draw(c);
	}
}
