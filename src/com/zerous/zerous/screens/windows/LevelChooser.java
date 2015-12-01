package com.zerous.zerous.screens.windows;

import com.zerous.zerous.ui.*;
import android.graphics.*;
import com.zerous.zerous.*;

public class LevelChooser extends Window
{
	GameView game;
	Button toGame, back;
	public LevelChooser(GameView g)
	{
		super();
		game = g;
		toGame = new Button(Info.SCREEN_WIDTH/2, bottom - Resources.START_BUTTON_UP.getHeight()/2, Resources.START_BUTTON_UP.getWidth(), Resources.SETTINGS_BUTTON_UP.getHeight());
		toGame.setText("开始");
		toGame.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(game.gameScreen);
				hide();
			}
		});
		
		back = new Button(left + Resources.BACK_BUTTON_UP.getWidth()/2, top + Resources.BACK_BUTTON_UP.getHeight()/2, Resources.BACK_BUTTON_UP, Resources.BACK_BUTTON_DOWN);
		back.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				hide();
			}
		});
	}

	@Override
	protected void drawUI(Canvas c)
	{
		back.draw(c);
		toGame.draw(c);
	}
}
