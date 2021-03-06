package com.zerous.zerous.ui;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.math.*;

import com.zerous.zerous.math.Vec2;

public class Button extends Ui
{
	private static final int COLOR_BUTTON_UP = 0xFF66CCFF;
	private static final int COLOR_BUTTON_DOWN = COLOR_BUTTON_UP - 2105376;
	
	Vec2 position;
	public Size size;
	public int count;
	String text = null;
	
	Paint textPaint, bug;
	
	Bitmap src, up, down;
	
	boolean clickFlag = false;
	
	OnClickEvent click;
	OnTouchEvent touch;
	
	public Button(float x, float y, float width, float height)
	{
		position = new Vec2(x, y);
		size = new Size(width, height);
		paint = new Paint();
		paint.setAlpha(0x50);
		textPaint = new Paint();
		bug = new Paint();
		textPaint.setColor(Color.BLACK);
		bug.setColor(Color.RED);
		textPaint.setTextAlign(Paint.Align.CENTER);
		textPaint.setTextSize(32);
	}
	
	public Button(float x, float y, Bitmap up, Bitmap down)
	{
		position = new Vec2(x, y);
		this.up = up;
		this.down = down;
		size = new Size(up.getWidth(), up.getHeight());
		paint = new Paint();
		bug = new Paint();
		bug.setColor(Color.RED);
	}
	
	public Button(float x, float y, ButtonSkin bs)
	{
		position = new Vec2(x, y);
		up = bs.getUp();
		down = bs.getDown();
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
		
		boolean a = Core.input.isTouchDown(0) || Core.input.isTouchDown(1);
		boolean b = MathUtil.isInside(position.x - size.w/2, position.y - size.h/2, size.w, size.h);
		
		if(a && b)
		{
			clickFlag = true;
		}
		else
		{
			if(clickFlag)
			{
				if(touch != null)
					touch.onTouchUp();
				if(click != null)	
					click.onClick();
				clickFlag = false;
			}
		}
		
		if(a && b)
		{
			if(up == null && down == null)
				paint.setColor(COLOR_BUTTON_DOWN);
			else
				src = down;
			if(touch != null)	
				touch.onTouchDown();
			
		}
		else
		{
			
			if(up == null && down == null)
				paint.setColor(COLOR_BUTTON_UP);
			else
				src = up;
			
		}
		
		if(up == null && down == null)
		{
			
			c.drawRect(position.x - size.w/2, position.y - size.h/2, position.x + size.w/2, position.y + size.h/2, paint);
			if(text != null)
				c.drawText(text, position.x, position.y, textPaint);
		}
		else
		{
			c.drawBitmap(src, position.x - up.getWidth()/2, position.y - up.getHeight()/2, paint);
			if(Settings.DEBUG)
			{
				c.drawLine(position.x - size.w/2, position.y - size.h/2, position.x + size.w/2, position.y - size.h/2, bug);
				c.drawLine(position.x + size.w/2, position.y - size.h/2, position.x + size.w/2, position.y + size.h/2, bug);
				c.drawLine(position.x + size.w/2, position.y + size.h/2, position.x - size.w/2, position.y + size.h/2, bug);
				c.drawLine(position.x - size.w/2, position.y + size.h/2, position.x - size.w/2, position.y - size.h/2, bug);
				c.drawText("" + count, position.x, position.y, bug);
			}
		}
	}
}
