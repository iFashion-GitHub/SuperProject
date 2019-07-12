package com.avy.superproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * 说明：
 * Created by leeqiuuu on 2019/7/9
 */
public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {
    private Context context;
    private List<Data> data;

    public Adapter2(Context context, List<Data> data){
        this.context = context;
        this.data = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.img.setBackgroundResource(data.get(position).url);
        holder.t1.setText(data.get(position).title);
        holder.t2.setText(data.get(position).time);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView img;
        public TextView t1;
        public TextView t2;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.title);
            t2 = itemView.findViewById(R.id.time);
        }
    }

}
