package com.zerous.zerous.entity;

import android.graphics.*;
import com.zerous.zerous.math.*;
import com.zerous.zerous.*;

public class TilePlacer extends Entity
{
	public TilePlacer(Vec2 pos)
	{
		super(pos);
		body = Resources.TILE_PLACER;
		velocity = new Vec2(1, 1);
	}
	
}
