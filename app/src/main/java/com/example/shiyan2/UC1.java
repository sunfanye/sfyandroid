package com.example.shiyan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.zip.Inflater;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class UC1 extends AppCompatActivity {
private Button button_h,button_l,button_v,button_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc1);
         button_h=(Button) findViewById(R.id.uc1_h_button);
         button_l=(Button)findViewById(R.id.uc1_l_button) ;
         button_v=(Button)findViewById(R.id.uc1_v_button);
         button_back=(Button)findViewById(R.id.uc1_back) ;
        ARouter.openLog();
        ARouter.openDebug();//由于ARouter会缓存，打开才能即使更新页面
        ARouter.init(getApplication());
        ButterKnife.bind(this);
        button_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotohlayout();
            }
        });

        button_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotollayout();
               // setContentView(R.layout.activity_uc1);
                //View view_l= View.inflate(UC1.this,R.layout.uc1_left_layout,null);

            }
        });
        button_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotovlayout();
                //setContentView(R.layout.activity_uc1);
               // View view_v= View.inflate(UC1.this,R.layout.activity_uc1,null);

            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

//以下是三个用于切换布局的方法
    public  void gotohlayout (){
        setContentView(R.layout.uc1_h_layout);
        button_h=(Button) findViewById(R.id.uc1_h_button);
        button_l=(Button) findViewById(R.id.uc1_l_button) ;
        button_v=(Button) findViewById(R.id.uc1_v_button);
        button_back=(Button)findViewById(R.id.uc1_back) ;

        //必须再加载布局，再findid，因为每次加载布局后id会丢失，而且布局加载要写在前面否则findid会出现空指针错误
        button_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotollayout();
            }
        });
        button_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotovlayout();

            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void gotollayout(){
        setContentView(R.layout.uc1_left_layout);
        button_h=(Button) findViewById(R.id.uc1_h_button);
        button_l=(Button)findViewById(R.id.uc1_l_button) ;
        button_v=(Button)findViewById(R.id.uc1_v_button);
        button_back=(Button)findViewById(R.id.uc1_back) ;


        button_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotohlayout();
            }
        });
        button_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotovlayout();
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void gotovlayout(){
        setContentView(R.layout.activity_uc1);
        button_h=(Button) findViewById(R.id.uc1_h_button);
        button_l=(Button)findViewById(R.id.uc1_l_button) ;
        button_v=(Button)findViewById(R.id.uc1_v_button);
        button_back=(Button)findViewById(R.id.uc1_back) ;

        button_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotohlayout();

            }
        });
        button_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotollayout();

            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

//    @OnClick(R.id.uc1_h_button)
//    void toUC1_hActivity(){
//        ARouter.getInstance().build("app/uc1_h").navigation();
//    }





}
