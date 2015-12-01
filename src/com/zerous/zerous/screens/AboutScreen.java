package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;

public class AboutScreen extends Screen
{
	Label l;
	public AboutScreen(GameView g)
	{
		super(g);
		l = new Label(g, "关于");
		l.setBackButtonTo(game.mainScreen);
	}

	@Override
	public void draw(Canvas c)
	{
		super.draw(c);
		l.draw(c);
		c.drawText("制作by @weiipad", 0, l.height + 32, paint);
	}
}
