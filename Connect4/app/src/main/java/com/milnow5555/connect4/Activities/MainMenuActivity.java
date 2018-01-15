package com.milnow5555.connect4.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.milnow5555.connect4.R;
import com.milnow5555.connect4.Utility.AlgorithmUtility;

public class MainMenuActivity extends AppCompatActivity {

    private static boolean wasPlayed = false;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        if(!wasPlayed) {
            AlgorithmUtility.startMediaPlayer(this);
            wasPlayed = true;
        }
    }

    public void launchOptions(View view){
        Intent intent = new Intent(this, OptionsActivity.class);

        startActivity(intent);
    }
    public void launchGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

}
