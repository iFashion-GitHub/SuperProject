package com.avy.superproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.avy.haobai.HTTP;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 说明：
 * Created by leeqiuuu on 2019/7/9
 */
public class LoginActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.login);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        if(com.avy.haobai.MainActivity.token  == null){
            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jsonObject = new JSONObject();
//                    "woid","third_id_484"
                        try {
                            jsonObject.put("woid","third_id_484");
                            String url = com.avy.haobai.MainActivity.URL + "/v1/woapi/usertoken";

                            String data = HTTP.sendPOST(url,jsonObject.toString());
                            JSONObject jsonObject1 = new JSONObject(data);
                            JSONObject jsonObject2 = jsonObject1.getJSONObject("token_info");
                            com.avy.haobai.MainActivity.token = jsonObject2.getString("token");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
