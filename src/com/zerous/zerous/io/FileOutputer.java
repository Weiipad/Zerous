package com.zerous.zerous.io;

import java.io.*;
import android.os.*;

public class FileOutputer
{
	public static void makeDir(String path)
	{
		File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path);
		f.mkdir();
	}
}
