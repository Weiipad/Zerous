package com.zerous.zerous.screens;

import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.ui.*;
import com.zerous.zerous.screens.windows.*;

//主屏
public class MainScreen extends Screen
{
	Button toGame, toSettings, toAbout;
	Button play;
	Window levelChooser;
	public MainScreen(GameView g)
	{
		super(g, null);
		
		levelChooser = new LevelChooser(g);
		
		toGame = new Button(Info.SCREEN_WIDTH/2, Info.SCREEN_HEIGHT/2, Resources.START_BUTTON);
		toSettings = new Button(Info.SCREEN_WIDTH - Resources.SETTINGS_BUTTON_UP.getWidth()*1.8f, Info.SCREEN_HEIGHT - Resources.SETTINGS_BUTTON_UP.getHeight()/2, Resources.SETTINGS_BUTTON_UP, Resources.SETTINGS_BUTTON_DOWN);
		toAbout = new Button(Info.SCREEN_WIDTH - Resources.ABOUT_BUTTON_UP.getWidth()/2, Info.SCREEN_HEIGHT - Resources.ABOUT_BUTTON_UP.getHeight()/2, Resources.ABOUT_BUTTON_UP, Resources.ABOUT_BUTTON_DOWN);
		
		play = new Button(Info.SCREEN_WIDTH - 32*Info.GUI_ZOOM, 16*Info.GUI_ZOOM, 32*Info.GUI_ZOOM, 16*Info.GUI_ZOOM);
		play.setText("一个为了不无聊而准备的按钮");
		
		
		play.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(new Test2Screen(game, game.mainScreen));
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
				levelChooser.show();
			}
		});
		
		toAbout.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(game.aboutScreen);
			}
		});
	}

	@Override
	public void draw(Canvas c)
	{
		super.draw(c);
		c.drawBitmap(Resources.BANNER, Info.SCREEN_WIDTH - Resources.BANNER.getWidth(), Info.SCREEN_HEIGHT - Resources.BANNER.getHeight(), null);
		c.drawBitmap(Resources.LOGO, Info.SCREEN_WIDTH/2 - Resources.LOGO.getWidth()/2, Info.SCREEN_HEIGHT/4 - Resources.LOGO.getHeight()/2, null);
		
		play.draw(c);
		toGame.draw(c);
		toSettings.draw(c);
		toAbout.draw(c);
		levelChooser.draw(c);
	}
}
