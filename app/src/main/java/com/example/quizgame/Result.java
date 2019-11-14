package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {
DataBaseHelper myDb;
    String fd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        myDb=new DataBaseHelper(this);

        Bundle extras=getIntent().getExtras();
         fd=extras.getString("Fandom");
        int s=extras.getInt("Score");
        String uname=extras.getString("Username");
        boolean insert= myDb.insert(uname, fd,s);
        if(insert==true)
            Toast.makeText(this, "Inserted",Toast.LENGTH_SHORT).show();
        TextView t=(TextView)findViewById(R.id.textView);
        if(s>3)
        t.setText("Congratulations "+uname+"! You have scored "+s+"! Great going.");
        else
            t.setText("Aww, "+uname+". Your score is "+s+". Better luck next time");


    }

    public void leaderboard(View view) {

        Intent intent=new Intent(this,LeaderBoard.class);
        intent.putExtra("Fandom",fd);
        startActivity(intent);
    }
}
