package com.example.richm.brightness;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {
    public Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // Params for the window.
        // You can easily set the alpha and the dim behind the window from here
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.8f;    // lower than one makes it more transparent
        params.dimAmount = 0f;  // set it higher if you want to dim behind the window
        getWindow().setAttributes(params);

        // Gets the display size so that you can set the window to a percent of that
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x; //assign device display width to var width
        int height = size.y; //assign device display height to var height

        //set the width and height of the app window to multiples of the display dimensions
        getWindow().setLayout((int) (width * .95), (int) (height * .5));

        // Make sure to set your content view AFTER you have set up the window or it will crash.
        setContentView(R.layout.activity_main);

    }
    //Make all these actions permanent by using layoutparams.screenBrightness = 0 / 100f;
    public void btn1(View v) {
        android.view.WindowManager.LayoutParams lp = getWindow().getAttributes(); //why isn't this working?
        lp.screenBrightness = 0 / 100f;
        getWindow().setAttributes(lp);

    }
    public void btn2(View v) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = 14 / 100f;
        getWindow().setAttributes(lp);
    }
    public void btn3(View v) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = 100 / 100.0f;
        getWindow().setAttributes(lp);
    }

}
