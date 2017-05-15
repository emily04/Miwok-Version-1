package com.example.android.miwok;

import android.content.Context;
import android.view.View;

/**
 * Created by limeg_000 on 5/9/2017.
 */

public class Word {

    // State
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mAudioResourceID;
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    // Methods ***********************************************************************************

    /*Create a new Word object*/
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceID = audioResourceID;
    }

    /*Create a new Word object which includes an image*/
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID, int audioResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;
        mAudioResourceID = audioResourceID;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    public int getImageResourceID(){
        return mImageResourceID;
    }
    public boolean hasImage(){
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }
    public int getmAudioResourceID() {
        return mAudioResourceID;
    }

}

