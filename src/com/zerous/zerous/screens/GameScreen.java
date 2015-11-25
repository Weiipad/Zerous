package com.zerous.zerous.screens;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.ui.*;
import com.zerous.zerous.world.*;

public class GameScreen extends Screen
{
	Button pause, left, right, ahead, back, jump;
	int x, y;
	
	String debug;
	World w;
	
	public GameScreen(GameView g)
	{
		super(g);
		initUi();
		
		w = new World(this);
		
		paint.setTextSize(Info.GUI_ZOOM * 4);
		paint.setAntiAlias(true);
	}
	
	public void initUi()
	{
		pause = new Button(Info.SCREEN_WIDTH - Resources.PAUSE_BUTTON_UP.getWidth()/2, Resources.PAUSE_BUTTON_UP.getHeight()/2, Resources.PAUSE_BUTTON_UP, Resources.PAUSE_BUTTON_DOWN);
		pause.setClickEvent(new Button.OnClickEvent()
			{
				public void onClick()
				{
					game.setScreen(game.mainScreen);
				}
			});

		left = new Button(Resources.LEFT_UP.getWidth()/2, Info.SCREEN_HEIGHT - Resources.LEFT_UP.getHeight()*1.5f, Resources.LEFT_UP, Resources.LEFT_UP);
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

		right = new Button(Resources.RIGHT_UP.getWidth()*2.5f, Info.SCREEN_HEIGHT - Resources.RIGHT_UP.getHeight()*1.5f, Resources.RIGHT_UP, Resources.RIGHT_UP);
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
		
		ahead = new Button(Resources.AHEAD.getWidth()*1.5f, Info.SCREEN_HEIGHT - Resources.AHEAD.getHeight()*2.5f, Resources.AHEAD, Resources.AHEAD);
		ahead.setTouchEvent(new Button.OnTouchEvent()
		{
			public void onTouchDown()
			{
				y -= 5;
			}
			
			public void onTouchUp()
			{
				
			}
		});
		
		back = new Button(Resources.BACK.getWidth()*1.5f, Info.SCREEN_HEIGHT -Resources.BACK.getHeight()/2, Resources.BACK, Resources.BACK);
		back.setTouchEvent(new Button.OnTouchEvent()
		{
			public void onTouchDown()
			{
				y += 5;
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
					debug = "Jump";
				}

				public void onTouchUp()
				{

				}
			});
			
		
	}
	
	public void draw(Canvas c)
	{
		
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
		
		
		w.draw(c);
		//c.drawBitmap(Resources.BLOCK_BASIC, 0, 0, null);
		//c.drawBitmap(Resources.BLOCK_BASIC, Resources.BLOCK_BASIC.getWidth() - Info.PIXEL_SIZE, 0, null);
		//c.drawBitmap(Resources.BLOCK_BASIC, 0, Resources.BLOCK_BASIC.getHeight()/2, null);
		c.drawBitmap(Resources.I, x, y, paint);
		
		
		pause.draw(c);
		left.draw(c);
		right.draw(c);
		jump.draw(c);
		ahead.draw(c);
		back.draw(c);
		if(Settings.DEBUG)
			c.drawText(debug + Input.count , 180, 180, paint);
	}
}
