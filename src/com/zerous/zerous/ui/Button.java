package com.zerous.zerous.ui;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.math.*;

import com.zerous.zerous.math.Point;

public class Button extends Ui
{
	private static final int COLOR_BUTTON_UP = 0xFF66CCFF;
	private static final int COLOR_BUTTON_DOWN = COLOR_BUTTON_UP - 2105376;
	
	Point position;
	public Size size;
	String text;
	
	Paint textPaint, bug;
	
	Bitmap src, up, down;
	
	boolean clickFlag = true;
	
	OnClickEvent click;
	OnTouchEvent touch;
	
	public Button(float x, float y, float width, float height)
	{
		position = new Point(x, y);
		size = new Size(width, height);
		paint = new Paint();
		textPaint = new Paint();
		bug = new Paint();
		textPaint.setColor(Color.BLACK);
		bug.setColor(Color.RED);
		textPaint.setTextAlign(Paint.Align.CENTER);
	}
	
	public Button(float x, float y, Bitmap up, Bitmap down)
	{
		position = new Point(x, y);
		this.up = up;
		this.down = down;
		size = new Size(up.getWidth(), up.getHeight());
		paint = new Paint();
		bug = new Paint();
		bug.setColor(Color.RED);
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public void setClickEvent(OnClickEvent click)
	{
		this.click = click;
	}
	
	public void setTouchEvent(OnTouchEvent touch)
	{
		this.touch = touch;
	}

	public interface OnClickEvent
	{
		public void onClick()
	}
	
	public interface OnTouchEvent
	{
		public void onTouchDown()
		public void onTouchUp()
	}
	
	@Override
	public void draw(Canvas c)
	{
		boolean a = Input.TOUCH_STATE == Input.TOUCH_STATE_DOWN || Input.TOUCH_STATE == Input.TOUCH_STATE_MOVE;
		boolean b = MathUtil.isInside(position.x - size.w/2, position.y - size.h/2, size.w, size.h);
		if(a && b)
		{
			if(up == null && down == null)
				paint.setColor(COLOR_BUTTON_DOWN);
			else
				src = down;
			if(touch != null)	
				touch.onTouchDown();
			clickFlag = false;
		}
		else
		{
			if(up == null && down == null)
				paint.setColor(COLOR_BUTTON_UP);
			else
				src = up;
			if(touch != null)
				touch.onTouchUp();
			if(Input.TOUCH_STATE == Input.TOUCH_STATE_UP && click != null && b && !clickFlag)
			{
				click.onClick();
				clickFlag = true;
			}
		}
		
		if(up == null && down == null)
		{
			c.drawText(text, position.x, position.y, textPaint);
			c.drawRect(position.x - size.w/2, position.y - size.h/2, position.x + size.w/2, position.y + size.h/2, paint);
			
		}
		else
		{
			c.drawBitmap(src, position.x - size.w/2, position.y - size.h/2, null);
			if(Settings.DEBUG)
			{
				c.drawLine(position.x - size.w/2, position.y - size.h/2, position.x + size.w/2, position.y - size.h/2, bug);
				c.drawLine(position.x + size.w/2, position.y - size.h/2, position.x + size.w/2, position.y + size.h/2, bug);
				c.drawLine(position.x + size.w/2, position.y + size.h/2, position.x - size.w/2, position.y + size.h/2, bug);
				c.drawLine(position.x - size.w/2, position.y + size.h/2, position.x - size.w/2, position.y - size.h/2, bug);
			}
		}
	}
}
