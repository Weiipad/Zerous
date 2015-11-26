package com.zerous.zerous.world;

import com.zerous.zerous.*;
import android.graphics.*;

public class World extends GameObject
{
	public GameView game;
	public int terrain[][] = new int[10][10];
	public float x, y;
	public World(Screen scr)
	{
		game = scr.game;
	}

	@Override
	public void draw(Canvas c)
	{
		for(int x = 0;x < terrain.length;x++)
		{
			for(int y = 0;y < terrain[0].length;y++)
			{
				terrain[x][y] = 1;
					
				if(terrain[x][y] == 1)
				{
					c.drawBitmap(Resources.Blocks.BRICK, this.x +x * (Info.TILE_WIDTH - Info.PIXEL_SIZE), this.y + y * (Info.TILE_HEIGHT - Info.PIXEL_SIZE), null);
				}
			}
		}
	}
}
