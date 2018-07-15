package com.example.shruti.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        final ArrayList<Word> Colours=new ArrayList<Word>();
        Colours.add(new Word("Black","kappu",R.drawable.color_black,R.raw.kappu));
        Colours.add(new Word("Brown","kandu",R.drawable.color_brown,R.raw.kandu));
        Colours.add(new Word("Green","hasiru",R.drawable.color_green,R.raw.hasiru));
        Colours.add(new Word("Grey","buudu",R.drawable.color_gray,R.raw.buddu));
        Colours.add(new Word("Red","kempu",R.drawable.color_red,R.raw.kempu));
        Colours.add(new Word("White","biLi",R.drawable.color_white,R.raw.billi));
        Colours.add(new Word("Yellow","haLadi",R.drawable.color_mustard_yellow,R.raw.haladi));

        WordAdapter ColousAdapter=new WordAdapter(this,Colours,R.color.category_colors);
        ListView colourView=(ListView)findViewById(R.id.colours);
        colourView.setAdapter(ColousAdapter);

        colourView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Word word=Colours.get(i);
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(ColorsActivity.this,word.getvoiceid());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if ( mediaPlayer!= null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
