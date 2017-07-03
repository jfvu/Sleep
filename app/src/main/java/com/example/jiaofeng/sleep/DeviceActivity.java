package com.example.jiaofeng.sleep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class DeviceActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_device)
    ImageView imgBackDevice;
    @BindView(R.id.tv_edit_device)
    TextView tvEditDevice;
    @BindView(R.id.img1_devicecheck_device)
    ImageView img1DevicecheckDevice;
    @BindView(R.id.rel1_device)
    RelativeLayout rel1Device;
    @BindView(R.id.img2_devicecheck_device)
    ImageView img2DevicecheckDevice;
    @BindView(R.id.rel2_device)
    RelativeLayout rel2Device;
    @BindView(R.id.img3_devicecheck_device)
    ImageView img3DevicecheckDevice;
    @BindView(R.id.rel3_device)
    RelativeLayout rel3Device;
    @BindView(R.id.img4_devicecheck_device)
    ImageView img4DevicecheckDevice;
    @BindView(R.id.rel4_device)
    RelativeLayout rel4Device;
    private boolean pillowCheck = false;
    private boolean mattessCheck = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        rel1Device.getBackground().setAlpha(5);
        rel2Device.getBackground().setAlpha(5);
        rel3Device.getBackground().setAlpha(5);
        rel4Device.getBackground().setAlpha(5);

        if (pillowCheck){
            img1DevicecheckDevice.setImageResource(R.mipmap.check3x);
        }else {
            img1DevicecheckDevice.setImageResource(R.mipmap.uncheck3x);
        }
        if (mattessCheck){
            img2DevicecheckDevice.setImageResource(R.mipmap.check3x);
        }else {
            img2DevicecheckDevice.setImageResource(R.mipmap.uncheck3x);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_device, R.id.tv_edit_device, R.id.img1_devicecheck_device, R.id.img2_devicecheck_device, R.id.img3_devicecheck_device, R.id.img4_devicecheck_device})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_device:
                finish();
                break;
            case R.id.tv_edit_device:
                Intent intent = new Intent(DeviceActivity.this,AddDeviceActivity.class);
                startActivity(intent);
                break;
            case R.id.img1_devicecheck_device:
                if (pillowCheck){
                    pillowCheck = false;
                    img1DevicecheckDevice.setImageResource(R.mipmap.uncheck3x);
                }else {
                    pillowCheck = true;
                    img1DevicecheckDevice.setImageResource(R.mipmap.check3x);
                }
                break;
            case R.id.img2_devicecheck_device:
                if (mattessCheck){
                    pillowCheck = false;
                    img2DevicecheckDevice.setImageResource(R.mipmap.uncheck3x);
                }else {
                    mattessCheck = true;
                    img2DevicecheckDevice.setImageResource(R.mipmap.check3x);
                }
                break;
            case R.id.img3_devicecheck_device:
                break;
            case R.id.img4_devicecheck_device:
                break;
        }
    }
}
