package com.zerous.zerous.world;

import com.zerous.zerous.*;
import android.graphics.*;
import java.util.*;
import com.zerous.zerous.entity.*;

public class World extends GameObject
{
	public GameView game;
	public int terrain[][][] = new int[10][10][10];
	public float x, y;
	ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public World(Screen scr)
	{
		game = scr.game;
	}
	
	public void addEntity(Entity e)
	{
		entities.add(e);
		
	}

	@Override
	public void draw(Canvas c)
	{	
		for(int y =0;y <= 5;y++)
		{
			drawXZ(c, y);
		}
		
		for(Entity e:entities)
		{
			e.draw(c);
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
				
				if(terrain[x][y][z] == 1)
					c.drawBitmap(Resources.Blocks.blockList[Resources.ID.GRASS], this.x + x*Info.TILE_WIDTH, this.y + z*Info.TILE_HEIGHT/2 - y*Info.TILE_HEIGHT/2, null);
				else if(terrain[x][y][z] == 2)
					c.drawBitmap(Resources.Blocks.blockList[Resources.ID.DIRT], this.x + x*Info.TILE_WIDTH, this.y + z*Info.TILE_HEIGHT/2 - y*Info.TILE_HEIGHT/2, null);
			}
		}
		
	}
}
