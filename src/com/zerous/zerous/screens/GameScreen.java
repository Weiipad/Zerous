package com.zerous.zerous.screens;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.entity.*;
import com.zerous.zerous.math.*;
import com.zerous.zerous.ui.*;
import com.zerous.zerous.utils.*;
import com.zerous.zerous.world.*;
import com.zerous.zerous.entity.Entity.*;

public class GameScreen extends Screen
{
	Button pause, left, right, jump, place;
	CheckBox tilePlaceMode;
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
		left = new Button(Resources.LEFT_UP.getWidth(), Info.SCREEN_HEIGHT - Resources.LEFT_UP.getHeight(), Resources.LEFT_UP, Resources.LEFT_UP);
		right = new Button(Resources.RIGHT_UP.getWidth()*3, Info.SCREEN_HEIGHT - Resources.RIGHT_UP.getHeight(), Resources.RIGHT_UP, Resources.RIGHT_UP);
		jump = new Button(Info.SCREEN_WIDTH - Resources.JUMP.getWidth()/2, Info.SCREEN_HEIGHT - Resources.JUMP.getHeight()/2, Resources.JUMP, Resources.JUMP);
		place = new Button(Info.SCREEN_WIDTH - Resources.JUMP.getWidth()*2, Info.SCREEN_HEIGHT - Resources.JUMP.getHeight()/2, Resources.scale( Resources.JUMP, 1, -1), Resources.scale(Resources.JUMP, 1, -1));
		
		tilePlaceMode = new CheckBox(50 * Info.GUI_ZOOM, 50, "方块放置模式(测试)");
		tilePlaceMode.setState(Settings.TILEPLACER_MODE);
		
		
		initUi();
		
		fps = new FPSCounter();
		
		this.x = Info.SCREEN_WIDTH/2;
		this.y = Info.SCREEN_HEIGHT/2;
		
		w = new World(this);
		
		paint.setTextSize(Info.GUI_ZOOM * 4);
		paint.setAntiAlias(true);
		pl = new Player(Resources.BLOCK_BASIC, new Vec2(0, 5));
		w.addEntity(pl);
	}
	
	public void draw(Canvas c)
	{
		
		switch(OldInput.TOUCH_STATE)
		{
			case OldInput.TOUCH_STATE_DOWN:
				debug = "TOUCH_DOWN";
				break;
			case OldInput.TOUCH_STATE_MOVE:
				debug = "TOUCH_MOVE";
				break;
			case OldInput.TOUCH_STATE_UP:
				debug = "TOUCH_UP";
				break;
		}
		super.draw(c);
		w.draw(c);
		
		pause.draw(c);
		left.draw(c);
		right.draw(c);
		jump.draw(c);
		//ahead.draw(c);
		//back.draw(c);
		place.draw(c);
		
		tilePlaceMode.draw(c);
		Settings.TILEPLACER_MODE = tilePlaceMode.isChecked();
		
		if(Settings.DEBUG)
		{
			fps.drawFPS(c);
			c.drawText(debug + pl.getVelocityY() + pl.getVelocityX(), 180, 180, paint);
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
		
		jump.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				//t.up();
				//w.placeBlock((int)t.getPosition().x, (int)t.getPosition().y, 1);
				
					
			}
		});
		
		place.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				//if(Settings.TILEPLACER_MODE)
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
					pl.velocity.x = -0.1f;
					pl.state = Entity.State.Left;
				}

				public void onTouchUp()
				{
					pl.velocity.x = 0;
					//pl.state = Entity.State.Idle;
				}
			});

			right.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					pl.velocity.x = 0.1f;
					pl.state = Entity.State.Right;
				}

				public void onTouchUp()
				{
					//pl.velocity.x = 0;
				}
			});
			
			jump.setTouchEvent(new Button.OnTouchEvent()
			{
				public void onTouchDown()
				{
					pl.jump();
				}
				
				public void onTouchUp()
				{
					
				}
			});
			
			
			place.setClickEvent(new Button.OnClickEvent()
			{
				public void onClick()
				{
					if(Settings.TILEPLACER_MODE)
					{
						if(w.getBlock((int)pl.getPosition().x + pl.tp, (int)pl.getPosition().y) != 0)
						{
							w.placeBlock((int)pl.getPosition().x + pl.tp, (int)pl.getPosition().y, 0);
						}
						else
						{
							w.placeBlock((int)pl.getPosition().x + pl.tp, (int)pl.getPosition().y, 1);
						}
					}
				}
			});
	}
}
