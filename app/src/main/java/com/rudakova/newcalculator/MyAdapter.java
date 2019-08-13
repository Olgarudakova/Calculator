package com.rudakova.newcalculator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rudakova.newcalculator.R;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private LayoutInflater inflater;
    ArrayList<String> list;

    MyAdapter(Context context, ArrayList<String> list) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_presenter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int i) {
        String s = list.get(i);
        holder.textView.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
        }
    }
}