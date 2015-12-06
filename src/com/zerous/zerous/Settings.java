package com.zerous.zerous;
import java.io.*;

public class Settings
{
	public static boolean DEBUG;
	public static boolean QUICK_START;
	public static boolean TILEPLACER_MODE;
	
	public static void load()
	{
		BufferedReader in = null;
		try
		{
			in = new BufferedReader(new InputStreamReader(Core.files.readFile(Info.GAME_PATH + "/.settings")));
			DEBUG = Boolean.parseBoolean(in.readLine());
			QUICK_START = Boolean.parseBoolean(in.readLine());
			TILEPLACER_MODE = Boolean.parseBoolean(in.readLine());
		}
		catch(IOException e)
		{
			
		}
	}
	
	public static void save()
	{
		BufferedWriter out = null;
		try
		{
			out = new BufferedWriter(new OutputStreamWriter(Core.files.writeFile(Info.GAME_PATH + "/.settings")));
			out.write(Boolean.toString(DEBUG));
			out.write("\n");
			out.write(Boolean.toString(QUICK_START));
			out.write("\n");
			out.write(Boolean.toString(TILEPLACER_MODE));
		}
		catch(IOException e)
		{
			
		}
		finally
		{
			try
			{
				if(out != null)
				{
					out.close();
				}
			}
			catch(IOException e)
			{
				
			}
		}
	}
}
