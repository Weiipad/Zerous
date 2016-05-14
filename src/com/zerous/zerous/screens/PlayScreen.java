package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;
import android.os.*;
import com.zerous.zerous.screens.windows.*;

public class PlayScreen extends Screen
{
	Button btn, b;
	Label l;
	SeekBar s;
	Window w;
	static int a = 0;
	static int speed = 0;
	public PlayScreen(GameView g, Screen p)
	{
		super(g, p);
		
		w = new PlayWindow();
		
		l = new Label(g, "一个为了不无聊而准备的界面");
		l.setBackButtonTo(game.mainScreen);
		
		btn = new Button(80, Info.SCREEN_HEIGHT / 2, Resources.PAUSE_BUTTON);
		btn.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				a++;
			}
		});
		
		
		Button.OnClickEvent bc = new Button.OnClickEvent()
		{
			public void onClick()
			{
				w.show();
			}
		};
		
		b = new Button(Info.SCREEN_WIDTH - Resources.PAUSE_BUTTON.getWidth()/2, Resources.PAUSE_BUTTON.getHeight()/2, Resources.PAUSE_BUTTON);
		b.setClickEvent(bc);
		
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
		super.draw(c);
		c.drawText("你已经无聊到按了这按钮" + a + "下" + Info.GUI_ZOOM + Environment.getExternalStorageDirectory().getAbsolutePath(), Info.SCREEN_WIDTH/2, Info.SCREEN_HEIGHT/2, paint);
		l.draw(c);
		btn.draw(c);
		b.draw(c);
		s.draw(c);
		w.draw(c);
	}
}
