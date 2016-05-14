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
		if(event.getAction() == android.view.KeyEvent.ACTION_MULTIPLE)
			return false;
		
		synchronized(this)
		{
			KeyEvent keyEvent = keyEventPool.newObject();
			keyEvent.keyCode = keyCode;
			keyEvent.keyChar = (char)event.getUnicodeChar();
			if(event.getAction() == event.ACTION_DOWN)
			{
				keyEvent.type = KeyEvent.KEY_DOWN;
				if(keyCode > 0 && keyCode < 127)
				{
					pressedKeys[keyCode] = true;
				}
			}
			
			if(event.getAction() == event.ACTION_UP)
			{
				keyEvent.type = keyEvent.KEY_UP;
				if(keyCode > 0 && keyCode < 127)
				{
					pressedKeys[keyCode] = false;
				}
			}
			keyEventsBuffer.add(keyEvent);
		}
		return false;
	}
	
	public boolean isKeyPressed(int keyCode)
	{
		if(keyCode < 0 || keyCode > 127)
		{
			return false;
		}
		return pressedKeys[keyCode];
	}
	
	public List<KeyEvent> getKeyEvents()
	{
		synchronized(this)
		{
			//int len = keyEvents.size();
			for(KeyEvent event : keyEvents)
			{
				keyEventPool.free(event);
			}
			keyEvents.clear();
			keyEvents.addAll(keyEventsBuffer);
			keyEventsBuffer.clear();
			return keyEvents;
		}
	}
}
