package com.youneng.x5app.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.youneng.x5app.GameAdapter;
import com.youneng.x5app.entity.Game;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG= "WatchDog";
    private Button button;
    private RecyclerView recyclerView;
    private List<Game> gameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_main2);
//        initList();

//        recyclerView = findViewById(R.id.main_rv);
        initView();
    }

//    private void initList() {
//        Game game1 = new Game(R.mipmap.ic_launcher,"奔跑吧兔兔","http://tv.space-sh.com/games/tuzi/index.html");
//        Game game2 = new Game(R.mipmap.ic_launcher,"超级赛车","http://tv.space-sh.com/games/chaojisaiche/index.html");
//        Game game3 = new Game(R.mipmap.ic_launcher,"极限挑战","http://tv.space-sh.com/games/jixiantiaozhan/index.html");
//        Game game4 = new Game(R.mipmap.ic_launcher,"虐心大冒险","http://tv.space-sh.com/games/nuexindamaoxian/index.html");
//        Game game5 = new Game(R.mipmap.ic_launcher,"圣诞美少女","http://tv.space-sh.com/games/santagirl/index.html");
//        Game game6 = new Game(R.mipmap.ic_launcher,"松鼠贪吃鬼","http://tv.space-sh.com/games/goingnuts/index.html");
//        Game game7 = new Game(R.mipmap.ic_launcher,"小红帽","http://tv.space-sh.com/games/redhat/index.html");
//        Game game8 = new Game(R.mipmap.ic_launcher,"星空对对碰","http://tv.space-sh.com/games/10smj/index.html");
//        Game game9 = new Game(R.mipmap.ic_launcher,"银河复仇者","https://tvs.space-sh.com/games/aircraft/index.html");
//        Game game10 = new Game(R.mipmap.ic_launcher,"3D跳一跳","http://tv.space-sh.com/games/3djump/index.html");
//        Game game11 = new Game(R.mipmap.ic_launcher,"兔子快跑","http://tv.space-sh.com/a5plus/rabbit/");
//        Game game12 = new Game(R.mipmap.ic_launcher,"熊猫大侠","http://tv.space-sh.com/games/panda/index.html");
//        Game game13 = new Game(R.mipmap.ic_launcher,"雪怪来啦","http://tv.space-sh.com/games/yetisensation/index.html");
//        Game game14 = new Game(R.mipmap.ic_launcher,"神秘墓地之夺宝奇兵","http://tv.space-sh.com/games/mudipaoku/index.html");
//        Game game15 = new Game(R.mipmap.ic_launcher,"桌面足球","http://tv.space-sh.com/games/zhuomianzuqiu/index.html");
//        gameList.add(game1);
//        gameList.add(game2);
//        gameList.add(game3);
//        gameList.add(game4);
//        gameList.add(game5);
//        gameList.add(game6);
//        gameList.add(game7);
//        gameList.add(game8);
//        gameList.add(game9);
//        gameList.add(game10);
//        gameList.add(game11);
//        gameList.add(game12);
//        gameList.add(game13);
//        gameList.add(game14);
//        gameList.add(game15);
//    }


    private void initView() {
//        button = (Button) findViewById(R.id.button);
//
//        button.setOnClickListener(this);
//
//        Log.d(TAG,"initView()");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //创建适配器
        GameAdapter adapter = new GameAdapter(gameList);
        recyclerView.setAdapter(adapter);
        final Intent intent = new Intent(this,SecondActivity.class);
        adapter.setOnItemClickListener(new GameAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"点击了一下"+position,Toast.LENGTH_SHORT).show();
                Game game = gameList.get(position);
                intent.putExtra("url",game.getGameUrl());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });


    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
////            case R.id.button:
////                startActivity(new Intent(this,BrowserActivity.class));
////                startActivity(new Intent(this, SecondActivity.class));
////                Log.d(TAG,"onClick()");
//                break;
//        }
    }

}

