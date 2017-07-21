package com.example.msi.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by msi on 2017-07-21.
 */

public class MyAdapter extends Adapter<ViewHolder> {

        private ArrayList<MyData> mDataset ;


    public  static class ViewHloder extends ViewHolder{
        public ImageView mImageView ;
        public TextView mTextView ;

        public ViewHolder(View view ){
            super(view);
            mImageView = (ImageView)view.findViewById(R.id.images) ;
            mTextView = (TextView)view.findViewById(R.id.texts) ;


        }
    }

    public MyAdapter(ArrayList<MyData> myDataset){
        mDataset =myDataset ;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return (ViewHolder) viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).text);
        holder.mImageView.setImageResource(mDataset.get(position).img);
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
class MyData{
    public String text;
    public int img;
    public MyData(String text, int img){
        this.text = text;
        this.img = img;
    }
}
