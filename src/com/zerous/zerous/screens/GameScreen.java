package com.zerous.zerous.screens;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.ui.*;
import com.zerous.zerous.world.*;
import android.widget.Toast;
import com.zerous.zerous.entity.*;
import com.zerous.zerous.math.*;
import com.zerous.zerous.utils.*;

public class GameScreen extends Screen
{
	Button pause, left, right, ahead, back, jump, place;
	int x, y;
	
	String debug;
	World w;
	TilePlacer t;
	
	Player pl;
	
	FPSCounter fps;
	
	boolean j, ab;
	
	public GameScreen(GameView g)
	{
		super(g);
		pause = new Button(Info.SCREEN_WIDTH - Resources.PAUSE_BUTTON_UP.getWidth()/2, Resources.PAUSE_BUTTON_UP.getHeight()/2, Resources.PAUSE_BUTTON_UP, Resources.PAUSE_BUTTON_DOWN);
		left = new Button(Resources.LEFT_UP.getWidth(), Info.SCREEN_HEIGHT - Resources.LEFT_UP.getHeight()*2, Resources.LEFT_UP, Resources.LEFT_UP);
		right = new Button(Resources.RIGHT_UP.getWidth()*3, Info.SCREEN_HEIGHT - Resources.RIGHT_UP.getHeight()*2, Resources.RIGHT_UP, Resources.RIGHT_UP);
		ahead = new Button(Resources.AHEAD.getWidth()*2, Info.SCREEN_HEIGHT - Resources.AHEAD.getHeight()*3, Resources.AHEAD, Resources.AHEAD);
		back = new Button(Resources.BACK.getWidth()*2, Info.SCREEN_HEIGHT -Resources.BACK.getHeight(), Resources.BACK, Resources.BACK);
		jump = new Button(Info.SCREEN_WIDTH - Resources.JUMP.getWidth()/2, Info.SCREEN_HEIGHT - Resources.JUMP.getHeight()/2, Resources.JUMP, Resources.JUMP);
		place = new Button(Info.SCREEN_WIDTH - Resources.JUMP.getWidth()*2, Info.SCREEN_HEIGHT - Resources.JUMP.getHeight()/2, Resources.scale( Resources.JUMP, 1, -1), Resources.scale(Resources.JUMP, 1, -1));
		
		if(Settings.TILEPLACER_MODE)
			initPlaceUi();
		else
			initUi();
		
		fps = new FPSCounter();
		
		this.x = Info.SCREEN_WIDTH/2;
		this.y = Info.SCREEN_HEIGHT/2;
		
		w = new World(this);
		
		paint.setTextSize(Info.GUI_ZOOM * 4);
		paint.setAntiAlias(true);
	//	t = new TilePlacer(new Vec2(5, 5));
	//	w.addEntity(t);
		pl = new Player(Resources.BLOCK_BASIC, new Vec2(0, 5));
		w.addEntity(pl);
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
		
		pause.draw(c);
		left.draw(c);
		right.draw(c);
		jump.draw(c);
		ahead.draw(c);
		back.draw(c);
		place.draw(c);
		if(Settings.DEBUG)
		{
			fps.drawFPS(c);
			c.drawText(debug + pl.getVelocityY(), 180, 180, paint);
		}
	}
	
	public void initPlaceUi()
	{
		pause.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(game.mainScreen);
			}
		});
		
		left.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
			
			}
		});
		
		right.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				
			}
		});
		
		ahead.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				
			}
		});
		
		back.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				
			}
		});
		
		jump.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				//t.up();
				w.placeBlock((int)t.getPosition().x, (int)t.getPosition().y, 1);
				
					
			}
		});
		
		place.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				w.placeBlock((int)t.getPosition().x, (int)t.getPosition().y, 0);
			}
		});
	}
	
	public void initUi()
	{
			pause.setClickEvent(new Button.OnClickEvent()
			{
				public void onClick()
				{
					game.setScreen(game.mainScreen);
				}
			});

			left.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					
				}

				public void onTouchUp()
				{

				}
			});

			right.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					
				}

				public void onTouchUp()
				{

				}
			});

			ahead.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					
				}

				public void onTouchUp()
				{

				}
			});

			back.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					
				}

				public void onTouchUp()
				{

				}
			});

			jump.setClickEvent(new Button.OnClickEvent()
			{
				public void onClick()
				{
					debug = "Jump";
					pl.setVelocity(new Vec2(0, -0.1f));
					
					//Oops, I can't use the Toast
					/*try
					 {
					 Toast.makeText(game.context, "Jump", Toast.LENGTH_SHORT).show();
					 }catch(Exception e)
					 {

					 }*/
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
