package com.example.msi.study1_list_and_pre;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    listadapter adapter;
    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new listadapter();

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        button = (Button)findViewById(R.id.add);

      adapter.addItem(ContextCompat.getDrawable(this, R.drawable.air),"asd","asd") ;
      adapter.addItem(ContextCompat.getDrawable(this, R.drawable.back),"hyeong","woo");

      SharedPreferences shardPreferences = getSharedPreferences("pref_int",0);
      shardPreferences.getString("start","");
      int k = shardPreferences.getInt("start",0);
      for(int j=0;j<k;j++){
          SharedPreferences pref = getSharedPreferences("pref_title",0);
          pref.getString("title"+j,"");
          String titles = pref.getString("title"+j,"");
          SharedPreferences prefs = getSharedPreferences("pref_content",0);
          prefs.getString("content"+j,"");
          String contents = prefs.getString("content"+j,"");
          adapter.addItem(ContextCompat.getDrawable(this,R.drawable.air),titles.toString(),contents.toString());
      }

     // sharedPreferences =   getSharedPreferences("pref",0);
     // editor = sharedPreferences.edit();
      //sharedPreferences.getString("title","");
       // String titles = sharedPreferences.getString("title","");

       // sharedPreferences =   getSharedPreferences("prefs",0);
       // editor = sharedPreferences.edit();
       // sharedPreferences.getString("content","");
       // String contents = sharedPreferences.getString("content","");

      // adapter.addItem(ContextCompat.getDrawable(this,R.drawable.back2),titles.toString(),contents.toString());

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
              Data item = (Data) adapterView.getItemAtPosition(i);

              Intent listIntent = new Intent(MainActivity.this,itemlist.class);
              listIntent.putExtra("image",String.valueOf(item.getImage()));
              listIntent.putExtra("title",item.getTitle());
              listIntent.putExtra("content",item.getContent()) ;

              startActivity(listIntent);
          }
      })  ;
    button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent memoIntent = new Intent(MainActivity.this,memo.class);
            startActivity(memoIntent);
        }
    });

    }


}
