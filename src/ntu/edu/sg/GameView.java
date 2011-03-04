package ntu.edu.sg;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback
{
   private GameThread _thread;

   public GameView(Context context, AttributeSet attrs) {
       super(context, attrs);

   	//So we can listen for events...
       SurfaceHolder holder = getHolder();
       holder.addCallback(this);
       setFocusable(true); 

       //and instantiate the thread
       _thread = new GameThread(holder, context, new Handler());
   }  

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent msg) {
       return _thread.getGameState().keyPressed(keyCode, msg);
   }
   @Override 
   public boolean onTouchEvent(MotionEvent event){
	   return _thread.getGameState().screenTouch(event);
   }

   //Implemented as part of the SurfaceHolder.Callback interface
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		//Mandatory, just swallowing it for this example

	}

   //Implemented as part of the SurfaceHolder.Callback interface
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		_thread.setRunning(true);
		_thread.start();
	}

   //Implemented as part of the SurfaceHolder.Callback interface
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		
		_thread.setRunning(false);
		//if (_thread.isAlive())
		//	_thread.stop();
	}
	
	public GameThread getThread() {
		
		return _thread;
	}
}
