package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;
import android.os.*;
import org.apache.http.params.*;

public class DebugScreen extends Screen
{
	String[] strings = {};
	
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
			c.drawLine(Core.input.getTouchX(0), 0,  Core.input.getTouchX(0), Info.SCREEN_HEIGHT, paint);
			c.drawLine(0, Core.input.getTouchY(0), Info.SCREEN_WIDTH, Core.input.getTouchY(0), paint);
		}
		l.draw(c);
		
		c.drawText("Android版本:" + android.os.Build.VERSION.RELEASE, 0, l.height + 32, paint);
		c.drawText("机型:" + android.os.Build.MODEL, 0, l.height + 65, paint);
		c.drawText("SD卡路径:" + Environment.getExternalStorageDirectory().getAbsolutePath(), 0, l.height + 98, paint);
		c.drawText("屏幕长度:" + Info.SCREEN_WIDTH + " 屏幕宽度:" + Info.SCREEN_HEIGHT + " UI缩放：" + Info.GUI_ZOOM, 0, l.height + 131, paint);
		c.drawText("触摸点 x:" + Core.input.getTouchX(0) + " 2:" + Core.input.getTouchX(1) + " y:" + Core.input.getTouchY(0) + " 2:" + Core.input.getTouchY(1), 0, l.height + 164, paint);
		c.drawText("游戏路径:" + Info.GAME_PATH, 0, l.height + 197, paint);
		c.drawText("Test:" + Core.input.getTouchX(0)/Resources.Blocks.blockList[0].getWidth(), 0, l.height + 230, paint);
		
	}
}
