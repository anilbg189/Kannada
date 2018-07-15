package com.example.shruti.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_family_members);
        final ArrayList<Word> familymembers = new ArrayList<Word>();
        familymembers.add(new Word("Mother", "amma",R.drawable.family_mother,R.raw.amma));
        familymembers.add(new Word("Father", "appa",R.drawable.family_father,R.raw.appa));
        familymembers.add(new Word("Son", "maga",R.drawable.family_son,R.raw.maga));
        familymembers.add(new Word("Daughter", "magaLu",R.drawable.family_daughter,R.raw.magalu));
        familymembers.add(new Word("Elder Brother", "aNNa",R.drawable.family_older_brother,R.raw.anna));
        familymembers.add(new Word("Younger Brother", "tamma",R.drawable.family_younger_brother,R.raw.thamma));
        familymembers.add(new Word("Elder Sister", "akka",R.drawable.family_older_sister,R.raw.akka));
        familymembers.add(new Word("Younger Sister", "tangi",R.drawable.family_younger_sister,R.raw.thangi));
        familymembers.add(new Word("Grandfather", "ajja",R.drawable.family_grandfather,R.raw.ajja));
        familymembers.add(new Word("Grandmother", "ajji",R.drawable.family_grandmother,R.raw.ajji));

        WordAdapter FamilyAdapter=new WordAdapter(this,familymembers,R.color.category_family);
        ListView FamilyView=(ListView)findViewById(R.id.family_members);
        FamilyView.setAdapter(FamilyAdapter);

        FamilyView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word=familymembers.get(i);
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(FamilyMembersActivity.this,word.getvoiceid());
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
