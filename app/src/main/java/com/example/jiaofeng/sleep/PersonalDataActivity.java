package com.example.jiaofeng.sleep;

import android.app.DatePickerDialog;
import android.content.pm.ActivityInfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class PersonalDataActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_personaldata)
    ImageView imgBackPersonaldata;
    @BindView(R.id.img_headnext_personaldata)
    ImageView imgHeadnextPersonaldata;
    @BindView(R.id.img_namenext_personaldata)
    ImageView imgNamenextPersonaldata;
    @BindView(R.id.tv_name_personaldata)
    TextView tvNamePersonaldata;
    @BindView(R.id.img_sexnext_personaldata)
    ImageView imgSexnextPersonaldata;
    @BindView(R.id.tv_sex_personaldata)
    TextView tvSexPersonaldata;
    @BindView(R.id.img_birthdaynext_personaldata)
    ImageView imgBirthdaynextPersonaldata;
    @BindView(R.id.tv_birthday_personaldata)
    TextView tvBirthdayPersonaldata;
    @BindView(R.id.img_educationnext_personaldata)
    ImageView imgEducationnextPersonaldata;
    @BindView(R.id.tv_education_personaldata)
    TextView tvEducationPersonaldata;
    @BindView(R.id.img_areanext_personaldata)
    ImageView imgAreanextPersonaldata;
    @BindView(R.id.tv_area_personaldata)
    TextView tvAreaPersonaldata;
    @BindView(R.id.img_businessnext_personaldata)
    ImageView imgBusinessnextPersonaldata;
    @BindView(R.id.tv_business_personaldata)
    TextView tvBusinessPersonaldata;
    private int mYear;
    private int mMonth;
    private int mDay;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldata);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_personaldata, R.id.img_headnext_personaldata, R.id.img_namenext_personaldata, R.id.img_sexnext_personaldata, R.id.img_birthdaynext_personaldata, R.id.img_educationnext_personaldata, R.id.img_areanext_personaldata, R.id.img_businessnext_personaldata})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_personaldata:
                finish();
                break;
            case R.id.img_headnext_personaldata:
                break;
            case R.id.img_namenext_personaldata:
                break;
            case R.id.img_sexnext_personaldata:
                break;
            case R.id.img_birthdaynext_personaldata:
                Calendar calendar = Calendar.getInstance();
                mYear = calendar.get(Calendar.YEAR);
                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(PersonalDataActivity.this,onDateSetListener,mYear,mMonth,mDay).show();
                break;
            case R.id.img_educationnext_personaldata:
                break;
            case R.id.img_areanext_personaldata:
                break;
            case R.id.img_businessnext_personaldata:
                break;
        }
    }
    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear = year;
            mMonth = month;
            mDay = dayOfMonth;
            String days;
            if (mMonth + 1 < 10) {
                if (mDay < 10) {
                    days = new StringBuffer().append(mYear).append("年").append("0").
                            append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                } else {
                    days = new StringBuffer().append(mYear).append("年").append("0").
                            append(mMonth + 1).append("月").append(mDay).append("日").toString();
                }

            } else {
                if (mDay < 10) {
                    days = new StringBuffer().append(mYear).append("年").
                            append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                } else {
                    days = new StringBuffer().append(mYear).append("年").
                            append(mMonth + 1).append("月").append(mDay).append("日").toString();
                }

            }
            tvBirthdayPersonaldata.setText(days);

        }
    };
}
