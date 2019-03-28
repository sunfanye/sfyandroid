package com.example.shiyan2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class UC3 extends AppCompatActivity {



    FrameLayout frame;
    int pic1[]={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5 };
    int currentImg = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc3);

        Button button =(Button) findViewById(R.id.uc3_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
           }
        });



        final ImageView image1=(ImageView)findViewById(R.id.pic1);

        frame=(FrameLayout)findViewById(R.id.frame) ;
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    image1.setImageResource(pic1[currentImg++]);
                    if(currentImg==5){
                        currentImg=0;
                    }
                    //也可以直接在帧布局更改背景
//                    Drawable a=getResources().getDrawable(pic1[currentImg++]);
//                    frame.setForeground(a);

                }
            }
        };


      Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Message message=new Message();
                message.what=0;
                handler.sendMessage(message);
            }
        },1000,2000);

    }
}
