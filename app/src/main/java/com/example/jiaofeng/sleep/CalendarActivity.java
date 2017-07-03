package com.example.jiaofeng.sleep;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import view.MonthDateView;

/**
 * Created by Administrator on 2017/6/26.
 */

public class CalendarActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_calendar)
    ImageView imgBackCalendar;
    @BindView(R.id.img_last_calendar)
    TextView imgLastCalendar;
    @BindView(R.id.img_next_calendar)
    TextView imgNextCalendar;
    @BindView(R.id.tv_showdate_calendar)
    TextView tvShowdateCalendar;
    @BindView(R.id.mdv_calendar)
    MonthDateView mdvCalendar;
    @BindView(R.id.tv_showweek_calendar)
    TextView tvShowweekCalendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(12);
        list.add(15);
        list.add(16);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mdvCalendar.setTextView(tvShowdateCalendar,tvShowweekCalendar );
        mdvCalendar.setDaysHasThingList(list);
        mdvCalendar.setDateClick(new MonthDateView.DateClick() {
            @Override
            public void onClickOnDate() {
                Toast.makeText(CalendarActivity.this, "点击了"+mdvCalendar.getmSelDay(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_calendar, R.id.img_last_calendar, R.id.img_next_calendar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_calendar:
                finish();
                break;
            case R.id.img_last_calendar:
                mdvCalendar.onLeftClick();
                break;
            case R.id.img_next_calendar:
                mdvCalendar.onRightClick();
                break;
        }
    }
}
