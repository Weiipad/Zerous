package com.zerous.zerous.entity;

import android.graphics.*;
import com.zerous.zerous.math.*;
import com.zerous.zerous.*;

public class TilePlacer extends Entity
{
	public TilePlacer(Vec3 pos)
	{
		super(pos);
		body = Resources.I;
		velocity = new Vec3(1, 1, 1);
	}
	
}
