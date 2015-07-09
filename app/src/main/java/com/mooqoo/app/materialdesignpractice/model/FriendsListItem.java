package com.mooqoo.app.materialdesignpractice.model;

import android.graphics.drawable.Drawable;

/**
 * Created by wade0716 on 15/7/9.
 */
public class FriendsListItem {
    private String text;
    private Drawable drawable;


    //Constructor
    public FriendsListItem() {

    }

    //Constructor
    public FriendsListItem(String text, Drawable drawable) {
        this.text = text;
        this.drawable = drawable;
    }

    //getter and setter
    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getText() {
        return text;
    }

    public void setTitle(String title) {
        this.text = text;
    }
}