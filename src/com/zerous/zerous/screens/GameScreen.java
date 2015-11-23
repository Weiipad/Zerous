package com.zerous.zerous.screens;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.ui.*;

public class GameScreen extends Screen
{
	Button pause, left, right, jump;
	int x, y;
	
	String debug;
	
	public GameScreen(GameView g)
	{
		super(g);
		pause = new Button(Info.SCREEN_WIDTH - Resources.PAUSE_BUTTON_UP.getWidth()/2, Resources.PAUSE_BUTTON_UP.getHeight()/2, Resources.PAUSE_BUTTON_UP, Resources.PAUSE_BUTTON_DOWN);
		pause.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(game.mainScreen);
			}
		});
		
		left = new Button(Resources.LEFT_UP.getWidth(), Info.SCREEN_HEIGHT - Resources.LEFT_UP.getHeight(), Resources.LEFT_UP, Resources.LEFT_UP);
		left.setTouchEvent(new Button.OnTouchEvent()
		{
			public void onTouchDown()
			{
				x-=5;
			}
			
			public void onTouchUp()
			{
				
			}
		});
		
		right = new Button(Resources.RIGHT_UP.getWidth()*3, Info.SCREEN_HEIGHT - Resources.RIGHT_UP.getHeight(), Resources.RIGHT_UP, Resources.RIGHT_UP);
		right.setTouchEvent(new Button.OnTouchEvent()
		{
			public void onTouchDown()
			{
				x+=5;
			}
			
			public void onTouchUp()
			{
				
			}
		});
		
		jump = new Button(Info.SCREEN_WIDTH - Resources.JUMP.getWidth(), Info.SCREEN_HEIGHT - Resources.JUMP.getHeight(), Resources.JUMP, Resources.JUMP);
		jump.setTouchEvent(new Button.OnTouchEvent()
		{
			public void onTouchDown()
			{
				y -= 5;
			}
			
			public void onTouchUp()
			{
				
			}
		});
		
		paint.setTextSize(Info.GUI_ZOOM * 4);
		paint.setAntiAlias(true);
	}
	
	public void draw(Canvas c)
	{
		y++;
		
		switch(Input.TOUCH_STATE)
		{
			case Input.TOUCH_STATE_DOWN:
				debug = "TOUCH_DOWN";
				break;
			case Input.TOUCH_STATE_MOVE:
				debug = "TOUCH_MOVE";
				break;
			case Input.TOUCH_STATE_UP:
				debug = "TOUCH_UP";
				break;
		}
		
		c.drawColor(Color.WHITE);
		if(Settings.DEBUG)
			c.drawText(debug + Input.count , 180, 180, paint);
		
		c.drawBitmap(Resources.BLOCK_BASIC, 0, 0, null);
		c.drawBitmap(Resources.BLOCK_BASIC, 15, 0, null);
		c.drawBitmap(Resources.BLOCK_BASIC, 0, 9, null);
		c.drawRect(x, y, x + 100, y + 100, paint);
		pause.draw(c);
		left.draw(c);
		right.draw(c);
		jump.draw(c);
	}
}
