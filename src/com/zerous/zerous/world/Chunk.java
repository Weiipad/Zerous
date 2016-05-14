package com.zerous.zerous.world;

import com.zerous.zerous.math.*;
import android.graphics.*;
import com.zerous.zerous.*;

public class Chunk
{
	public int tiles[][] = new int[16][16];
	public Vec2 size = new Vec2(tiles.length, tiles[0].length);
	private Bitmap chunk;
	private Canvas drawer;
	
	public Chunk(World w, int x, int y)
	{
		chunk = Bitmap.createBitmap((int)(tiles.length * Info.TILE_WIDTH), (int)(tiles[0].length * Info.TILE_HEIGHT), Bitmap.Config.ARGB_4444);
		drawer = new Canvas(chunk);
		
		int[][] a = w.terrain;
	}
}
