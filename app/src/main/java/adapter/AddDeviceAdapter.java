package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiaofeng.sleep.AddDeviceActivity;
import com.example.jiaofeng.sleep.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by jiaofeng on 2017/6/25.
 */

public class AddDeviceAdapter extends BaseAdapter {
    private Context context;
    private List<AddDeviceActivity.Device> list;

    public AddDeviceAdapter(Context context, List<AddDeviceActivity.Device> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout relativeLayout;
        TextView textView;
        ImageView imageView;
        View view = null;
        if (convertView !=null){
            view = convertView;
        }else {
            view = View.inflate(context, R.layout.item_adddevicelistview,null);
        }
        AutoUtils.autoSize(view);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.rel_listview);
        textView = (TextView) view.findViewById(R.id.tv_name_listview);
        imageView = (ImageView) view.findViewById(R.id.img_check_listview);
        textView.setText(list.get(position).getName());
        relativeLayout.getBackground().setAlpha(5);
        if (list.get(position).isCheck()){
            imageView.setImageResource(R.mipmap.select3x);
        }else {
            imageView.setImageResource(R.mipmap.unselect3x);
        }

        return view;
    }

}
