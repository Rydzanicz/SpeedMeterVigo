package com.example.speedmetervigo;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView speedTextView;
    private TextView distanceTextView;
    private ImageView arrowImageView;
    private ImageView menuIcon;
    private int speed = 0;
    private PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ? R.layout.activity_main_landscape : R.layout.activity_main);

        findViews();
        changeDistance();
        animationArrow();
        createMenu();
    }

    private void findViews() {
        speedTextView = findViewById(R.id.speed);
        distanceTextView = findViewById(R.id.distance);
        arrowImageView = findViewById(R.id.arrow);
        menuIcon = findViewById(R.id.menu_icon);
    }

    private void changeSpeed() {
        // Update speedTextView with actual speed (replace with your logic)
        speedTextView.setText(String.valueOf(speed));
    }

    @SuppressLint("SetTextI18n")
    private void changeDistance() {
        final String distanceText = "Dystans: ";
        final int travelledDistance = 190;

        distanceTextView.setText(distanceText + travelledDistance);
    }

    private void animationArrow() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(5000);
        rotateAnimation.setInterpolator(new LinearInterpolator());

        arrowImageView.startAnimation(rotateAnimation);
    }

    private void createMenu() {
        // 1. Create PopupMenu anchored to menu icon
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                popupMenu = new PopupMenu(MainActivity.this, menuIcon);

                // 2. Inflate the menu layout (replace "menu.xml" with your actual filename)
                popupMenu.getMenuInflater().inflate(R.layout.menu, popupMenu.getMenu());

                // 3. Handle menu item clicks (optional, add your logic here)
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            // Handle menu item clicks here
                            default:
                                return true;
                        }
                    }
                });

                // 4. Show the menu
                popupMenu.show();
            }
        });
    }

    // Handle menu icon click for acceleration (optional)
    public void accelerate(View view) {
        speed += 10;
        changeSpeed();
    }
}
