package com.example.msi.study1_list_and_pre;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by msi on 2017-07-31.
 */

public class listadapter extends BaseAdapter {

    private ArrayList<Data> listViewItemList = new ArrayList<Data>() ;
    public listadapter(){

    }
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final  int pos = i;
        final Context context = viewGroup.getContext();

        if(view==null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item,viewGroup,false);
        }
        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView content = (TextView) view.findViewById(R.id.content);

        Data listViewItem = listViewItemList.get(i);

        image.setImageDrawable(listViewItem.getImage());
        title.setText(listViewItem.getTitle());
        content.setText(listViewItem.getContent());
        return view;
    }
    public  void addItem(Drawable image,String title,String content){
        Data item = new Data();

        item.setImage(image);
        item.setTitle(title);
        item.setContent(content);

        listViewItemList.add(item);

    }
}
