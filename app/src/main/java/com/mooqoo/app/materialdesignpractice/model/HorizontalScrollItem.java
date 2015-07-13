package com.mooqoo.app.materialdesignpractice.model;

import android.graphics.drawable.Drawable;

/**
 * Created by wade0716 on 15/7/12.
 */
public class HorizontalScrollItem {
    private String text;
    private Drawable drawable;
    private static int id = 0;


    //Constructor
    public HorizontalScrollItem() {

    }

    //Constructor
    public HorizontalScrollItem(Drawable drawable) {
        id++;
        text = ""+id;
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
