package com.zerous.zerous.ui;
import android.graphics.*;

public class ButtonSkin
{
	private Bitmap up, down;
	public ButtonSkin(Bitmap b)
	{
		up = b;
		down = b;
	}
	
	public ButtonSkin(Bitmap... b)
	{
		up = b[0];
		down = b[1];
	}
	
	public int getWidth()
	{
		return up.getWidth();
	}
	
	public int getHeight()
	{
		return up.getHeight();
	}
	
	public Bitmap getUp()
	{
		return up;
	}
	
	public Bitmap getDown()
	{
		return down;
	}
}
