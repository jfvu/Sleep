package com.example.jiaofeng.sleep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class RegisterActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_register)
    ImageView imgBackRegister;
    @BindView(R.id.et_phonenumber_register)
    EditText etPhonenumberRegister;
    @BindView(R.id.but_getcode_register)
    Button butGetcodeRegister;
    @BindView(R.id.tv_deal_register)
    TextView tvDealRegister;
    private int flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        flag = getIntent().getIntExtra("flag",0);
    }

    @OnClick({R.id.img_back_register, R.id.but_getcode_register, R.id.tv_deal_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_register:
                finish();
                break;
            case R.id.but_getcode_register:
                Intent intent = new Intent(RegisterActivity.this,GetCodeActivity.class);
                intent.putExtra("flag",flag);
                startActivity(intent);
                break;
            case R.id.tv_deal_register:
                Intent intent1 = new Intent(RegisterActivity.this,DealActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
