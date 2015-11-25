package com.zerous.zerous.world;

import com.zerous.zerous.*;
import android.graphics.*;

public class World extends GameObject
{
	public GameView game;
	public int terrain[][][] = new int[10][10][10];
	public World(Screen scr)
	{
		game = scr.game;
	}

	@Override
	public void draw(Canvas c)
	{
		for(int x = 0;x < terrain.length;x++)
		{
			for(int z = 0;z < terrain[0][0].length;z++)
			{
				for(int y = 0;y < terrain[0].length;y++)
				{
					terrain[x][0][z] = 1;
					
					if(terrain[x][y][z] == 1)
					{
						c.drawBitmap(Resources.BLOCK_BASIC, x*Resources.BLOCK_BASIC.getWidth()-Resources.A_PIXEL.getWidth(), z*Resources.BLOCK_BASIC.getHeight(), null);
					}
				}
			}
		}
	}
}
