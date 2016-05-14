package com.zerous.zerous.input;

import android.content.*;
import android.view.*;
import java.util.*;
import com.zerous.zerous.input.Input.*;

public class AndroidInput implements Input
{
	TouchHandler touchHandler;
	KeyboardHandler keyboardHandler;
	public AndroidInput(View v)
	{
		touchHandler = new TouchHandler(v);
		keyboardHandler = new KeyboardHandler(v);
	}

	@Override
	public int getTouchX(int pointer)
	{
		return touchHandler.getTouchX(pointer);
	}

	@Override
	public int getTouchY(int pointer)
	{
		return touchHandler.getTouchY(pointer);
	}

	@Override
	public boolean isKeyPressed(int keyCode)
	{
		return keyboardHandler.isKeyPressed(keyCode);
	}

	@Override
	public boolean isTouchDown(int pointer)
	{
		return touchHandler.isTouchDown(pointer);
	}

	@Override
	public List<Input.TouchEvent> getTouchEvents()
	{
		return touchHandler.getTouchEvents();
	}

	@Override
	public List<Input.KeyEvent> getKeyEvents()
	{
		return keyboardHandler.getKeyEvents();
	}
}
