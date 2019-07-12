package com.youneng.x5app;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youneng.x5app.entity.Game;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    private List<Game> gameList;
    //添加构造方法
    public GameAdapter(List<Game> gameList) {
        this.gameList = gameList;
    }
    //在onCreateViewHolder（）中完成布局的绑定，同时创建ViewHolder对象，返回ViewHolder对象
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item,parent,false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
        return null;
    }
    //在内部类中完成对控件的绑定
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
//            imageView = itemView.findViewById(R.id.item_imgv);
//            textView = itemView.findViewById(R.id.item_tv);
        }
    }
    //在onBindViewHolder（）中完成对数据的填充
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.imageView.setImageResource(gameList.get(position).getImgID());
        holder.textView.setText(gameList.get(position).getGameName());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(holder.textView,position);
            }
        });
    }
    //这个方法很简单了，返回playerList中的子项的个数
    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public  void setOnItemClickListener(GameAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }


}
