package com.zerous.zerous.io;

import android.content.*;
import android.content.res.*;
import android.graphics.*;
import java.io.*;

public class FileLoader
{
	public static Bitmap loadBitmapFromAssets(Context c, String fileName, float xy)
	{
		AssetManager assets = c.getAssets();
		InputStream is = null;

		try
		{
			is = assets.open(fileName);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		BitmapFactory.Options options = new BitmapFactory.Options();
		Bitmap bitmap = BitmapFactory.decodeStream(is, null, options);
		
		Matrix m = new Matrix();
		m.postScale(xy, xy);

		return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, false);
	}
	
	public static Bitmap loadBitmapFromAssets(Context c, String fileName, float x, float y)
	{
		AssetManager assets = c.getAssets();
		InputStream is = null;

		try
		{
			is = assets.open(fileName);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			
		}
		BitmapFactory.Options options = new BitmapFactory.Options();
		Bitmap bitmap = BitmapFactory.decodeStream(is, null, options);

		Matrix m = new Matrix();
		m.postScale(x, y);

		return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, false);
	}
	
	public static Bitmap loadBitmapFromAssets(Context c, String fileName)
	{
		AssetManager assets = c.getAssets();
		InputStream is = null;

		try
		{
			is = assets.open(fileName);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		BitmapFactory.Options options = new BitmapFactory.Options();
		Bitmap bitmap = BitmapFactory.decodeStream(is, null, options);
		
		return bitmap;
	}
}
