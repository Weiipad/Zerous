package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;

public class SettingScreen extends Screen
{
	Label title;
	CheckBox debug, quickStart, tilePlaceMode;
	Button toDebug;
	public SettingScreen(GameView g)
	{
		super(g);
		title = new Label(g, "设置");
		title.setBackButtonTo(game.mainScreen);
		
		debug = new CheckBox(500, 500, "debug模式");
		quickStart = new CheckBox(500, 400, "快速启动");
		tilePlaceMode = new CheckBox(500, 300, "方块放置模式(测试)");
		
		debug.setState(Settings.DEBUG);
		quickStart.setState(Settings.QUICK_START);
		tilePlaceMode.setState(Settings.TILEPLACER_MODE);
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
		tilePlaceMode.draw(c);
		toDebug.draw(c);
		Settings.DEBUG = debug.isChecked();
		Settings.QUICK_START = quickStart.isChecked();
		Settings.TILEPLACER_MODE = tilePlaceMode.isChecked();
	}
}
