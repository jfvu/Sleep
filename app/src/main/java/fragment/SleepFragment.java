package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.sleep.AlarmActivity;
import com.example.jiaofeng.sleep.MusicActivity;
import com.example.jiaofeng.sleep.R;
import com.gyf.barlibrary.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import adapter.TimeAdapter;
import view.PopWin4;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class SleepFragment extends BaseFragment {
private ImageView imgMusic;
    private ImageView imgAlarm;
    private RecyclerView rvTime;
    private List<Times> list;
    private TextView tvShowscore;
    private PopWin4 popWin4;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sleep;
    }

    @Override
    protected void initView(final View view, Bundle savedInstanceState) {
        ImmersionBar.with(this).init();
        imgMusic = (ImageView) view.findViewById(R.id.img_music_sleepfragment);
        imgMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MusicActivity.class));
            }
        });
        imgAlarm = (ImageView) view.findViewById(R.id.img_clock_sleepfragment);
        imgAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AlarmActivity.class));
            }
        });
        list = new ArrayList<>();
        list.add(new Times("0"));
        list.add(new Times("1"));
        list.add(new Times("2"));
        list.add(new Times("3"));
        list.add(new Times("4"));
        list.add(new Times("5"));
        list.add(new Times("6"));
        list.add(new Times("7"));

        rvTime = (RecyclerView) view.findViewById(R.id.rv_time_sleepfragment);
        TimeAdapter timeAdapter = new TimeAdapter(list,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvTime.setLayoutManager(linearLayoutManager);
        rvTime.setAdapter(timeAdapter);

        tvShowscore = (TextView) view.findViewById(R.id.tv_score_sleepfragment);
        tvShowscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWin4 = new PopWin4(getActivity(),onClickListener);
                popWin4.showAtLocation(view.findViewById(R.id.ll_sleep), Gravity.CENTER,0,0);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ImmersionBar.with(this).destroy();
    }
    public class Times{
        private String time;

        public Times(String time) {
            this.time = time;
        }

        public String getTime() {
            return time;
        }
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_cancel_pop:
                    popWin4.dismiss();
                    break;
                case R.id.tv_sure_pop:
                    Intent intent = new Intent(getActivity(),AlarmActivity.class);
                    startActivity(intent);
                    popWin4.dismiss();
                    break;
            }
        }
    };
}
