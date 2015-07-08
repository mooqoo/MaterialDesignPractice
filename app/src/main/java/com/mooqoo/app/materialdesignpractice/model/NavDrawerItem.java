package com.mooqoo.app.materialdesignpractice.model;

/**
 * Created by albert on 15/7/7.
 *
 * This is just a plane java class
 * It defines each row in navigation drawer menu
 */
public class NavDrawerItem {
    private boolean showNotify;
    private String title;

    //Constructor
    public NavDrawerItem() {

    }

    //Constructor
    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
