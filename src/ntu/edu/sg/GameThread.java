package ntu.edu.sg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

	/** Handle to the surface manager object we interact with */
	private SurfaceHolder _surfaceHolder;
	private Paint _paint;
	private GameState _state;
	private boolean mRun = false;

    /** Message handler used by thread to interact with TextView */
   // private Handler mHandler;

	public GameThread(SurfaceHolder surfaceHolder, Context context, Handler handler)
	{
		_surfaceHolder = surfaceHolder;
		_paint = new Paint();
		_state = new GameState();
       // mHandler = handler;
	}

	@Override
	public void run() {
		while(mRun)
		{
			Canvas canvas = _surfaceHolder.lockCanvas();
			_state.update();
			_state.draw(canvas,_paint);
			_surfaceHolder.unlockCanvasAndPost(canvas);
		}
	}

	public GameState getGameState()
	{
		return _state;
	}
	
    public void setRunning(boolean b) {
        mRun = b;
    }
    /*
    public void setScore(int mode) {
        synchronized (_surfaceHolder) {
            Message msg = mHandler.obtainMessage();
            Bundle b = new Bundle();
            b.putString("text", "HALLO");
            b.putInt("viz", View.VISIBLE);
            msg.setData(b);
            mHandler.sendMessage(msg);
        }
    }*/
}