package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.jiaofeng.sleep.CalendarActivity;
import com.example.jiaofeng.sleep.R;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class RecordFragment extends BaseFragment {
    @BindView(R.id.img_gotocalendar)
    ImageView imgGotocalendar;
    Unbinder unbinder;
    @BindView(R.id.img_1)
    ImageView img1;
    @BindView(R.id.rel_4)
    RelativeLayout rel4;
    @BindView(R.id.rel_2)
    RelativeLayout rel2;
    @BindView(R.id.rel_title3)
    RelativeLayout relTitle3;
    @BindView(R.id.rel_3)
    RelativeLayout rel3;
    @BindView(R.id.rel_title4)
    RelativeLayout relTitle4;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_record;
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

    @OnClick(R.id.img_gotocalendar)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), CalendarActivity.class));
    }
}
