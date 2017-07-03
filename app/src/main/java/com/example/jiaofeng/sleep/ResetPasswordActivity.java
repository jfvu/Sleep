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

public class ResetPasswordActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_resetpassword)
    ImageView imgBackResetpassword;
    @BindView(R.id.et_resetword_resetpassword)
    EditText etResetwordResetpassword;
    @BindView(R.id.but_confirm_resetpassword)
    Button butConfirmResetpassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @OnClick({R.id.img_back_resetpassword, R.id.but_confirm_resetpassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_resetpassword:
                finish();
                break;
            case R.id.but_confirm_resetpassword:
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setClass(ResetPasswordActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
