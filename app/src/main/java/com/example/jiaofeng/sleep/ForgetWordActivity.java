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

public class ForgetWordActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_forgetword)
    ImageView imgBackForgetword;
    @BindView(R.id.et_phonenumber_forgetword)
    EditText etPhonenumberForgetword;
    @BindView(R.id.but_getcode)
    Button butGetcode;
    private int flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetword);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        flag = getIntent().getIntExtra("flag",0);
    }

    @OnClick({R.id.img_back_forgetword, R.id.but_getcode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_forgetword:
                finish();
                break;
            case R.id.but_getcode:
                Intent intent = new Intent(ForgetWordActivity.this,GetCodeActivity.class);
                intent.putExtra("flag",flag);
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
