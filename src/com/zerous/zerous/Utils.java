package com.zerous.zerous;
import android.content.*;
import android.widget.*;
import android.graphics.*;

public class Utils
{
	public static Context context;
	static Paint paint;
	public static void init(Context c)
	{
		context = c;
		paint = new Paint();
		paint.setColor(Color.RED);
		//makeToast("AAA");
	}
	
	public static void drawBox(Canvas c, float x, float y, float w, float h)
	{
		c.drawLine(x, y, x + w, y, paint);
		c.drawLine(x + w, y, x + w, y + h, paint);
		c.drawLine(x + w, y + h, x, y + h, paint);
		c.drawLine(x, y + h, x, y, paint);
	}
	
	public static void makeToast(String text)
	{
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
}
