package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;

public class AboutScreen extends Screen
{
	Label l;
	int a = 0, b;
	Bitmap[] ani = new Bitmap[4];
	Bitmap self;
	Animation anim;
	public AboutScreen(GameView g)
	{
		super(g);
		l = new Label(g, "关于");
		l.setBackButtonTo(game.mainScreen);
		
		ani[0] = Resources.AHEAD;
		ani[1] = Resources.LEFT_UP;
		ani[2] = Resources.BACK;
		ani[3] = Resources.RIGHT_UP;
		anim = new Animation(ani, 10);
	}

	@Override
	public void draw(Canvas c)
	{
		super.draw(c);
		l.draw(c);
		c.drawText("制作by @weiipad", 0, l.height + 32, paint);
		/*b++;
		if(b%1 == 0)
		{
			if(a < ani.length - 1)
			{
				a++;
			}
			else
			{
				a = 0;
			}
		}*/
		self  = anim.getFrame();
		
		c.drawBitmap(self, 600, 600, null);
		c.drawText(ani.length+"", 600, 600, paint);
	}
}
