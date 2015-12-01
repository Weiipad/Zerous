package com.zerous.zerous.io;

import android.content.*;
import android.content.res.*;
import android.os.*;
import java.io.*;

public class FileIO
{
	Context context;
	AssetManager asset;
	String path;
	
	public FileIO(Context c)
	{
		context = c;
		asset = c.getAssets();
		path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
	}
	
	public InputStream readAsset(String fileName) throws IOException
	{
		return asset.open(fileName);
	}
	
	public InputStream readFile(String fileName) throws IOException
	{
		return new FileInputStream(path + fileName);
	}
	
	public OutputStream writeFile(String fileName) throws IOException
	{
		return new FileOutputStream(path + fileName);
	}
}
