package com.example.msi.study1_list_and_pre;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by msi on 2017-08-02.
 */

public class itemlist extends AppCompatActivity {
    ImageView imageView ;
    TextView titleview ;
    TextView contentView ;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlist);

        imageView = (ImageView)findViewById(R.id.image);
        titleview = (TextView)findViewById(R.id.title);
        contentView = (TextView)findViewById(R.id.content);

        Intent intent = getIntent() ;

        Drawable imageview = Drawable.createFromPath(intent.getExtras().getString("image"));
        String title = intent.getExtras().getString("title");
        String content = intent.getExtras().getString("content");
        imageView.setImageDrawable(imageview);
        contentView.setText(content);

    }

}
