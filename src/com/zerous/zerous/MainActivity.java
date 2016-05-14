package com.zerous.zerous;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import com.zerous.zerous.io.*;
import java.io.*;
import com.zerous.zerous.input.*;
import android.view.inputmethod.*;

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
		Info.GAME_ZOOM = Info.GUI_ZOOM;
		
		
		Core.files = new FileIO(this);
		//Core.input = new AndroidInput(this, gameView);
		
		//new File(Info.GAME_PATH).mkdir();
		
		//FrameLayout fl = new FrameLayout(this);
		//EditText e = new EditText(this);
		//e.setFocusable(true);
		//e.setFocusableInTouchMode(true);
		//e.requestFocus();
		
		gameView = new GameView(this, framebuffer);
		gameView.setFocusable(true);
		gameView.setFocusableInTouchMode(true);
		gameView.requestFocus();
		//fl.addView(gameView);
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

	@Override
	public void onBackPressed()
	{
		if(gameView.onBackPressed())
		{
			finish();
			//android.os.Process.killProcess(android.os.Process.myPid());
		}
	}
	
	public void makeToast(String text)
	{
		
	}
}
