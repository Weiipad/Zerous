package com.zerous.zerous.ui;

import com.zerous.zerous.*;
import android.graphics.*;

public abstract class Window extends Ui
{
	Paint paint;
	protected Paint tpaint;
	boolean show;
	protected float left, top, right, bottom;
	public Window()
	{
		left = 2*Info.GUI_ZOOM*2;
		top = 2*Info.GUI_ZOOM*2;
		right = Info.SCREEN_WIDTH - 2*Info.GUI_ZOOM*2;
		bottom = Info.SCREEN_HEIGHT - 2*Info.GUI_ZOOM*2;
		
		paint = new Paint();
		tpaint = new Paint();
		tpaint.setTextSize(32);
		paint.setColor(0xFFAFAFAF);
		paint.setAntiAlias(true);
		
	}
	
	public void show()
	{
		show = true;
	}
	
	public void hide()
	{
		show = false;
	}
	
	protected abstract void drawUI(Canvas c);

	@Override
	public void draw(Canvas c)
	{
		if(show)
		{
			paint.setColor(0xFFAFAFAF);
			c.drawRect(2*Info.GUI_ZOOM, 2*Info.GUI_ZOOM, Info.SCREEN_WIDTH - 2*Info.GUI_ZOOM, Info.SCREEN_HEIGHT - 2*Info.GUI_ZOOM, paint);
			paint.setColor(0xFFCFCFCF);
			c.drawRect(3*Info.GUI_ZOOM, 3*Info.GUI_ZOOM, Info.SCREEN_WIDTH - 3*Info.GUI_ZOOM, Info.SCREEN_HEIGHT - 3*Info.GUI_ZOOM, paint);
			drawUI(c);
		}
	}
}
