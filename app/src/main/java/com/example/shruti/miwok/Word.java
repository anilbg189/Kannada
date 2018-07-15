package com.example.shruti.miwok;

import android.content.Context;

/**
 * Created by shruthi on 1/23/2018.
 */

public class Word {
    private String menglish;
    private String mkannada;
    private int mImageResourceId=NO_VALID_IMAGE;
    private int mVoiceid;
    private static final int NO_VALID_IMAGE= -1;
    public Word(String english,String kannada)
    {
        menglish=english;
        mkannada=kannada;
    }


    public Word(String english,String kannada,int ImageResourceId,int voiceid)
    {
        menglish=english;
        mkannada=kannada;
        mImageResourceId=ImageResourceId;
        mVoiceid=voiceid;
    }

    public Word(String english,String kannada,int voiceid)
    {
        menglish=english;
        mkannada=kannada;
        mVoiceid=voiceid;
    }

    public boolean hasimage()
    {
        return mImageResourceId!=NO_VALID_IMAGE;
    }


    public String getMenglish() {
        return menglish;
    }

    public String getMkannada() {
        return mkannada;
    }

    public int getImageResourceId(){return mImageResourceId;}

    public int getvoiceid(){return mVoiceid; }
}
