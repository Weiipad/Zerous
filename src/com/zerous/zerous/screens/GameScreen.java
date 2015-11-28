package com.zerous.zerous.screens;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.ui.*;
import com.zerous.zerous.world.*;
import android.widget.Toast;

public class GameScreen extends Screen
{
	Button pause, left, right, ahead, back, jump;
	int x, y;
	
	String debug;
	World w;
	
	boolean j;
	
	public GameScreen(GameView g)
	{
		super(g);
		initUi();
		
		this.x = Info.SCREEN_WIDTH/2;
		this.y = Info.SCREEN_HEIGHT/2;
		
		w = new World(this);
		
		paint.setTextSize(Info.GUI_ZOOM * 4);
		paint.setAntiAlias(true);
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
		
		super.draw(c);
		w.draw(c);
		//c.drawBitmap(Resources.BLOCK_BASIC, 0, 0, null);
		//c.drawBitmap(Resources.BLOCK_BASIC, Resources.BLOCK_BASIC.getWidth() - Info.PIXEL_SIZE, 0, null);
		//c.drawBitmap(Resources.BLOCK_BASIC, 0, Resources.BLOCK_BASIC.getHeight()/2, null);
		c.drawBitmap(Resources.I, x, y, paint);
		
		jump(j);
		
		pause.draw(c);
		left.draw(c);
		right.draw(c);
		jump.draw(c);
		ahead.draw(c);
		back.draw(c);
		if(Settings.DEBUG)
			c.drawText(debug + Input.count , 180, 180, paint);
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

		left = new Button(Resources.LEFT_UP.getWidth(), Info.SCREEN_HEIGHT - Resources.LEFT_UP.getHeight()*2, Resources.LEFT_UP, Resources.LEFT_UP);
		left.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					//x-=5;
					w.x+=5;
				}

				public void onTouchUp()
				{

				}
			});

		right = new Button(Resources.RIGHT_UP.getWidth()*3, Info.SCREEN_HEIGHT - Resources.RIGHT_UP.getHeight()*2, Resources.RIGHT_UP, Resources.RIGHT_UP);
		right.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					//x+=5;
					w.x-=5;
				}

				public void onTouchUp()
				{

				}
			});

		ahead = new Button(Resources.AHEAD.getWidth()*2, Info.SCREEN_HEIGHT - Resources.AHEAD.getHeight()*3, Resources.AHEAD, Resources.AHEAD);
		ahead.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					//y -= 5;
					w.y+=5;
				}

				public void onTouchUp()
				{

				}
			});

		back = new Button(Resources.BACK.getWidth()*2, Info.SCREEN_HEIGHT -Resources.BACK.getHeight(), Resources.BACK, Resources.BACK);
		back.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					//y += 5;
					w.y-=5;
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
					j = true;
					//Utils.makeToast(debug);
					//Oops, I can't use the Toast
					/*try
					 {
					 Toast.makeText(game.context, "Jump", Toast.LENGTH_SHORT).show();
					 }catch(Exception e)
					 {

					 }*/
				}

				public void onTouchUp()
				{
					j = false;
				}
			});
	}
	
	public void jump(boolean jumping)
	{
		int a = 0;
		if(jumping && a<10)
		{
			w.y++;
		}
	}
}
