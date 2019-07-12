package com.avy.superproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 * Created by leeqiuuu on 2019/7/9
 */
public class FragmentSecond extends Fragment {
    private List<Data> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        RecyclerView recyclerView =   v.findViewById(R.id.recycle);
        Data data1 = new Data();
        data1.url = R.drawable.bg1;
        data1.title = "梦幻西游";
        data1.time = "2019.07.05上架";
        Data data2 = new Data();
        data2.url = R.drawable.bg2;
        data2.title = "全战三国";
        data2.time = "2019.07.05上架";
        Data data3 = new Data();
        data3.url = R.drawable.bg3;
        data3.title = "最终幻想15";
        data3.time = "2019.07.05上架";
        Data data4 = new Data();
        data4.url = R.drawable.bg4;
        data4.title = "最终幻想15";
        data4.time = "2019.07.05上架";
        Data data5 = new Data();
        data5.url = R.drawable.bg5;
        data5.title = "最终幻想15";
        data5.time = "2019.07.05上架";
        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        data.add(data5);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        Adapter2 adapter2 = new Adapter2(getContext(),data);
        recyclerView.setAdapter(adapter2);
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.lb1);
        list.add(R.drawable.lb2);
        list.add(R.drawable.lb3);
        Banner banner = v.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(list);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        return v;
    }
}

