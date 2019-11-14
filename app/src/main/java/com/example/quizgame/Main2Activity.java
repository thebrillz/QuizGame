package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Main2Activity extends AppCompatActivity {
    MediaPlayer hp=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageButton im=(ImageButton)findViewById(R.id.harry);
        hp=MediaPlayer.create(this, R.raw.hedwig);


    }

    public void hp(View view) {

        Intent next=new Intent(this, Main3Activity.class);
        EditText e=(EditText)findViewById(R.id.username);
        String uname=e.getText().toString();
        if(uname.length()==0)
            uname="AnonUser";
        next.putExtra("Username", uname);
        startActivity(next);
    }
    public void b99(View view) {

        Intent next=new Intent(this, Bninenine.class);
        EditText e=(EditText)findViewById(R.id.username);
        String uname=e.getText().toString();
        if(uname.length()==0)
            uname="AnonUser2";
        next.putExtra("Username", uname);
        startActivity(next);
    }
    public void spn(View view) {

        Intent next=new Intent(this, spn.class);
        EditText e=(EditText)findViewById(R.id.username);
        String uname=e.getText().toString();
        if(uname.length()==0)
            uname="AnonUser3";
        next.putExtra("Username", uname);
        startActivity(next);
    }
}
