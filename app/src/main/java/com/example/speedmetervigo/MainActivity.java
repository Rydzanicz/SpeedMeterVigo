package com.example.speedmetervigo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sprawdź orientację ekranu po uruchomieniu
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_landscape);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Upewnij się, że widok jest aktualizowany tylko przy zmianie orientacji
        if (newConfig.orientation != getResources().getConfiguration().orientation) {
            if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                setContentView(R.layout.activity_main_landscape);
            } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                setContentView(R.layout.activity_main);
            }
        }
    }
}
