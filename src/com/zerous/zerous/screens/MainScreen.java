package com.zerous.zerous.screens;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.ui.*;

public class MainScreen extends Screen
{
	Button toGame, toSettings;
	Button play;
	public MainScreen(GameView g)
	{
		super(g);
		
		toGame = new Button(Info.SCREEN_WIDTH/2, Info.SCREEN_HEIGHT/2, Resources.START_BUTTON_UP, Resources.START_BUTTON_DOWN);
		toSettings = new Button(Info.SCREEN_WIDTH - Resources.SETTINGS_BUTTON_UP.getWidth()/2, Info.SCREEN_HEIGHT - Resources.SETTINGS_BUTTON_UP.getHeight()/2, Resources.SETTINGS_BUTTON_UP, Resources.SETTINGS_BUTTON_DOWN);
		
		play = new Button(240, 60, 240, 120);
		play.setText("一个为了不无聊而准备的按钮");
		
		play.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(game.playScreen);
			}
		});
		
		toSettings.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(game.settingScreen);
			}
		});
		
		toGame.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(game.gameScreen);
			}
		});
	}

	@Override
	public void draw(Canvas c)
	{
		c.drawColor(Color.WHITE);
		c.drawBitmap(Resources.BANNER, Info.SCREEN_WIDTH - Resources.BANNER.getWidth(), Info.SCREEN_HEIGHT - Resources.BANNER.getHeight(), null);
		
		c.drawText("→", 80, 60, paint);
		play.draw(c);
		toGame.draw(c);
		toSettings.draw(c);
	}
}
