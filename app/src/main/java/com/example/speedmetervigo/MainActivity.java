package com.example.speedmetervigo;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeOrientation();

        changeDistance();
        animationArrow();
        changeSpeed();
    }

    private void changArrow() {
        ImageView imageView = findViewById(R.id.arrow);
    }

    @Deprecated
    private void animationArrow() {
        ImageView imageView = findViewById(R.id.arrow);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(5000);

        rotateAnimation.setInterpolator(new LinearInterpolator());

        imageView.startAnimation(rotateAnimation);
    }

    private void changeSpeed() {
        final TextView speedTextView = findViewById(R.id.speed);
        String actualSpeed = "190";
        speedTextView.setText(actualSpeed);
    }

    @SuppressLint("SetTextI18n")
    private void changeDistance() {
        final String distanceText = "Dystans: ";
        final TextView distanceTextView = findViewById(R.id.distance);
        final int travelledDistance = 190;

        distanceTextView.setText(distanceText + travelledDistance);
    }

    private void changeOrientation() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_landscape);
        } else {
            setContentView(R.layout.activity_main);
        }
    }
}
