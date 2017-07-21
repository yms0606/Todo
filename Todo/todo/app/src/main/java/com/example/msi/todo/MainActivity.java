package com.example.msi.todo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

import static com.example.msi.todo.R.id.parent;
public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManger ;
    private ArrayList<MyData> myDataset ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view) ;

        mRecyclerView.setHasFixedSize(true);

        mLayoutManger = new LinearLayoutManager(this) ;

        mRecyclerView.setLayoutManager(mLayoutManger) ;

        myDataset = new ArrayList<>() ;

        mAdapter = new MyAdapter(myDataset);

        mRecyclerView.setAdapter(mAdapter);

        myDataset.add(new MyData("#InsideOut",R.drawable.air));
        myDataset.add(new MyData("#Mini", R.drawable.air));
        myDataset.add(new MyData("#ToyStroy", R.drawable.air));

    }
}


