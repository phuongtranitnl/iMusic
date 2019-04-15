package android2.team2.imusic.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intentSplash = new Intent(this, MainActivity.class);
        SystemClock.sleep(1000);
        startActivity(intentSplash, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        finish();
    }
}