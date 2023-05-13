package com.xacarana.utilapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(Splash.this, Login.class);
            Splash.this.startActivity(mainIntent);
            Splash.this.finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}
