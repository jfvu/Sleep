package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiaofeng.sleep.ConcernActivity;
import com.example.jiaofeng.sleep.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import view.PopWin3;

/**
 * Created by jiaofeng on 2017/6/25.
 */

public class ConcernAdapter extends BaseAdapter{
    private Context context;
    private List<ConcernActivity.Friend> list;
    private PopWin3 popWin3;

    public ConcernAdapter(Context context, List<ConcernActivity.Friend> list) {
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        TextView textView;
        ImageView imageView;
        Button button;
        View view = null;
        if (convertView !=null){
            view = convertView;
        }else {
            view = View.inflate(context, R.layout.item_concernlistview,null);
        }
        AutoUtils.autoSize(view);
        button = (Button) view.findViewById(R.id.but_concernlistview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!list.get(position).isInvite()){

                    popWin3 = new PopWin3(context,onClickListener);
                    popWin3.showAtLocation(parent, Gravity.CENTER,0,0);
                }
            }
        });
        textView = (TextView) view.findViewById(R.id.tv_name_concernlistview);
        imageView = (ImageView) view.findViewById(R.id.img_head_concernlistview);
        textView.setText(list.get(position).getName());
        if (list.get(position).isInvite()){
            button.setBackgroundResource(R.mipmap.concern3x);
            button.setTextColor(Color.parseColor("#a9a4d5"));
            button.setText("已关注");
        }else {
            button.setBackgroundResource(R.mipmap.invite13x);
            button.setTextColor(Color.parseColor("#ffffff"));
            button.setText("邀请");
        }

        return view;
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_cancel_pop:
                    popWin3.dismiss();
                    break;
                case R.id.tv_sure_pop:
                    popWin3.dismiss();
                    break;
            }
        }
    };


}
