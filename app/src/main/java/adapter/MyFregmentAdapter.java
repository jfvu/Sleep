package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.BaseFragment;
import fragment.FragmentFactory;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class MyFregmentAdapter extends FragmentPagerAdapter {
    private Context context;

    public MyFregmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment baseFragment = FragmentFactory.createFragment(position);
        return baseFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
