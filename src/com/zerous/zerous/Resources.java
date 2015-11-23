package com.zerous.zerous;

import android.content.*;
import android.graphics.*;

public class Resources
{
	public static Bitmap START_BUTTON_DOWN;
	public static Bitmap START_BUTTON_UP;
	public static Bitmap PAUSE_BUTTON_DOWN;
	public static Bitmap PAUSE_BUTTON_UP;
	public static Bitmap SETTINGS_BUTTON_UP;
	public static Bitmap SETTINGS_BUTTON_DOWN;
	public static Bitmap BACK_BUTTON_UP;
	public static Bitmap BACK_BUTTON_DOWN;
	public static Bitmap CHECKBOX_CHECKED;
	public static Bitmap CHECKBOX_UNCHECKED;
	public static Bitmap BANNER;
	public static Bitmap LABEL;
	public static Bitmap LEFT_UP;
	public static Bitmap RIGHT_UP;
	public static Bitmap JUMP;
	public static Bitmap BLOCK_BASIC;
	public static Bitmap A_PIXEL;
	
	public static void init(Context c)
	{
		START_BUTTON_UP = FileLoader.loadBitmapFromAssets(c, "gui/start_up.png", Info.GUI_ZOOM);
		START_BUTTON_DOWN = FileLoader.loadBitmapFromAssets(c, "gui/start_down.png", Info.GUI_ZOOM);
		PAUSE_BUTTON_UP = FileLoader.loadBitmapFromAssets(c, "gui/pause_up.png", Info.GUI_ZOOM);
		PAUSE_BUTTON_DOWN = FileLoader.loadBitmapFromAssets(c, "gui/pause_down.png", Info.GUI_ZOOM);
		SETTINGS_BUTTON_UP = FileLoader.loadBitmapFromAssets(c, "gui/settings_up.png", Info.GUI_ZOOM);
		SETTINGS_BUTTON_DOWN = FileLoader.loadBitmapFromAssets(c, "gui/settings_down.png", Info.GUI_ZOOM);
		BACK_BUTTON_UP = FileLoader.loadBitmapFromAssets(c, "gui/back_down.png", Info.GUI_ZOOM);
		BACK_BUTTON_DOWN = FileLoader.loadBitmapFromAssets(c, "gui/back_up.png", Info.GUI_ZOOM);
		CHECKBOX_CHECKED = FileLoader.loadBitmapFromAssets(c, "gui/check_checked.png", Info.GUI_ZOOM);
		CHECKBOX_UNCHECKED = FileLoader.loadBitmapFromAssets(c, "gui/check_unchecked.png", Info.GUI_ZOOM);
		BANNER = FileLoader.loadBitmapFromAssets(c, "gui/banner.png", Info.GUI_ZOOM);
		LABEL = FileLoader.loadBitmapFromAssets(c, "gui/label.png", Info.SCREEN_WIDTH, Info.GUI_ZOOM);
		LEFT_UP = FileLoader.loadBitmapFromAssets(c, "gui/left.png", Info.GUI_ZOOM);
		RIGHT_UP = FileLoader.loadBitmapFromAssets(c, "gui/left.png", -Info.GUI_ZOOM, Info.GUI_ZOOM);
		JUMP = FileLoader.loadBitmapFromAssets(c, "gui/jump.png", Info.GUI_ZOOM, Info.GUI_ZOOM);
		A_PIXEL = FileLoader.loadBitmapFromAssets(c, "gui/apixel.png", Info.GAME_ZOOM);
		BLOCK_BASIC = FileLoader.loadBitmapFromAssets(c, "blockbasic.png", Info.GAME_ZOOM);
	}
	
	public static Bitmap scale(Bitmap b, float x, float y)
	{
		Matrix m = new Matrix();
		m.postScale(x, y);
		return Bitmap.createBitmap(b,0,0,b.getWidth(),b.getHeight(),m,false);
	}
}
