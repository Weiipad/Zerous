package com.zerous.zerous.screens.windows;

import com.zerous.zerous.ui.*;
import android.graphics.*;
import com.zerous.zerous.*;

public class PlayWindow extends Window
{
	Button back;
	List l;
	public PlayWindow()
	{
		super();
		back = new Button(right - Resources.CLOSE_BUTTON_UP.getWidth()/2, top + Resources.CLOSE_BUTTON_UP.getHeight()/2, Resources.CLOSE_BUTTON_UP, Resources.CLOSE_BUTTON_DOWN);
		back.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				hide();
			}
		});
		
		l = new List();
		l.listY = top;
	}

	@Override
	protected void drawUI(Canvas c)
	{
		c.drawText("Hello", left, top + 32, tpaint);
		back.draw(c);
		l.draw(c);
	}
}
