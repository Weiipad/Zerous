package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;

public class PlayScreen extends Screen
{
	Button btn;
	Label l;
	static int a = 0;
	public PlayScreen(GameView g)
	{
		super(g);
		
		l = new Label("一个为了不无聊而准备的界面");
		l.setBackButtonClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				game.setScreen(game.mainScreen);
			}
		});
		
		btn = new Button(80, Info.SCREEN_HEIGHT / 2, Resources.PAUSE_BUTTON_UP, Resources.PAUSE_BUTTON_DOWN);
		btn.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				a+=1;
			}
		});
		paint.setTextSize(32);
		paint.setAntiAlias(true);
	}

	@Override
	public void draw(Canvas c)
	{
		c.drawColor(Color.WHITE + 0xffa0a0a0);
		c.drawText("你已经无聊到按了这按钮" + a + "下", Info.SCREEN_WIDTH/2, Info.SCREEN_HEIGHT/2, paint);
		l.draw(c);
		btn.draw(c);
	}
}
