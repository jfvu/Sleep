package com.example.jiaofeng.sleep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.ConcernAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import view.PopWin3;

/**
 * Created by jiaofeng on 2017/6/25.
 */

public class ConcernActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_concern)
    ImageView imgBackConcern;
    @BindView(R.id.lv_concern)
    ListView lvConcern;
    private List<Friend> list;
    private PopWin3 popWin3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concern);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        list = new ArrayList<>();
        Friend friend = new Friend("小仙女",R.mipmap.head3x,false);
        Friend friend1 = new Friend("小仙女",R.mipmap.head3x,true);
        list.add(friend);
        list.add(friend1);
        list.add(friend);
        list.add(friend);
        list.add(friend);
        list.add(friend1);

        ConcernAdapter adapter = new ConcernAdapter(ConcernActivity.this,list);
        lvConcern.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_concern})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_concern:
                finish();
                break;
        }
    }
    public class Friend{
        private String name;
        private int head;
        private boolean invite;

        public Friend(String name, int head, boolean invite) {
            this.name = name;
            this.head = head;
            this.invite = invite;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHead() {
            return head;
        }

        public void setHead(int head) {
            this.head = head;
        }

        public boolean isInvite() {
            return invite;
        }

        public void setInvite(boolean invite) {
            this.invite = invite;
        }
    }

}
