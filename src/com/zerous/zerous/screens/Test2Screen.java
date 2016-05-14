package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;
import java.util.*;
import com.zerous.zerous.entity.*;
import com.zerous.zerous.math.*;
import com.zerous.zerous.world.*;

public class Test2Screen extends Screen
{
	List<Ui> guis;
	Button pause, left, right, jump, down, attack;
	Entity e;
	World w;
	
	Bitmap r, l, a, b;
	
	int velocity = 1;
	int tick = 0;
	
	enum Direct
	{
		East, West, South, North
	}
	
	Direct direct;
	public Test2Screen(GameView game, Screen p)
	{
		super(game, p);
		guis = new ArrayList<Ui>();
		pause = new Button(Info.SCREEN_WIDTH - Resources.PAUSE_BUTTON.getWidth()/2, Resources.PAUSE_BUTTON.getHeight()/2, Resources.PAUSE_BUTTON);
		
		left = new Button(Resources.LEFT_UP.getWidth()/2, Info.SCREEN_HEIGHT - Resources.LEFT_UP.getHeight()*1.5f, Resources.LEFT_UP, Resources.LEFT_UP);
		right = new Button(Resources.RIGHT_UP.getWidth()*2.5f, Info.SCREEN_HEIGHT - Resources.RIGHT_UP.getHeight()*1.5f, Resources.RIGHT_UP, Resources.RIGHT_UP);
		jump = new Button(Resources.JUMP.getWidth()*1.5f, Info.SCREEN_HEIGHT - Resources.JUMP.getHeight()*2.5f, Resources.AHEAD);
		down = new Button(Resources.JUMP.getWidth()*1.5f, Info.SCREEN_HEIGHT - Resources.JUMP.getHeight()/2, Resources.BACK);
		attack = new Button(Info.SCREEN_WIDTH - Resources.ATTACK.getWidth(), Info.SCREEN_HEIGHT - Resources.ATTACK.getHeight(), Resources.ATTACK);
		
		setButtons();
		
		r = Resources.BLOCK_BASIC;
		l = Resources.scale(r, -1, 1);
		a = Resources.rotate(r, -90);
		b = Resources.scale(a, 1, -1);

		e = new Entity(Resources.BLOCK_BASIC, new Vec2(8, 5));
		w = new World(this);
		w.addPlayer(e);
		
		
		/*for(int x = 10;x < 10;x++)
		{
			for(int y = 10;y < 10;y++)
			{
				int id = Resources.ID.DIRT;
			
					//id = Resources.ID.GRASS;
				
				w.placeBlock(x, y, id);
			}
		}*/
		
		for(int x = 5;x < 20;x++)
			w.placeBlock(x, 7, Resources.ID.DIRT);
		
		//w.placeBlock(8, 5, 0);
		
		guis.add(pause);
		guis.add(left);
		guis.add(right);
		guis.add(jump);
		guis.add(down);
		guis.add(attack);
		
		setClearColor(Color.rgb(0x00, 0xba, 0xff));
	}

	void setButtons()
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
				//if(direct == Direct.East)e.body = Resources.scale(e.body, -1, 1);
				direct = Direct.West;
				e.body = l;
				if(!w.hasBlock((int)e.position.x - 1, (int)e.position.y))
				{
					e.position.x -= velocity;
					w.x += velocity * Info.TILE_WIDTH;
				}
			}
		});

		right.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				direct = Direct.East;
				e.body = r;
				if(!w.hasBlock((int)e.position.x + 1, (int)e.position.y))
				{
					e.position.x += velocity;
					w.x -= velocity * Info.TILE_WIDTH;
				}

			}
		});

		jump.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				direct = Direct.North;
				e.body = a;
				if(!w.hasBlock((int)e.position.x, (int)e.position.y - 1))
				{
					
					e.position.y -= velocity;
					w.y += velocity * Info.TILE_WIDTH;
				}
			}
		});
		
		down.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				direct = Direct.South;
				e.body = b;
				if(!w.hasBlock((int)e.position.x, (int)e.position.y + 1))
				{
					
					e.position.y += velocity;
					w.y -= velocity * Info.TILE_WIDTH;
				}
			}
		});
		
		attack.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				//Bullet b = new Bullet(Resources.A_PIXEL, e.position.cpy(), w);
				//w.addEntity(b);
				switch(direct)
				{
					case West:
					{
						w.placeBlock((int)e.position.x - 1, (int)e.position.y, 0);
						//b.shoot(new Vec2(-1, 0));
						break;
					}
					
					case East:
					{
						w.placeBlock((int)e.position.x + 1, (int)e.position.y, 0);
						//b.shoot(new Vec2(1, 0));
						break;
					}
					
					case North:
					{
						w.placeBlock((int)e.position.x, (int)e.position.y - 1, 0);
						//b.shoot(new Vec2(0, -1));
						break;
					}
					
					case South:
					{
						w.placeBlock((int)e.position.x, (int)e.position.y + 1, 0);
						//b.shoot(new Vec2(0, 1));
						break;
					}
				}
				
			}
		});
	}

	@Override
	public void draw(Canvas c)
	{
		super.draw(c);
		tick ++;
		
		/*if(tick % 1 == 0)
		{
			int x = (int)(Math.random() * 256);
			int y = (int)(Math.random() * 256);
			if(!w.hasBlock(x, y))
				w.placeBlock(x, y, Resources.ID.DIRT);
		}*/
		
		
		w.draw(c);
		
		for(Ui ui:guis)
		{
			ui.draw(c);
		}
	}
}
