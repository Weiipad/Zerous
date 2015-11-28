package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import com.zerous.zerous.ui.*;
import android.os.*;

public class DebugScreen extends Screen
{
	Label l;
	public DebugScreen(GameView g)
	{
		super(g);
		l = new Label("Debug");
		l.setBackButtonClickEvent(new Button.OnClickEvent(){public void onClick(){game.setScreen(game.settingScreen);}});
		
	}

	@Override
	public void draw(Canvas c)
	{
		super.draw(c);
		l.draw(c);
		
		c.drawText("Android版本:" + android.os.Build.VERSION.RELEASE, 0, l.height + 32, paint);
		c.drawText("机型:" + android.os.Build.MODEL, 0, l.height + 65, paint);
		c.drawText("SD卡路径:" + Environment.getExternalStorageDirectory().getAbsolutePath(), 0, l.height + 98, paint);
		c.drawText("屏幕长度:" + Info.SCREEN_WIDTH + " 宽度:" + Info.SCREEN_HEIGHT + " UI缩放：" + Info.GUI_ZOOM, 0, l.height + 131, paint);
		
	}
}
