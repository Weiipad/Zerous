package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;
import java.util.*;
import com.zerous.zerous.entity.*;
import com.zerous.zerous.math.*;

public class TestScreen extends Screen
{
	List<Ui> guis;
	Button pause, left, right, jump;
	Entity e;
	public TestScreen(GameView game, Screen p)
	{
		super(game, p);
		guis = new ArrayList<Ui>();
		pause = new Button(Info.SCREEN_WIDTH - Resources.PAUSE_BUTTON.getWidth()/2, Resources.PAUSE_BUTTON.getHeight()/2, Resources.PAUSE_BUTTON);
		left = new Button(Resources.LEFT_UP.getWidth(), Info.SCREEN_HEIGHT - Resources.LEFT_UP.getHeight(), Resources.LEFT_UP, Resources.LEFT_UP);
		right = new Button(Resources.RIGHT_UP.getWidth()*3, Info.SCREEN_HEIGHT - Resources.RIGHT_UP.getHeight(), Resources.RIGHT_UP, Resources.RIGHT_UP);
		jump = new Button(Info.SCREEN_WIDTH - Resources.JUMP.getWidth()/2, Info.SCREEN_HEIGHT - Resources.JUMP.getHeight()/2, Resources.JUMP);
		setButtons();
		
		e = new Entity(Resources.TILE_PLACER, new Vec2(70, 70));
		
		guis.add(pause);
		guis.add(left);
		guis.add(right);
		guis.add(jump);
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
		
		left.setTouchEvent(new Button.OnTouchEvent()
		{
			public void onTouchDown()
			{
				e.velocity.x -= 2;
			}
			
			public void onTouchUp()
			{
				//e.setVelocity(new Vec2(0, 0));
			}
		});
		
		right.setTouchEvent(new Button.OnTouchEvent()
		{
			public void onTouchDown()
			{
				//e.setVelocity(new Vec2(1, 0));
				e.velocity.x += 2;
			}

			public void onTouchUp()
			{
				//e.setVelocity(new Vec2(0, 0));
			}
		});
		
		jump.setTouchEvent(new Button.OnTouchEvent()
		{
			public void onTouchDown()
			{
				e.velocity.y -= 2;
			}
			
			public void onTouchUp()
			{
				
			}
		});
	}

	@Override
	public void draw(Canvas c)
	{
		super.draw(c);
		if(e.getPosition().y < 1000)
		{
			e.velocity.y += 0.2;
		}
		else
		{
			e.position.y = 998;
			e.velocity.y = 0;
		}
		
			
		if(e.getPosition().y < 0)
		{
			e.position.y = 0;
			e.velocity.y = -0.9f * e.velocity.y;
		}
		
		if(e.getPosition().x < 0)
		{
			e.position.x = 0;
			e.velocity.x = -e.velocity.x;
		}
		
		if(e.getPosition().x > 1800)
		{
			e.position.x = 1800;
			e.velocity.x = -e.velocity.x;
		}
		
		/*if(e.velocity.y >= -1 && e.velocity.y <= 1 && e.velocity.y != 0)
		{
			e.velocity.y = 0;
		}*/
		
		e.draw(c);
		for(Ui ui: guis)
		{
			ui.draw(c);
		}
		
		c.drawPoint(e.getPosition().x, e.getPosition().y, paint);
		c.drawText(e.velocity +"", 20, 100, paint);
	}
}
