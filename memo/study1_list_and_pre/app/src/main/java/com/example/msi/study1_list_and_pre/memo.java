package com.example.msi.study1_list_and_pre;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;

/**
 * Created by msi on 2017-07-31.
 */

public class memo extends AppCompatActivity{

    EditText title ;
    EditText content ;
    Button button ;
    listadapter adapter ;
    Context context ;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;
    int count = 0;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo);

        adapter = new listadapter() ;
        title = (EditText)findViewById(R.id.titles) ;
        content = (EditText)findViewById(R.id.contents) ;
        button = (Button)findViewById(R.id.add) ;

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                count ++ ;
                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.back),title.getText().toString(),content.getText().toString());

                sharedPreferences = getSharedPreferences("pref_title",0);
                editor = sharedPreferences.edit();
                editor.putString("title"+count,title.getText().toString());
                editor.commit();
                sharedPreferences = getSharedPreferences("pref_content",0);
                editor = sharedPreferences.edit();
                editor.putString("content"+count,content.getText().toString());
                editor.commit();
                sharedPreferences = getSharedPreferences("pref_int",0);
                editor = sharedPreferences.edit();
                editor.putInt("start",count);
                editor.commit();

                finish();
            }
        });
    }

}
