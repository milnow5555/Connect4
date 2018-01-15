package com.milnow5555.connect4.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.milnow5555.connect4.Activities.MainMenuActivity;
import com.milnow5555.connect4.R;
import com.milnow5555.connect4.Utility.AlgorithmUtility;

public class OptionsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private int volumeLevel;
    private Switch switch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_menu);

        switch1 = (Switch)findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(this);



    }
    public void backToMainMenu(View view) {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
    public void increaseVolume(){

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(switch1.isChecked()){
            AlgorithmUtility.startMediaPlayer(this);
        }else {
            AlgorithmUtility.stopMediaPlayer();
        }

    }
}
