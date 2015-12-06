package com.zerous.zerous;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import com.zerous.zerous.io.*;
import java.io.*;
import com.zerous.zerous.input.*;

public class MainActivity extends Activity
{
    GameView gameView;
	Bitmap framebuffer;
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		Display d = getWindowManager().getDefaultDisplay();
		Info.SCREEN_WIDTH = d.getWidth();
		Info.SCREEN_HEIGHT = d.getHeight();
		Info.GUI_ZOOM = (Info.SCREEN_WIDTH / 16)/16;
		framebuffer = Bitmap.createBitmap(d.getWidth(), d.getHeight(), Bitmap.Config.ARGB_4444);
		
		
		
		Core.files = new FileIO(this);
		//Core.input = new AndroidInput(this, gameView);
		
		//new File(Info.GAME_PATH).mkdir();
		
		gameView = new GameView(this, framebuffer);
        setContentView(gameView);
		
    }

	@Override
	protected void onResume()
	{
		super.onResume();
		gameView.resume();
		Toast.makeText(this, "Resume", Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		gameView.pause();
		Toast.makeText(this, "Pause", Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
	}
	
	
	
	public void makeToast(String text)
	{
		//Toast.makeText(this, text, Toast.LENGTH_LONG).show();
		
	}
}
