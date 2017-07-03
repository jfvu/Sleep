package com.example.jiaofeng.sleep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
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

public class GetCodeActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_getcode)
    ImageView imgBackGetcode;
    @BindView(R.id.et_inputword_getcode)
    EditText etInputwordGetcode;
    @BindView(R.id.but_getcode_getcode)
    Button butGetcodeGetcode;
    @BindView(R.id.but_next_getcode)
    Button butNextGetcode;
    private CountDownTimer timer;
    private int flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getcode);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        timer = new CountDownTime(60000,1000);
        flag = getIntent().getIntExtra("flag",0);

    }

    @Override
    protected void onResume() {
        super.onResume();
        timer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_getcode, R.id.but_getcode_getcode, R.id.but_next_getcode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_getcode:
                finish();
                break;
            case R.id.but_getcode_getcode:
                timer.start();
                break;
            case R.id.but_next_getcode:
                if (flag == 1){
                    Intent intent = new Intent(GetCodeActivity.this,RegisterSucceedActivity.class);
                    startActivity(intent);
                }else if(flag == 2){
                Intent intent = new Intent(GetCodeActivity.this,ResetPasswordActivity.class);
                startActivity(intent);}
                break;
        }
    }
    class CountDownTime extends CountDownTimer{
        public CountDownTime(long millisInFutre,long countDownInterval){
            super(millisInFutre,countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            butGetcodeGetcode.setClickable(false);
            butGetcodeGetcode.setText(millisUntilFinished/1000 + "秒后重新获取");
        }

        @Override
        public void onFinish() {
            butGetcodeGetcode.setClickable(true);
            butGetcodeGetcode.setText("重新获取");
        }
    }
}
