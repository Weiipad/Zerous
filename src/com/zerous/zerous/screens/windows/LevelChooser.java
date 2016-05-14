package com.zerous.zerous.screens.windows;

import com.zerous.zerous.ui.*;
import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.screens.*;

public class LevelChooser extends Window
{
	GameView game;
	Button toGame, back;
	public LevelChooser(GameView g)
	{
		super();
		game = g;
		toGame = new Button(Info.SCREEN_WIDTH/2, bottom - Resources.START_BUTTON.getHeight()/2, Resources.START_BUTTON.getWidth(), Resources.SETTINGS_BUTTON_UP.getHeight());
		toGame.setText("开始");
		toGame.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(new Test2Screen(game, game.mainScreen));
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
