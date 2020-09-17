package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener{
    private CakeView v;
    private CakeModel model;

    CakeController(CakeView cv) {
        v = cv;
        model = cv.getModel();
    }

    @Override
    public void onClick(View v) {

        Button litCandles = v.findViewById(R.id.BlowOutButton);
        if(model.candlesLit==true) {
            model.candlesLit = false;
            litCandles.setText("Re-Light");
        }
        else{
            model.candlesLit = true;
            litCandles.setText("Blow Out");
        }
        this.v.invalidate();

        //Log.d("BlowOutButton","Blow Out");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.getId()==R.id.CandleSwitch) {
            model.hasCandles = b;
        }
        if(compoundButton.getId()==R.id.FrostingSwitch){
            model.hasFrosting = b;
        }
        this.v.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        model.numCandles = i;
        this.v.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        model.touchX = motionEvent.getX();
        model.touchY = motionEvent.getY();
        this.v.invalidate();
        return false;
    }
}
