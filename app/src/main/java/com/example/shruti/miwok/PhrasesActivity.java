package com.example.shruti.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_phrases);
        final ArrayList<Word> phrases=new ArrayList<Word>();
        phrases.add(new Word("Where are you going?","elli hogthidira",R.raw.whereugoing));
        phrases.add(new Word("What is your name?","ninna hesaru enu?",R.raw.watsurname));
        phrases.add(new Word("My name is...","nanna hesaru...",R.raw.nannahesaru));
        phrases.add(new Word("How are you feeling?","hege idira?",R.raw.howru));
        phrases.add(new Word("I’m feeling good.","naanu chennagi idini",R.raw.emfeelinggood));
        phrases.add(new Word("Are you coming?","neenu barthiddya?",R.raw.neenubartidya));
        phrases.add(new Word("Yes, I’m coming.","haudu, naanu barthidini",R.raw.yesemcoming));
        phrases.add(new Word("I’m coming.","barthidini",R.raw.emcoming));
        phrases.add(new Word("Let’s go.","hogana",R.raw.letsgo));
        phrases.add(new Word("Come here","illi banni",R.raw.comehere));

        WordAdapter phrasesAdapter=new WordAdapter(this,phrases,R.color.category_phrases);
        ListView phrasesView=(ListView)findViewById(R.id.phrases);
        phrasesView.setAdapter(phrasesAdapter);

        phrasesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word=phrases.get(i);
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(PhrasesActivity.this,word.getvoiceid());
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
