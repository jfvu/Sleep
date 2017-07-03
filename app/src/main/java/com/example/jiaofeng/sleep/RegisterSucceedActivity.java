package com.example.jiaofeng.sleep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class RegisterSucceedActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_registersucceed)
    ImageView imgBackRegistersucceed;
    @BindView(R.id.et_user_registersucceed)
    EditText etUserRegistersucceed;
    @BindView(R.id.et_password_registersucceed)
    EditText etPasswordRegistersucceed;
    @BindView(R.id.but_registersucceed)
    Button butRegistersucceed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registersucceed);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_registersucceed, R.id.but_registersucceed})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_registersucceed:
                finish();
                break;
            case R.id.but_registersucceed:
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setClass(RegisterSucceedActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
