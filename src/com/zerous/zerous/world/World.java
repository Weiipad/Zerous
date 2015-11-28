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
		//c.drawBitmap(Resources.Blocks.blocks[0], 70, 70, null);
		
		
		for(int y =0;y <= 5;y++)
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
				if(y <= 4){
				terrain[x][0][0] = 1;
				terrain[0][0][z] = 1;
				terrain[0][y][0] = 2;
				}
				else
				{
					terrain[0][y][0] = 1;
				}
				
				
				
				/*switch(terrain[x][y][z])
				{
					case 1:
						c.drawBitmap(Resources.Blocks.blocks[0], this.x + x*Info.TILE_WIDTH, this.y + z*Info.TILE_HEIGHT/2 - y*Info.TILE_HEIGHT/2, null);
						break;
					case 2:
						//c.drawBitmap(Resources, this.x + x*Info.TILE_WIDTH, this.y + z*Info.TILE_HEIGHT/2 - y*Info.TILE_HEIGHT/2, null);
				*/
				if(terrain[x][y][z] == 1)
					c.drawBitmap(Resources.Blocks.blocks[0], this.x + x*Info.TILE_WIDTH, this.y + z*Info.TILE_HEIGHT/2 - y*Info.TILE_HEIGHT/2, null);
				else if(terrain[x][y][z] == 2)
					c.drawBitmap(Resources.Blocks.blocks[1], this.x + x*Info.TILE_WIDTH, this.y + z*Info.TILE_HEIGHT/2 - y*Info.TILE_HEIGHT/2, null);
			}
		}
		
	}
}
