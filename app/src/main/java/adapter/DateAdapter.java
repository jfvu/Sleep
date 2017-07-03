package adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiaofeng.sleep.AlarmActivity;
import com.example.jiaofeng.sleep.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by jiaofeng on 2017/6/26.
 */

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.MyViewHolder> {
    private List<AlarmActivity.Date> list;
    private Context context;

    public DateAdapter(List<AlarmActivity.Date> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public DateAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datarecycleview,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        AutoUtils.autoSize(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final DateAdapter.MyViewHolder holder, final int position) {

            holder.tvdate.setText(list.get(position).getDate());
          holder.tvdate.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (!list.get(position).isChoose()){
                      list.get(position).setChoose(true);
                      holder.tvdate.setTextColor(Color.parseColor("#A9A4D5"));
                  }else {
                      list.get(position).setChoose(false);
                      holder.tvdate.setTextColor(Color.parseColor("#bebebe"));
                  }
              }
          });



    }



    @Override
    public int getItemCount() {
        return list.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvdate;

        public MyViewHolder(View view){
            super(view);
            tvdate = (TextView) view.findViewById(R.id.tv_date);

        }
    }
}
