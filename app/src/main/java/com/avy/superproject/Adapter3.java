package com.avy.superproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * 说明：
 * Created by leeqiuuu on 2019/7/9
 */
public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewHolder> {
    private Context context;
    private List<Integer> data;

    public Adapter3(Context context, List<Integer> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_3,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.img.setBackgroundResource(data.get(position));
        holder.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gid = 38;
                int type = 0;
                switch (position){
                    case 0:
                        gid = 20;
                        break;
                    case 1:
                        gid = 2;
                        break;
                    case 2:
                        gid = 34;
                        break;
                }
                if(position > 2){
                    type = 0;
                }
                Intent intent = new Intent(context,FragmentThird.class);
                intent.putExtra("type", type);
                intent.putExtra("gid", gid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView img;
        public RelativeLayout lay;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            lay = itemView.findViewById(R.id.lay);
        }
    }

}
