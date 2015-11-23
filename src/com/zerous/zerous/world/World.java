package com.zerous.zerous.world;

import com.zerous.zerous.*;
import android.graphics.*;

public class World extends GameObject
{
	public GameView game;
	public World(Screen scr)
	{
		game = scr.game;
	}

	@Override
	public void draw(Canvas c)
	{
		//c.drawBitmap();
	}
}
