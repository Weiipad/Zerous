package com.zerous.zerous;

import android.graphics.*;

public class Screen
{
	public GameView game;
	protected Paint paint;
	protected int clearColor;
	public Screen(GameView game)
	{
		this.game = game;
		paint = new Paint();
		paint.setTextSize(32);
		paint.setColor(Color.BLACK);
		paint.setAntiAlias(true);
		
		clearColor = Color.WHITE;
	}
	
	protected void setClearColor(int r, int g, int b)
	{
		clearColor = Color.rgb(r, g, b);
	}
	
	protected void setClearColor(int color)
	{
		clearColor = color;
	}
	
	public void draw(Canvas c)
	{
		c.drawColor(clearColor);
	}
}
