package com.example.shruti.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruthi on 1/24/2018.
 */

public class WordAdapter extends ArrayAdapter<Word>
{   private int mcolorResource;
    public WordAdapter(Activity context, ArrayList<Word> words,int colourResource)
    {
        super(context, 0, words);
        mcolorResource=colourResource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
       Word currentword=getItem(position);
       View currentView=convertView;
        if(currentView==null)
        {
            currentView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView kannadaTextView=(TextView)currentView.findViewById(R.id.kannada);
        kannadaTextView.setText(currentword.getMkannada());


        TextView englishTextView=(TextView)currentView.findViewById(R.id.english);
        englishTextView.setText(currentword.getMenglish());

        View container=currentView.findViewById(R.id.textContainer);
        int color= ContextCompat.getColor(getContext(),mcolorResource);
        container.setBackgroundColor(color);

        ImageView imageView = (ImageView) currentView.findViewById(R.id.ImageId);

        if(currentword.hasimage())
         {

            imageView.setImageResource(currentword.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
         }

         else
        {
            imageView.setVisibility(View.GONE);
        }

        return currentView;

    }
}
