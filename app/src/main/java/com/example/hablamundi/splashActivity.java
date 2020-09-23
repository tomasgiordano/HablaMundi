package com.example.hablamundi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class splashActivity extends AppCompatActivity{

    private final int DURACION_SPLASH = 4000;
    private float mDegreesCurrent = 0F;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);;

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        mDegreesCurrent = rotateViewFromToDegreeAnim(imageView2,mDegreesCurrent, 360, 1500);


        new Handler().postDelayed(new Runnable() {
            public void run()
            {
                Intent intent = new Intent(splashActivity.this, AuthActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURACION_SPLASH);
    }

    private float rotateViewFromToDegreeAnim(View v, float degreeStart, float degrees, long velocity) {

        RotateAnimation rotateAnim = new RotateAnimation(degreeStart, degreeStart + degrees,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        degreeStart = (degreeStart + degrees) % 360;

        rotateAnim.setInterpolator(new LinearInterpolator());
        rotateAnim.setDuration(velocity);
        rotateAnim.setFillEnabled(true);
        rotateAnim.setFillAfter(true);
        v.startAnimation(rotateAnim);

        return degreeStart;
    }


    private void rotate(View v, float degree) {
        final RotateAnimation rotateAnim = new RotateAnimation(0.0f, degree,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnim.setDuration(0);
        rotateAnim.setFillAfter(true);
        v.startAnimation(rotateAnim);
    }

}