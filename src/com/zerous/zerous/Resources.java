package com.zerous.zerous;

import android.content.*;
import android.graphics.*;
import com.zerous.zerous.*;
import com.zerous.zerous.io.*;

public class Resources
{
	public static Bitmap A_PIXEL;
	public static Bitmap START_BUTTON_DOWN, START_BUTTON_UP;
	public static Bitmap PAUSE_BUTTON_DOWN, PAUSE_BUTTON_UP;
	public static Bitmap SETTINGS_BUTTON_UP, SETTINGS_BUTTON_DOWN;
	public static Bitmap ABOUT_BUTTON_UP, ABOUT_BUTTON_DOWN;
	public static Bitmap BACK_BUTTON_UP, BACK_BUTTON_DOWN;
	public static Bitmap CLOSE_BUTTON_UP, CLOSE_BUTTON_DOWN;
	public static Bitmap CHECKBOX_CHECKED;
	public static Bitmap CHECKBOX_UNCHECKED;
	public static Bitmap BANNER;
	public static Bitmap LABEL;
	public static Bitmap LEFT_UP;
	public static Bitmap RIGHT_UP;
	public static Bitmap AHEAD;
	public static Bitmap BACK;
	public static Bitmap JUMP;
	public static Bitmap BLOCK_BASIC;
	public static Bitmap TILE_PLACER;
	public static Bitmap LOGO;
	public static Bitmap I;
	
	
	
	public static class ID
	{
		public static final int 
		GRASS = 0,
		DIRT = 1,
		BRICK = 2;
	}
	
	public static class PlayerAnimation
	{
		public static Bitmap[] playerFrames;
		
		public static void init()
		{
			playerFrames = loadMap("player.png", 16, Info.GUI_ZOOM, Info.GUI_ZOOM);
		}
	}
	
	public static class Blocks
	{
		public static Bitmap[] blockList;
		
		public static void init()
		{
			blockList = loadMap("blocks/terrain2.png", 16, Info.GUI_ZOOM, Info.GUI_ZOOM);
		}
	}
	
	public static Bitmap[] loadMap(String fileName, int size, float zx, float zy)
	{
		Bitmap map = FileLoader.loadBitmapFromAssets(fileName);
		Bitmap[] list = new Bitmap[(map.getWidth()/size) * (map.getHeight()/size)];
		int x = 0, y = 0;
		
		for(int a = 0;a < (map.getWidth()/size) * (map.getHeight()/size);a++)
		{
			if(x >= map.getWidth()/size)
			{
				y++;
				x = 0;
			}
			list[a] = Bitmap.createBitmap(map, x*size, y*size, size, size);
			x++;
			list[a] = scale(list[a], zx, zy);
		}
		map.recycle();
		return list;
	}
	
	
	public static void init()
	{
		START_BUTTON_UP = FileLoader.loadBitmapFromAssets( "gui/start_up.png", Info.GUI_ZOOM);
		START_BUTTON_DOWN = FileLoader.loadBitmapFromAssets( "gui/start_down.png", Info.GUI_ZOOM);
		PAUSE_BUTTON_UP = FileLoader.loadBitmapFromAssets( "gui/pause_up.png", Info.GUI_ZOOM);
		PAUSE_BUTTON_DOWN = FileLoader.loadBitmapFromAssets( "gui/pause_down.png", Info.GUI_ZOOM);
		SETTINGS_BUTTON_UP = FileLoader.loadBitmapFromAssets( "gui/settings_up.png", Info.GUI_ZOOM);
		SETTINGS_BUTTON_DOWN = FileLoader.loadBitmapFromAssets( "gui/settings_down.png", Info.GUI_ZOOM);
		ABOUT_BUTTON_UP = FileLoader.loadBitmapFromAssets( "gui/about_up.png", Info.GUI_ZOOM);
		ABOUT_BUTTON_DOWN = FileLoader.loadBitmapFromAssets( "gui/about_down.png", Info.GUI_ZOOM);
		BACK_BUTTON_UP = FileLoader.loadBitmapFromAssets( "gui/back_down.png", Info.GUI_ZOOM);
		BACK_BUTTON_DOWN = FileLoader.loadBitmapFromAssets( "gui/back_up.png", Info.GUI_ZOOM);
		CHECKBOX_CHECKED = FileLoader.loadBitmapFromAssets( "gui/check_checked.png", Info.GUI_ZOOM);
		CHECKBOX_UNCHECKED = FileLoader.loadBitmapFromAssets( "gui/check_unchecked.png", Info.GUI_ZOOM);
		CLOSE_BUTTON_UP = FileLoader.loadBitmapFromAssets( "gui/close_up.png", Info.GUI_ZOOM);
		CLOSE_BUTTON_DOWN = FileLoader.loadBitmapFromAssets( "gui/close_down.png", Info.GUI_ZOOM);
		BANNER = FileLoader.loadBitmapFromAssets( "gui/banner.png", Info.GUI_ZOOM);
		LABEL = FileLoader.loadBitmapFromAssets( "gui/label.png", Info.SCREEN_WIDTH, Info.GUI_ZOOM);
		LEFT_UP = FileLoader.loadBitmapFromAssets( "gui/control/left.png", Info.GUI_ZOOM*1.6f);
		RIGHT_UP = FileLoader.loadBitmapFromAssets( "gui/control/left.png", -Info.GUI_ZOOM*1.6f, Info.GUI_ZOOM*1.6f);
		AHEAD = FileLoader.loadBitmapFromAssets( "gui/control/ahead.png", Info.GUI_ZOOM*1.6f);
		BACK = FileLoader.loadBitmapFromAssets( "gui/control/back.png", Info.GUI_ZOOM*1.6f);
		JUMP = FileLoader.loadBitmapFromAssets( "gui/control/jump.png", Info.GUI_ZOOM*1.6f);
		LOGO = FileLoader.loadBitmapFromAssets( "gui/logo.png", Info.GUI_ZOOM*2);
		TILE_PLACER = FileLoader.loadBitmapFromAssets( "gui/tileplacer.png", Info.GUI_ZOOM);
		
		
		A_PIXEL = FileLoader.loadBitmapFromAssets( "gui/apixel.png", Info.GUI_ZOOM);
		Info.PIXEL_SIZE = A_PIXEL.getWidth();
		BLOCK_BASIC = FileLoader.loadBitmapFromAssets( "blockbasic.png", Info.GUI_ZOOM);
		Info.TILE_WIDTH = BLOCK_BASIC.getWidth();
		Info.TILE_HEIGHT = BLOCK_BASIC.getHeight();
		I = FileLoader.loadBitmapFromAssets( "image1.png", Info.GUI_ZOOM);
		
		Blocks.init();
		PlayerAnimation.init();
	}
	
	
	
	public static Bitmap scale(Bitmap b, float x, float y)
	{
		Matrix m = new Matrix();
		m.postScale(x, y);
		return Bitmap.createBitmap(b,0,0,b.getWidth(),b.getHeight(),m,false);
	}
}
