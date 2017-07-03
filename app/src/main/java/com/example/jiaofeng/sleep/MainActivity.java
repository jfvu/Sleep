package com.example.jiaofeng.sleep;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import adapter.MyFregmentAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class MainActivity extends AutoLayoutActivity {
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.tab_main)
    TabLayout tabMain;
    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

    private static Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MyFregmentAdapter myFregmentAdapter = new MyFregmentAdapter(getSupportFragmentManager(),getApplication());

        vpMain.setAdapter(myFregmentAdapter);

        tabMain.setupWithViewPager(vpMain);
        /*tabMain.getTabAt(0).setText("睡眠");
        tabMain.getTabAt(1).setText("记录");
        tabMain.getTabAt(2).setText("亲友");
        tabMain.getTabAt(3).setText("我的");
        tabMain.getTabAt(0).setIcon(R.drawable.select_sleep);
        tabMain.getTabAt(1).setIcon(R.drawable.select_record);
        tabMain.getTabAt(2).setIcon(R.drawable.select_friend);
        tabMain.getTabAt(3).setIcon(R.drawable.select_my);*/

        tabMain.getTabAt(0).setCustomView(tab_icon("睡眠",R.drawable.select_sleep));
        tabMain.getTabAt(1).setCustomView(tab_icon("记录",R.drawable.select_record));
        tabMain.getTabAt(2).setCustomView(tab_icon("亲友",R.drawable.select_friend));
        tabMain.getTabAt(3).setCustomView(tab_icon("我的",R.drawable.select_my));
        tabMain.setTabTextColors(Color.parseColor("#A7A7A7"),Color.parseColor("#44366e"));
        tabMain.setTabGravity(TabLayout.GRAVITY_FILL);
        vpMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabMain));
        tabMain.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(vpMain));



    }
    private View tab_icon(String name,int icon){
        View view = LayoutInflater.from(this).inflate(R.layout.tablayout,null);
        TextView textView = (TextView) view.findViewById(R.id.tv_tab);
        textView.setText(name);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_tab);
        imageView.setImageResource(icon);
        return view;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ImmersionBar.with(this).destroy();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次后退键退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {


            this.finish();
        }
    }
}
