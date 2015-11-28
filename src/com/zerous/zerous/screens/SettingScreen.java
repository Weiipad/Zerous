package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;

public class SettingScreen extends Screen
{
	Label title;
	CheckBox ch;
	Button toDebug;
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
		toDebug = new Button(600, 600, 32*Info.GUI_ZOOM, 16*Info.GUI_ZOOM);
		toDebug.setText("Debug");
		toDebug.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(game.debugScreen);
			}
		});
	}

	@Override
	public void draw(Canvas c)
	{
		super.draw(c);
		title.draw(c);
		ch.draw(c);
		toDebug.draw(c);
		Settings.DEBUG = ch.isChecked();
	}
}
