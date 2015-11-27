package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;
import android.os.*;

public class PlayScreen extends Screen
{
	Button btn;
	Label l;
	SeekBar s;
	static int a = 0;
	static int speed = 0;
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
				a+=speed;
				speed+=1;
			}
		});
		/*btn.setTouchEvent(new Button.OnTouchEvent()
		{
			public void onTouchDown()
			{
				a+=speed;
				speed+=1;
			}
			
			public void onTouchUp()
			{
				
			}
		});*/
		
		s = new SeekBar(Info.SCREEN_WIDTH/2, Info.SCREEN_HEIGHT/4, 100*Info.GUI_ZOOM);
		paint.setTextSize(4*Info.GUI_ZOOM);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
	}

	@Override
	public void draw(Canvas c)
	{
		c.drawColor(Color.WHITE + 0xffa0a0a0);
		c.drawText("你已经无聊到按了这按钮" + a + "下" + Info.GUI_ZOOM + Environment.getExternalStorageDirectory().getAbsolutePath(), Info.SCREEN_WIDTH/2, Info.SCREEN_HEIGHT/2, paint);
		l.draw(c);
		btn.draw(c);
		s.draw(c);
	}
}
