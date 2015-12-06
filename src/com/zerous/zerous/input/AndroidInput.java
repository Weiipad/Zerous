package com.zerous.zerous.input;

import android.content.*;
import android.view.*;
import java.util.*;
import com.zerous.zerous.input.Input.*;

public class AndroidInput implements Input
{
	TouchHandler touchHandler;
	public AndroidInput(Context c, View v)
	{
		touchHandler = new TouchHandler(v);
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
		// TODO: Implement this method
		return false;
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
		// TODO: Implement this method
		return null;
	}
}
