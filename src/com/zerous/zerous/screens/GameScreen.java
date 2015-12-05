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
	//Entity e;
	TilePlacer t;
	
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
		jump = new Button(Info.SCREEN_WIDTH - Resources.JUMP.getWidth(), Info.SCREEN_HEIGHT - Resources.JUMP.getHeight(), Resources.JUMP, Resources.JUMP);
		place = new Button(Info.SCREEN_WIDTH - Resources.JUMP.getWidth()*2, Info.SCREEN_HEIGHT - Resources.JUMP.getHeight(), Resources.scale( Resources.JUMP, 1, -1), Resources.scale(Resources.JUMP, 1, -1));
		
		initPlaceUi();
		//initUi();
		
		fps = new FPSCounter();
		
		this.x = Info.SCREEN_WIDTH/2;
		this.y = Info.SCREEN_HEIGHT/2;
		
		w = new World(this);
		
		paint.setTextSize(Info.GUI_ZOOM * 4);
		paint.setAntiAlias(true);
		//e = new Entity(Resources.I, new Vec3(Info.SCREEN_WIDTH/2, Info.SCREEN_HEIGHT/2, 0));
		t = new TilePlacer(new Vec2(5, 5));
		w.addEntity(t);
		//w.setTilePlacer(t);
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
		
		//ab = w.getBlock((int)((Input.TOUCH_X - w.x)/Resources.Blocks.blockList[0].getWidth()), (int)((Input.TOUCH_Y - w.y)/Resources.Blocks.blockList[0].getWidth())) != 0;
		
		super.draw(c);
		//c.drawBitmap(Resources.LOGO, Info.SCREEN_WIDTH/2 - Resources.LOGO.getWidth()/2, Info.SCREEN_HEIGHT - Info.SCREEN_HEIGHT/4, null);
		w.draw(c);
		
		/*if(Input.TOUCH_STATE != Input.TOUCH_STATE_UP)
		{
			if(!left.isTouched)
			{
				w.placeBlock((int)((Input.TOUCH_X - w.x)/Resources.Blocks.blockList[0].getWidth()), (int)((Input.TOUCH_Y - w.y)/Resources.Blocks.blockList[0].getHeight()), 2);
			}
			//else w.placeBlock((int)((Input.TOUCH_X - w.x)/Resources.Blocks.blockList[0].getWidth()), (int)((Input.TOUCH_Y - w.y)/Resources.Blocks.blockList[0].getHeight()), 0);
		//}*/
		
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
			c.drawText(debug + Input.count, 180, 180, paint);
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
				t.left();
				
			}
		});
		
		right.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				t.right();
			}
		});
		
		ahead.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				t.up();
			}
		});
		
		back.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				t.down();
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
					//e.getPosition().x -=5;
					w.x+=5;
					//t.left();
				}

				public void onTouchUp()
				{

				}
			});

			right.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					//e.getPosition().x+=5;
					w.x-=5;
					//t.right();
				}

				public void onTouchUp()
				{

				}
			});

			ahead.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					//e.getPosition().z -= 5;
					w.y+=5;
					//t.forward();
				}

				public void onTouchUp()
				{

				}
			});

			back.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					//e.getPosition().z += 5;
					w.y-=5;
					//t.back();
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
					//e.getPosition().y -= 10;
					//Utils.makeToast(debug);
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
