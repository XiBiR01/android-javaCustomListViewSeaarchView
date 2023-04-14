package com.example.customlistviewsearchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<String> shapeName;
     ArrayList<Integer> shapeImage;
     LayoutInflater inflater;

    public CustomAdapter(Context ctx, ArrayList<String> shapeName, ArrayList<Integer> shapeImage) {
        this.shapeName = shapeName;
        this.shapeImage = shapeImage;
        this.ctx = ctx;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return shapeName.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.listview_cell,null);
        TextView txtView= convertView.findViewById(R.id.shapeName);
        ImageView imgView=convertView.findViewById(R.id.shapeImage);
        txtView.setText(shapeName.get(position));
        imgView.setImageResource(shapeImage.get(position));
        return convertView;
    }
}
