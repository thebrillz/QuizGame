package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class LeaderBoard extends AppCompatActivity {
DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        TextView n1=(TextView)findViewById(R.id.n1);
        TextView s1=(TextView)findViewById(R.id.s1);
        TextView n2=(TextView)findViewById(R.id.n2);
        TextView s2=(TextView)findViewById(R.id.s2);
        TextView n3=(TextView)findViewById(R.id.n3);
        TextView s3=(TextView)findViewById(R.id.s3);
        TextView n4=(TextView)findViewById(R.id.n4);
        TextView s4=(TextView)findViewById(R.id.s4);
        TextView n5=(TextView)findViewById(R.id.n5);
        TextView s5=(TextView)findViewById(R.id.s5);
        TextView[] n={n1,n2,n3,n4,n5};
        TextView[] s={s1,s2,s3,s4,s5};

        db=new DataBaseHelper(this);
        Bundle extras=getIntent().getExtras();
        String fd=extras.getString("Fandom");
        Cursor c=db.getLeaderboard(fd);
       // if(c.getCount()==0)
         //   t.setText("nothing here");
        //else
        //{
            int num=c.getCount();
       //     String[] names=new String[num];
         //   String[] scores=new String[num];
            int i=0;
            while(c.moveToNext())
            {
                n[i].setText(c.getString(0));
                s[i].setText(c.getString(1));
                i++;
            }



    }
}
