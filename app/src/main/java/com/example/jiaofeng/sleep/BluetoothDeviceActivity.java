package com.example.jiaofeng.sleep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import view.PopWin2;

/**
 * Created by jiaofeng on 2017/6/25.
 */

public class BluetoothDeviceActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_bluetoothdevice)
    ImageView imgBackBluetoothdevice;
    @BindView(R.id.img_seach4)
    ImageView imgSeach4;
    @BindView(R.id.img_seach3)
    ImageView imgSeach3;
    @BindView(R.id.img_seach2)
    ImageView imgSeach2;
    @BindView(R.id.img_seach1)
    ImageView imgSeach1;
    @BindView(R.id.img_seach_bluetoothdevice)
    ImageView imgSeachBluetoothdevice;
    @BindView(R.id.tv_stopseach_bluetoothdevice)
    TextView tvStopseachBluetoothdevice;
    @BindView(R.id.tv_hint_bluetoothdevice)
    TextView tvHintBluetoothdevice;
    private List<String> begin;
    private List<String> seach;
    private boolean flag = false;
    private CountDownTimer timer;
    private List<ImageView> imageViewList;
    private boolean isFlag = true;
    private PopWin2 popWin2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetoothdevice);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        begin = new ArrayList();
        begin.add("点击识别设备");
        begin.add("轻轻一点，识别您周围的智能家居");
        seach = new ArrayList();
        seach.add("点击停止识别设备");
        seach.add("正在识别您周围的智能家居并连接");
        tvHintBluetoothdevice.setText(begin.get(1));
        tvStopseachBluetoothdevice.setText(begin.get(0));
        imgSeach1.setVisibility(View.GONE);
        imgSeach2.setVisibility(View.GONE);
        imgSeach3.setVisibility(View.GONE);
        imgSeach4.setVisibility(View.GONE);
        imageViewList = new ArrayList<>();
        imageViewList.add(imgSeach4);
        imageViewList.add(imgSeach3);
        imageViewList.add(imgSeach2);
        imageViewList.add(imgSeach1);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_bluetoothdevice, R.id.img_seach_bluetoothdevice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_bluetoothdevice:
                finish();
                break;
            case R.id.img_seach_bluetoothdevice:
                if (flag){
                    tvStopseachBluetoothdevice.setText(begin.get(0));
                    tvHintBluetoothdevice.setText(begin.get(1));
                    flag = false;
                }else {
                    tvStopseachBluetoothdevice.setText(seach.get(0));
                    tvHintBluetoothdevice.setText(seach.get(1));
                    flag = true;

                        timer = new BluetoothDeviceActivity.BlueCountDownTime(4000,500);
                        timer.start();


                }

                break;
        }
    }
    class BlueCountDownTime extends CountDownTimer {
        public BlueCountDownTime(long millisInFutre,long countDownInterval){
            super(millisInFutre,countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            imageViewList.get((int) (millisUntilFinished/1000)).setVisibility(View.VISIBLE);
        }

        @Override
        public void onFinish() {
            imgSeach4.setVisibility(View.VISIBLE);

            imgSeach1.setVisibility(View.GONE);
            imgSeach2.setVisibility(View.GONE);
            imgSeach3.setVisibility(View.GONE);
            imgSeach4.setVisibility(View.GONE);
            popWin2 = new PopWin2(BluetoothDeviceActivity.this,onClickListener);
            popWin2.showAtLocation(findViewById(R.id.ll_bluetoothdevice), Gravity.CENTER,0,0);
        }
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_cancel_pop:
                    popWin2.dismiss();
                    break;
                case R.id.tv_sure_pop:
                    popWin2.dismiss();
                    finish();
                    break;
            }
        }
    };
}
