package com.example.shruti.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer play;
    private MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","ondu",R.drawable.number_one,R.raw.ondhu));
        words.add(new Word("Two","ēradu",R.drawable.number_two,R.raw.eradu));
        words.add(new Word("Three","mūuru",R.drawable.number_three,R.raw.mooru));
        words.add(new Word("Four","nālku",R.drawable.number_four,R.raw.nalaku));
        words.add(new Word("Five","aydu",R.drawable.number_five,R.raw.five));
        words.add(new Word("Six","āaru",R.drawable.number_six,R.raw.aaru));
        words.add(new Word("Seven","ēlu",R.drawable.number_seven,R.raw.yellu));
        words.add(new Word("Eight","ēntu",R.drawable.number_eight,R.raw.ondhu));
        words.add(new Word("Nine","ombatthu",R.drawable.number_nine,R.raw.ondhu));
        words.add(new Word("Ten","hatthu",R.drawable.number_ten,R.raw.ondhu));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word=words.get(i);
                Toast.makeText(NumbersActivity.this, "item clicked", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                play=MediaPlayer.create(NumbersActivity.this,word.getvoiceid());
                play.start();
                play.setOnCompletionListener(mCompletionListener);
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
        if ( play!= null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            play.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            play = null;
        }
    }
}
