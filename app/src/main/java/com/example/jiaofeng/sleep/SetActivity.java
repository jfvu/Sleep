package com.example.jiaofeng.sleep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.CacheDataManager;

/**
 * Created by jiaofeng on 2017/6/25.
 */

public class SetActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_set)
    ImageView imgBackSet;
    @BindView(R.id.tv_showclear_set)
    TextView tvShowclearSet;
    @BindView(R.id.rel_clear_set)
    RelativeLayout relClearSet;
    @BindView(R.id.img_about_set)
    ImageView imgAboutSet;
    @BindView(R.id.rel_exit_set)
    RelativeLayout relExitSet;

    private Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {

                case 0:

                    Toast.makeText(SetActivity.this,"清理完成",Toast.LENGTH_SHORT).show();

                    try {

                        tvShowclearSet.setText(CacheDataManager.getTotalCacheSize(SetActivity.this));

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

            }

        };

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        try {
            tvShowclearSet.setText(CacheDataManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_set, R.id.rel_clear_set, R.id.img_about_set, R.id.rel_exit_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_set:
                finish();
                break;
            case R.id.rel_clear_set:
                new Thread(new clearCache()).start();
                break;
            case R.id.img_about_set:
                Intent intent = new Intent(SetActivity.this,AboutActivityy.class);
                startActivity(intent);
                break;
            case R.id.rel_exit_set:
                Intent intent1 = new Intent();
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.setClass(SetActivity.this,LoginActivity.class);
                startActivity(intent1);
                break;
        }
    }
    class clearCache implements Runnable {

        @Override

        public void run() {

            try {

                CacheDataManager.clearAllCache(SetActivity.this);

                Thread.sleep(3000);

                if (CacheDataManager.getTotalCacheSize(SetActivity.this).startsWith("0")) {

                    handler.sendEmptyMessage(0);

                }

            } catch (Exception e) {

                return;

            }

        }

    }
}
