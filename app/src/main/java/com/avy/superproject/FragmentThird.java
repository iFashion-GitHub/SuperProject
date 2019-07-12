package com.avy.superproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.youneng.x5app.activity.SecondActivity;

/**
 * 说明：
 * Created by leeqiuuu on 2019/7/9
 */
public class FragmentThird extends AppCompatActivity {
    private List<Integer> data = new ArrayList<>();
    private int type = 0;
    private int gid = 0;
    private String url;
    int num[] = {R.layout.fragment3_1,R.layout.fragment3_2,R.layout.fragment3_3,
            R.layout.fragment3_4,R.layout.fragment3_5};
    int tu[][] = {
            {R.drawable.t1_1,R.drawable.t1_2,R.drawable.t1_3,},
            {R.drawable.t2_1,R.drawable.t2_2,R.drawable.t2_3,},
            {R.drawable.t3_1,R.drawable.t3_2,R.drawable.t3_3,},
            {R.drawable.t4_1,R.drawable.t4_2,R.drawable.t4_3,},
            {R.drawable.t5_1,R.drawable.t5_2,R.drawable.t5_3,},
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int index = intent.getIntExtra("position", 0);
        setContentView(num[index]);
        RecyclerView recyclerView = findViewById(R.id.recycle);
        data.add(tu[index][0]);
        data.add(tu[index][1]);
        data.add(tu[index][2]);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        Adapter3 adapter2 = new Adapter3(this, data);
        recyclerView.setAdapter(adapter2);

        type = intent.getIntExtra("type", 0);
        gid = intent.getIntExtra("gid", 0);
        url = intent.getStringExtra("url");
        findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type == 0){
                    //启动的主机游戏
                    Intent intent = new Intent(FragmentThird.this, com.avy.haobai.MainActivity.class);
                    intent.putExtra("level",1);
                    intent.putExtra("gameid",gid);
                    intent.putExtra("frame",60);
                    startActivity(intent);

                    //启动网页游戏
//                Intent intent = new Intent(FragmentThird.this, SecondActivity.class);
//                intent.putExtra("url",1);
//                startActivity(intent);
                }else {
                    Intent intent = new Intent(FragmentThird.this, SecondActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }
            }
        });
    } }