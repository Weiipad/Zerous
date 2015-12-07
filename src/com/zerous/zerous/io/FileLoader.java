package com.zerous.zerous.io;

import android.content.*;
import android.content.res.*;
import android.graphics.*;
import java.io.*;
import com.zerous.zerous.*;

public class FileLoader
{
	public static Bitmap loadBitmapFromAssets(String fileName, float xy)
	{
		Bitmap bitmap = null;
		try
		{
			BitmapFactory.Options options = new BitmapFactory.Options();
			bitmap = BitmapFactory.decodeStream(Core.files.readAsset(fileName) , null, options);
		}
		catch(IOException e)
		{
			
		}
		
		Matrix m = new Matrix();
		m.postScale(xy, xy);

		return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, false);
	}
	
	public static Bitmap loadBitmapFromAssets(String fileName, float x, float y)
	{
		Bitmap bitmap = null;
		try
		{
			BitmapFactory.Options options = new BitmapFactory.Options();
			bitmap = BitmapFactory.decodeStream(Core.files.readAsset(fileName) , null, options);
		}
		catch(IOException e)
		{

		}
		
		Matrix m = new Matrix();
		m.postScale(x, y);

		return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, false);
	}
	
	public static Bitmap loadBitmapFromAssets(String fileName)
	{
		Bitmap bitmap = null;
		try
		{
			BitmapFactory.Options options = new BitmapFactory.Options();
			bitmap = BitmapFactory.decodeStream(Core.files.readAsset(fileName) , null, options);
		}
		catch(IOException e)
		{

		}
		return bitmap;
	}
}
