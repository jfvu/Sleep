package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiaofeng.sleep.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import fragment.SleepFragment;

/**
 * Created by jiaofeng on 2017/6/26.
 */

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.MyViewHolder> {
    private List<SleepFragment.Times> list;
    private Context context;

    public TimeAdapter(List<SleepFragment.Times> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TimeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time_sleeprecycyleview,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        AutoUtils.autoSize(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final TimeAdapter.MyViewHolder holder, final int position) {

            holder.tvdate.setText(list.get(position).getTime());




    }



    @Override
    public int getItemCount() {
        return list.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvdate;

        public MyViewHolder(View view){
            super(view);
            tvdate = (TextView) view.findViewById(R.id.tv_time_sleep);

        }
    }
}
