package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;

public class SettingScreen extends Screen
{
	Label title;
	CheckBox ch;
	public SettingScreen(GameView g)
	{
		super(g);
		title = new Label("设置");
		title.setBackButtonClickEvent(
		new Button.OnClickEvent()
		{
			public void onClick() { game.setScreen(game.mainScreen); }
		});
		
		ch = new CheckBox(500, 500, "debug模式");
	}

	@Override
	public void draw(Canvas c)
	{
		c.drawColor(Color.WHITE);
		title.draw(c);
		ch.draw(c);
		Settings.DEBUG = ch.isChecked();
	}
}
