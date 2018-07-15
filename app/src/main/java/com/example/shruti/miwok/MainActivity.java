package com.example.shruti.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer player=MediaPlayer.create(this,R.raw.welcome);
        player.start();


        TextView numbers=(TextView)findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        TextView FamilyMembers=(TextView)findViewById(R.id.family);
        FamilyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent = new Intent(MainActivity.this, FamilyMembersActivity.class);
                startActivity(familyIntent);
            }
           });


        TextView colors=(TextView)findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsintent=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorsintent);
            }
        });

        TextView Phrases=(TextView)findViewById(R.id.phrases);
        Phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesIntent=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });

    }

    public void numbers(View view)
    {
        Intent i=new Intent(this,NumbersActivity.class);
        startActivity(i);
    }
}
