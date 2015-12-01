package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;
import android.os.*;

public class DebugScreen extends Screen
{
	Label l;
	static int fps;
	public DebugScreen(GameView g)
	{
		super(g);
		l = new Label(g, "Debug");
		l.setBackButtonTo(game.settingScreen);
	}

	@Override
	public void draw(Canvas c)
	{
		super.draw(c);
		if(Settings.DEBUG)
		{
			c.drawLine(Input.TOUCH_X, 0,  Input.TOUCH_X, Info.SCREEN_HEIGHT, paint);
			c.drawLine(0, Input.TOUCH_Y, Info.SCREEN_WIDTH, Input.TOUCH_Y, paint);
		}
		l.draw(c);
		
		c.drawText("Android版本:" + android.os.Build.VERSION.RELEASE, 0, l.height + 32, paint);
		c.drawText("机型:" + android.os.Build.MODEL, 0, l.height + 65, paint);
		c.drawText("SD卡路径:" + Environment.getExternalStorageDirectory().getAbsolutePath(), 0, l.height + 98, paint);
		c.drawText("屏幕长度:" + Info.SCREEN_WIDTH + " 屏幕宽度:" + Info.SCREEN_HEIGHT + " UI缩放：" + Info.GUI_ZOOM, 0, l.height + 131, paint);
		c.drawText("触摸点 x:" + Input.TOUCH_X + " y:" + Input.TOUCH_Y, 0, l.height + 164, paint);
		
		
	}
}
