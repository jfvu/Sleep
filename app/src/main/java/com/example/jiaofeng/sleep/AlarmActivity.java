package com.example.jiaofeng.sleep;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.DateAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/26.
 */

public class AlarmActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_alarm)
    ImageView imgBackAlarm;
    @BindView(R.id.tv_finish_alarm)
    TextView tvFinishAlarm;
    @BindView(R.id.tb_alarm)
    ToggleButton tbAlarm;
    @BindView(R.id.tv_alarmtime_alarm)
    TextView tvAlarmtimeAlarm;
    @BindView(R.id.pb_volume_alarm)
    SeekBar pbVolumeAlarm;
    @BindView(R.id.tb_shake_alarm)
    ToggleButton tbShakeAlarm;
    @BindView(R.id.img_choosemusic_alarm)
    ImageView imgChoosemusicAlarm;
    @BindView(R.id.tv_musicname_alarm)
    TextView tvMusicnameAlarm;
    @BindView(R.id.tb_period_alarm)
    ToggleButton tbPeriodAlarm;
    @BindView(R.id.rv_date_alarm)
    RecyclerView rvDateAlarm;
    private List<Date> dates;
    private AudioManager am;
    private VolumeReceiver volumeReceiver;
    private DateAdapter adapter;
    private Vibrator vibrator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        dates = new ArrayList<>();
        dates.add(new Date("一",false));
        dates.add(new Date("二",false));
        dates.add(new Date("三",false));
        dates.add(new Date("四",false));
        dates.add(new Date("五",false));
        dates.add(new Date("六",false));
        dates.add(new Date("日",false));
        adapter = new DateAdapter(dates,AlarmActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvDateAlarm.setLayoutManager(linearLayoutManager);
        rvDateAlarm.setAdapter(adapter);
        volumeReceiver = new VolumeReceiver();
        IntentFilter filter = new IntentFilter() ;
        filter.addAction("android.media.VOLUME_CHANGED_ACTION") ;
        registerReceiver(volumeReceiver, filter) ;

        vibrator = (Vibrator) getApplication().getSystemService(Service.VIBRATOR_SERVICE);
        tbShakeAlarm.setChecked(vibrator.hasVibrator());
        tbShakeAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    vibrator.vibrate(new long[]{1000,50,50,100,50}, -1);
                    tbShakeAlarm.setChecked(true);
                }else {
                    vibrator.cancel();
                    tbShakeAlarm.setChecked(false);
                }
            }
        });

        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_ALARM);
        pbVolumeAlarm.setMax(maxVolume);
        int currentVolume = am.getStreamVolume(AudioManager.STREAM_ALARM);
        pbVolumeAlarm.setProgress(currentVolume);

        pbVolumeAlarm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    am.setStreamVolume(AudioManager.STREAM_ALARM,progress,0);
                int currentVolume = am.getStreamVolume(AudioManager.STREAM_ALARM);
                pbVolumeAlarm.setProgress(currentVolume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        tbPeriodAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
        unregisterReceiver(volumeReceiver);
    }

    @OnClick({R.id.img_back_alarm, R.id.tv_finish_alarm,R.id.img_choosemusic_alarm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_alarm:
                finish();
                break;
            case R.id.tv_finish_alarm:
                finish();
                break;
            case R.id.img_choosemusic_alarm:
                break;

        }
    }
    public class Date{
        private String date;
        private boolean choose;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public boolean isChoose() {
            return choose;
        }

        public void setChoose(boolean choose) {
            this.choose = choose;
        }

        public Date(String date, boolean choose) {
            this.date = date;
            this.choose = choose;
        }
    }
    private class VolumeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")){
                int currentVolume = am.getStreamVolume(AudioManager.STREAM_ALARM);
                pbVolumeAlarm.setProgress(currentVolume);
            }
        }
    }
    /**
     * 屏蔽系统自带的调节音量控件
     * @param event
     * @return
     */
    /*@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_DOWN) {
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_LOWER, 0);
        }else if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_UP) {
            am.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_RAISE, 0);
        }
        return true;
    }*/
}
