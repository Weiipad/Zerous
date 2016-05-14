package com.zerous.zerous;

import android.graphics.*;
import java.util.*;

public abstract class Screen
{
	public GameView game;
	public Screen parent;
	protected Paint paint;
	protected int clearColor;
	
	private List<GameObject> children;
	public Screen(GameView game, Screen parentScreen)
	{
		this.game = game;
		parent = parentScreen;
		paint = new Paint();
		paint.setTextSize(32);
		paint.setColor(Color.BLACK);
		paint.setAntiAlias(true);
		children = new ArrayList<GameObject>();
		
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
		for(GameObject obj : children)
		{
			obj.update(c);
		}
		
		c.drawColor(clearColor);
	}
	
	public void drawChildren(Canvas c)
	{
		for(GameObject obj : children)
		{
			obj.draw(c);
		}
	}
}
