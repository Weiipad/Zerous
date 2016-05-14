package com.zerous.zerous.utils;

import android.graphics.*;
import java.util.*;

public class Pack<T>
{
	List<T> pack;
	public Pack(T... items)
	{
		pack = new ArrayList<T>();
		for(T b : items)
		{
			pack.add(b);
		}
	}
}
