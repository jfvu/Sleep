package fragment;

import java.util.HashMap;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class FragmentFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new SleepFragment();
                    break;
                case 1:
                    baseFragment = new RecordFragment();
                    break;
                case 2:
                    baseFragment = new FriendFragment();
                    break;
                case 3:
                    baseFragment = new MyFragment();
                    break;
                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }

}
