package com.zerous.zerous.input;

import android.view.View.*;
import com.zerous.zerous.utils.*;
import com.zerous.zerous.utils.Pool.*;
import com.zerous.zerous.input.Input.*;
import java.util.*;
import android.view.*;

public class KeyboardHandler implements OnKeyListener
{
	boolean[] pressedKeys = new boolean[128];
	Pool<KeyEvent> keyEventPool;
	List<KeyEvent> keyEventsBuffer = new ArrayList<KeyEvent>();
	List<KeyEvent> keyEvents = new ArrayList<KeyEvent>();
	
	public KeyboardHandler(View v)
	{
		PoolObjectFactory<KeyEvent> factory = new PoolObjectFactory<KeyEvent>()
		{
			@Override
			public KeyEvent createObject()
			{
				return new KeyEvent();
			}
		};
		
		keyEventPool = new Pool<KeyEvent>(factory, 100);
		v.setOnKeyListener(this);
		v.setFocusableInTouchMode(true);
		v.requestFocus();
	}

	@Override
	public boolean onKey(View v, int keyCode, android.view.KeyEvent event)
	{
		
		return false;
	}
}
