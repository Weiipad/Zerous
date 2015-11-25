package com.zerous.zerous;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;

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
		Info.GUI_ZOOM = Info.SCREEN_WIDTH / 200;
		framebuffer = Bitmap.createBitmap(d.getWidth(), d.getHeight(), Bitmap.Config.ARGB_4444);
		
		gameView = new GameView(this, framebuffer);
        setContentView(gameView);
    }

	@Override
	protected void onResume()
	{
		super.onResume();
		gameView.resume();
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		gameView.pause();
	}
}