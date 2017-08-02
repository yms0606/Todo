package com.example.msi.study1_list_and_pre;

import android.graphics.drawable.Drawable;

/**
 * Created by msi on 2017-07-31.
 */

public class Data {
   private Drawable image;
    private String title;
    private String content;

    public Drawable getImage(){
        return image;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
