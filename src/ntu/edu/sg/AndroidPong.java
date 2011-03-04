package ntu.edu.sg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidPong extends Activity {
    /** A handle to the View in which the game is running. */
  //  private GameView mPongView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      //  mPongView = (GameView) findViewById(R.id.pong);
        // give the LunarView a handle to the TextView used for messages
      //  mPongView.getThread().getGameState().setTextView((TextView) findViewById(R.id.text));

    }
}