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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.AddDeviceAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import view.PopWin;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class AddDeviceActivity extends AutoLayoutActivity {
    @BindView(R.id.img_back_adddevice)
    ImageView imgBackAdddevice;
    @BindView(R.id.tv_all_adddevice)
    TextView tvAllAdddevice;
    @BindView(R.id.lv_adddevice)
    ListView lvAdddevice;
    @BindView(R.id.img_add_adddevice)
    ImageView imgAddAdddevice;
    @BindView(R.id.rel_adddevice)
    RelativeLayout relAdddevice;
    private List<Device> lists;
    private AddDeviceAdapter adapter;
    private boolean flag = false;
    private PopWin popWin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddevice);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        relAdddevice.getBackground().setAlpha(5);
        lists = new ArrayList<>();
        Device device1 = new Device("枕头",false);
        Device device2 = new Device("床垫",false);
        Device device3 = new Device("沙发",false);
        Device device4 = new Device("桌子",false);
        Device device5 = new Device("房门",false);
        lists.add(device1);
        lists.add(device2);
        lists.add(device3);
        lists.add(device4);
        lists.add(device5);

        adapter = new AddDeviceAdapter(AddDeviceActivity.this,lists);
        lvAdddevice.setAdapter(adapter);
        lvAdddevice.setDivider(null);
        lvAdddevice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (lists.get(position).isCheck()){
                    lists.get(position).setCheck(false);
                }else {
                    lists.get(position).setCheck(true);
                }
                adapter.notifyDataSetChanged();
                for (int i = 0; i < lists.size(); i++) {
                    if (!lists.get(i).isCheck()){
                        tvAllAdddevice.setText("删除");
                        flag = true;
                    }else {
                        tvAllAdddevice.setText("全选");
                        flag = false;
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.img_back_adddevice, R.id.tv_all_adddevice, R.id.img_add_adddevice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_adddevice:
                finish();
                break;
            case R.id.tv_all_adddevice:

                if (flag){
                    finish();
                }else {
                    for (int i = 0; i < lists.size(); i++) {
                        lists.get(i).setCheck(true);
                    }
                    adapter.notifyDataSetChanged();
                    tvAllAdddevice.setText("删除");
                    flag = true;
                    relAdddevice.setVisibility(View.GONE);
                }

                break;
            case R.id.img_add_adddevice:
                popWin = new PopWin(this,onClickListener);
                popWin.showAtLocation(findViewById(R.id.ll_adddevice), Gravity.CENTER,0,0);
                break;
        }
    }
   public class Device{
        private String name;
        private boolean check;

        public Device(String name, boolean check) {
            this.name = name;
            this.check = check;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_cancel_pop:
                    popWin.dismiss();
                    break;
                case R.id.tv_sure_pop:
                    Intent intent = new Intent(AddDeviceActivity.this,BluetoothDeviceActivity.class);
                    startActivity(intent);
                    popWin.dismiss();
                    break;
            }
        }
    };
}
