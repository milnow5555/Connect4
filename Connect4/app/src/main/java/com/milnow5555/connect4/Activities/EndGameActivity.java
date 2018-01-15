package com.milnow5555.connect4.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.milnow5555.connect4.R;

public class EndGameActivity extends AppCompatActivity {

    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");
        setText();
        Log.i("Mess","tu jesteęę" + message);
    }
    private void setText(){
        TextView textView = (TextView)findViewById(R.id.maintext);
        textView.setText(message);
    }
    public void backToMainMenu(View view){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
