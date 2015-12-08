package com.zerous.zerous.world;

import com.zerous.zerous.*;
import android.graphics.*;
import java.util.*;
import com.zerous.zerous.entity.*;

public class World extends GameObject
{
	public GameView game;
	public int terrain[][] = new int[64][10];
	public float x, y;
	ArrayList<Entity> entities = new ArrayList<Entity>();
	
	boolean first = true;
	
	public World(Screen scr)
	{
		game = scr.game;
	}
	
	public void addEntity(Entity e)
	{
		//e.setPosition(this.x + e.getPosition().x * Info.TILE_WIDTH, e.getPosition().y * Info.TILE_HEIGHT/2, this.y + e.getPosition().z * Info.TILE_HEIGHT/2);
		e.set(Info.TILE_WIDTH, Info.TILE_HEIGHT);
		entities.add(e);
	}
	
	public void placeBlock(int x, int y, int id)
	{
		if(x >= 0&&y >= 0&&x < terrain.length&& y < terrain[0].length)
			terrain[x][y] = id;
		else
			return;
	}
	
	public int getBlock(int x, int y)
	{
		if(x >= 0&&y >= 0&&x < terrain.length&& y < terrain[0].length)
			return terrain[x][y];
		else
			return -1;
	}

	@Override
	public void draw(Canvas c)
	{
		drawTerrain(c);
		
		
		for(Entity e:entities)
		{
			e.draw(c);
		}
	}
	
	public void drawTerrain(Canvas c)
	{
		for(int x = 0;x < terrain.length;x++)
		{
			for(int y = 0;y < terrain[0].length;y++)
			{			
				if(terrain[x][y] == 1)
					c.drawBitmap(Resources.Blocks.blockList[Resources.ID.GRASS], this.x + x*Info.TILE_WIDTH, this.y + y*Info.TILE_HEIGHT, null);
				else if(terrain[x][y] == 2)
					c.drawBitmap(Resources.Blocks.blockList[Resources.ID.DIRT], this.x + x*Info.TILE_WIDTH, this.y + y*Info.TILE_HEIGHT, null);
				else if(terrain[x][y] == 3)
					c.drawBitmap(Resources.Blocks.blockList[Resources.ID.BRICK], this.x + x * Info.TILE_WIDTH, this.y+ y*Info.TILE_HEIGHT, null);
				if(y >= 4)
					first = false;
			}
		}
		
	}
}
