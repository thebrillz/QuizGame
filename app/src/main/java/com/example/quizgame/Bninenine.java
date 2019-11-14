package com.example.quizgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bninenine extends AppCompatActivity {
int score=0, turn=1, rand, correctans;
String uname;
    MediaPlayer hp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        double random=10*Math.random();
        rand=(int)random;
        setqanda(turn, rand);
        Bundle extras=getIntent().getExtras();
        uname=extras.getString("Username");
        hp= MediaPlayer.create(this, R.raw.hedwig);
        hp.seekTo(7000);
        hp.start();


    }

    public void setqanda(int t, int r)
    {
        CheckBox c1=(CheckBox)findViewById(R.id.checkBox1);
        CheckBox c2=(CheckBox)findViewById(R.id.checkBox2);
        CheckBox c3=(CheckBox)findViewById(R.id.checkBox3);
        CheckBox c4=(CheckBox)findViewById(R.id.checkBox4);
        TextView q=(TextView)findViewById(R.id.question);
        c1.setChecked(false);
        c2.setChecked(false);
        c3.setChecked(false);
        c4.setChecked(false);
        if(r<5) {
            switch (t) {
                case 1:
                    q.setText("How many knuts is one galleon?");
                    c1.setText("493");
                    c2.setText("495");
                    c3.setText("491");
                    c4.setText("492");
                    correctans = 1;
                    break;
                case 2:
                    q.setText("What was Peter Pettigrew's nickname?");
                    c1.setText("Padfoot");
                    c2.setText("Prongs");
                    c3.setText("Moony");
                    c4.setText("Wormtail");
                    correctans = 4;
                    break;
                case 3:
                    q.setText("Who was Snape's father?");
                    c1.setText("Toby Snape");
                    c2.setText("Tobias Snape");
                    c3.setText("Theodore Snape");
                    c4.setText("Thomas Snape");
                    correctans = 2;
                    break;
                case 4:
                    q.setText("Who killed Nagini?");
                    c1.setText("Neville");
                    c2.setText("Harry");
                    c3.setText("Ron");
                    c4.setText("Draco");
                    correctans = 1;
                    break;
                case 5:
                    q.setText("How many players in a Quidditch team?");
                    c1.setText("8");
                    c2.setText("9");
                    c3.setText("7");
                    c4.setText("11");
                    correctans = 3;
                    break;
                case 6:
                    Intent intent = new Intent(this, Result.class);
                    intent.putExtra("Score", score);
                    intent.putExtra("Fandom", "hp");
                    intent.putExtra("Username", uname);
                    hp.stop();
                    startActivity(intent);
            }
        }

            else
            {                switch(t)
                {
                    case 1: q.setText("What was Ron's owl called?");
                        c1.setText("Pig");
                        c2.setText("Scabbers");
                        c3.setText("Crookshanks");
                        c4.setText("Hedwig");
                        correctans=1;
                        break;
                    case 2: q.setText("Which horcrux was destroyed in the fire?");
                        c1.setText("Diadem");
                        c2.setText("Riddle's diary");
                        c3.setText("Helga's cup");
                        c4.setText("Locket");
                        correctans=3;
                        break;
                    case 3:    q.setText("What animal did Draco get turned into?");
                        c1.setText("Mouse");
                        c2.setText("Rabbit");
                        c3.setText("Ferret");
                        c4.setText("Stag");
                        correctans=3;
                        break;
                    case 4: q.setText("Who was hosting Voldemort behind his head?");
                        c1.setText("Quirrel");
                        c2.setText("Lockhart");
                        c3.setText("Snape");
                        c4.setText("Lupin");
                        correctans=1;
                        break;
                    case 5: q.setText("What creature is an omen of death?");
                        c1.setText("Thestral");
                        c2.setText("Hipogriff");
                        c3.setText("Werewolf");
                        c4.setText("Grim");
                        correctans=4;
                        break;
                    case 6: Intent intent=new Intent(this, Result.class);
                        intent.putExtra("Score",score);
                        intent.putExtra("Fandom","hp");
                        intent.putExtra("Username",uname);
                        hp.stop();
                        startActivity(intent);
                }

        }

    }

    public void answer1(View view) {
        if(correctans==1)
        {
            score=score+1;

        }
        turn=turn+1;
        setqanda(turn,rand);
    }

    public void answer2(View view) {
        if(correctans==2) {
            score = score + 1;

        }
        turn=turn+1;
        setqanda(turn,rand);
    }

    public void answer3(View view) {
        if(correctans==3)
        {
            score = score + 1;

        }
        turn=turn+1;
        setqanda(turn,rand);
    }

    public void answer4(View view) {
        if(correctans==4)
        {
            score = score + 1;
            /*CheckBox c4=(CheckBox)findViewById(R.id.checkBox1);
            c4.toggle();*/
        }
        turn=turn+1;
        setqanda(turn,rand);
    }
}
