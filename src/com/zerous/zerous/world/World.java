package com.zerous.zerous.world;

import com.zerous.zerous.*;
import android.graphics.*;

public class World extends GameObject
{
	public GameView game;
	public int terrain[][][] = new int[10][10][10];
	public float x, y;
	public World(Screen scr)
	{
		game = scr.game;
	}

	@Override
	public void draw(Canvas c)
	{
		terrain[0][0][0] = 1;
		terrain[0][1][0] = 1;
		terrain[1][0][0] = 1;
		terrain[0][0][1] = 1;
		for(int y =0;y < 5;y++)
		{
			drawXZ(c, y);
		}
	}
	
	public void drawXZ(Canvas c, int y)
	{
		for(int x = 0;x < terrain.length;x++)
		{
			for(int z = 0;z < terrain[0][0].length;z++)
			{
				if(terrain[x][y][z] == 1)
					c.drawBitmap(Resources.Blocks.GRASS, this.x + x*Info.TILE_WIDTH, this.y + z*Info.TILE_HEIGHT/2 - y*Info.TILE_HEIGHT/2, null);
			}
		}
	}
}
