package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.category;
import static android.view.View.GONE;

/**
 * Created by limeg_000 on 5/9/2017.
 *
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceID;

    // A constructor for the WordAdapter.
    // Context refers to which file needs to be modified.
    // The list is the data we want to use to populate into the lists.
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID){
        // Here we initialize the internal storage of our adapter.
        // Our custom adapter is for two TextViews and an ImageView.
        // Because the second argument is used when populating a single TextView, we don't need it.
        // Thus the second argument can be any value--we will use zero.
        super(context, 0, words);
        mColorResourceID = colorResourceID;
    }


   // @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Check if the existing view is being reused--otherwise, inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        // Get the Word object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the currentWord object and set this text to the TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        miwokTextView.setBackgroundColor(color);


        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the Default translation from the currentWord object and set this text to the TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        int sameColor = ContextCompat.getColor(getContext(), mColorResourceID);
        defaultTextView.setBackgroundColor(sameColor);


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        if(currentWord.hasImage()) {
            // Get the resource ID from the currentWord object and set the image to iconView
            iconView.setImageResource(currentWord.getImageResourceID());
            // Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        } else {
            // If Word object does not have an image, hide the imageview
            iconView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
