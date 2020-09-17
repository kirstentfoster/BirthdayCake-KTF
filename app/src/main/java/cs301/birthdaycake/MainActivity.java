package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.InputEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.SeekBar;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        CakeView view = findViewById(R.id.cakeview);
        CakeController controller = new CakeController(view);

        Button blowOut = findViewById(R.id.BlowOutButton);
        blowOut.setOnClickListener(controller);

        Switch Candles = findViewById(R.id.CandleSwitch);
        Candles.setChecked(true);
        Candles.setOnCheckedChangeListener(controller);

        SeekBar numCandlesBar = findViewById(R.id.NumCandlesSeekbar);
        numCandlesBar.setOnSeekBarChangeListener(controller);

        Switch frosting = findViewById(R.id.FrostingSwitch);
        frosting.setChecked(true);
        frosting.setOnCheckedChangeListener(controller);

        view.setOnTouchListener(controller);
    }

    public void goodbye(View button) {
        Log.i("button","Goodbye");
        finishAffinity();
    }

}
