package com.avy.superproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * 说明：
 * Created by leeqiuuu on 2019/7/9
 */
public class Fragment1 extends Fragment {
    private List<Integer> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_f, container, false);
        RecyclerView recyclerView =   v.findViewById(R.id.listview);
        data.add(R.drawable.tc1);
        data.add(R.drawable.tc2);
        data.add(R.drawable.tc3);
        data.add(R.drawable.tc4);
        data.add(R.drawable.tc5);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Adapter1 adapter1 = new Adapter1(getContext(),data);
        recyclerView.setAdapter(adapter1);
        return v;
    }
}
