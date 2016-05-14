package com.zerous.zerous.screens;

import com.zerous.zerous.*;
import android.graphics.*;
import android.view.inputmethod.*;
import android.content.*;
import com.zerous.zerous.ui.*;
import android.view.*;

public class MathTests extends Screen
{
	InputMethodManager im;
	Button b;
	public MathTests(GameView g, Screen parent)
	{
		super(g, parent);
		
		im = (InputMethodManager)game.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		b = new Button(500, 500, Resources.PAUSE_BUTTON);
		b.setClickEvent(new Button.OnClickEvent()
		{
			public void onClick()
			{
				im.showSoftInput(game, 0);
			}
		});
	}

	@Override
	public void draw(Canvas c)
	{
		super.draw(c);
		
		b.draw(c);
		
		
		c.drawText(Core.input.isKeyPressed(KeyEvent.KEYCODE_A) + "", 50, 50, paint);
		
		/*for(int x = -50;x < 50;x++)
		{
			float y = x * x;
			c.drawPoint(x + 500, -y, paint);
		}*/
	}
}
