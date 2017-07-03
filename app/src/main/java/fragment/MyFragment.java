package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.sleep.ConcernActivity;
import com.example.jiaofeng.sleep.DeviceActivity;
import com.example.jiaofeng.sleep.HelpActivity;
import com.example.jiaofeng.sleep.IntroductionActivity;
import com.example.jiaofeng.sleep.PersonalDataActivity;
import com.example.jiaofeng.sleep.R;
import com.example.jiaofeng.sleep.SetActivity;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.img_head_myfragment)
    ImageView imgHeadMyfragment;
    @BindView(R.id.tv_name_myfragment)
    TextView tvNameMyfragment;
    @BindView(R.id.img_devicenext_myfragment)
    ImageView imgDevicenextMyfragment;
    @BindView(R.id.tv_devicenumber_myfragment)
    TextView tvDevicenumberMyfragment;
    @BindView(R.id.img_helpnext_myfragment)
    ImageView imgHelpnextMyfragment;
    @BindView(R.id.img_introducenext_myfragment)
    ImageView imgIntroducenextMyfragment;
    @BindView(R.id.img_invitenext_myfragment)
    ImageView imgInvitenextMyfragment;
    @BindView(R.id.img_setnext_myfragment)
    ImageView imgSetnextMyfragment;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ImmersionBar.with(this).init();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ImmersionBar.with(this).destroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.img_head_myfragment, R.id.img_devicenext_myfragment, R.id.img_helpnext_myfragment, R.id.img_introducenext_myfragment, R.id.img_invitenext_myfragment, R.id.img_setnext_myfragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_head_myfragment:
                Intent intent = new Intent(getActivity(), PersonalDataActivity.class);
                startActivity(intent);
                break;
            case R.id.img_devicenext_myfragment:
                Intent intent1 = new Intent(getActivity(), DeviceActivity.class);
                startActivity(intent1);
                break;
            case R.id.img_helpnext_myfragment:
                Intent intent2 = new Intent(getActivity(), HelpActivity.class);
                startActivity(intent2);
                break;
            case R.id.img_introducenext_myfragment:
                Intent intent3 = new Intent(getActivity(), IntroductionActivity.class);
                startActivity(intent3);
                break;
            case R.id.img_invitenext_myfragment:
                Intent intent4 = new Intent(getActivity(), ConcernActivity.class);
                startActivity(intent4);
                break;
            case R.id.img_setnext_myfragment:
                Intent intent5 = new Intent(getActivity(), SetActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
