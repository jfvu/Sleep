package com.example.jiaofeng.sleep;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.MusicAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jiaofeng on 2017/6/25.
 */

public class MusicActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_music)
    ImageView imgBackMusic;
    @BindView(R.id.tv_time1_music)
    TextView tvTime1Music;
    @BindView(R.id.pb_music)
    SeekBar pbMusic;
    @BindView(R.id.tv_time2_music)
    TextView tvTime2Music;
    @BindView(R.id.img_last_music)
    ImageView imgLastMusic;
    @BindView(R.id.img_play_music)
    ImageView imgPlayMusic;
    @BindView(R.id.img_next_music)
    ImageView imgNextMusic;
    @BindView(R.id.img_down_music)
    ImageView imgDownMusic;
    @BindView(R.id.rel_playlist_music)
    RelativeLayout relPlaylistMusic;
    @BindView(R.id.rv_music)
    RecyclerView rvMusic;
    private List<Music> list;
    private boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        relPlaylistMusic.getBackground().setAlpha(10);
        list = new ArrayList<>();
        Music music = new Music("静逸永恒的时光","（美家睡眠）","27：36");
        list.add(music);
        list.add(music);
        list.add(music);
        list.add(music);
        list.add(music);
        list.add(music);
        list.add(music);
        MusicAdapter adapter = new MusicAdapter(list,MusicActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMusic.setLayoutManager(layoutManager);
        //rvMusic.setHasFixedSize(true);
        rvMusic.setAdapter(adapter);
        pbMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_music, R.id.img_last_music, R.id.img_play_music, R.id.img_next_music, R.id.img_down_music})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_music:
                finish();
                break;

            case R.id.img_last_music:
                break;
            case R.id.img_play_music:
                if (!flag){
                    imgPlayMusic.setImageResource(R.mipmap.pause3x);
                    flag = true;
                }else {
                    imgPlayMusic.setImageResource(R.mipmap.play3x);
                    flag = false;
                }
                break;
            case R.id.img_next_music:
                break;
            case R.id.img_down_music:
                break;
        }
    }

    public class Music {
        private String name;
        private String vendor;
        private String duration;

        public String getName() {
            return name;
        }

        public String getVendor() {
            return vendor;
        }

        public String getDuration() {
            return duration;
        }

        public Music(String name, String vendor, String duration) {
            this.name = name;
            this.vendor = vendor;
            this.duration = duration;
        }
    }
}
