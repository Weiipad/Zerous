package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;

public class SettingScreen extends Screen
{
	Label title;
	CheckBox debug, quickStart;
	Button toDebug;
	public SettingScreen(GameView g)
	{
		super(g);
		title = new Label(g, "设置");
		title.setBackButtonTo(game.mainScreen);
		
		debug = new CheckBox(500, 500, "debug模式");
		quickStart = new CheckBox(300, 300, "快速启动");
		
		debug.setState(Settings.DEBUG);
		quickStart.setState(Settings.QUICK_START);
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
		debug.draw(c);
		quickStart.draw(c);
		toDebug.draw(c);
		Settings.DEBUG = debug.isChecked();
		Settings.QUICK_START = quickStart.isChecked();
	}
}
