package com.zerous.zerous;

import android.graphics.*;

public abstract class Screen
{
	public GameView game;
	protected Paint paint;
	public Screen(GameView game)
	{
		this.game = game;
		paint = new Paint();
		paint.setTextSize(32);
		paint.setColor(Color.BLACK);
	}
	
	public abstract void draw(Canvas c);
}
