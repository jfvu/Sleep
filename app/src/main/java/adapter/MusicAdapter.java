package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiaofeng.sleep.MusicActivity;
import com.example.jiaofeng.sleep.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by jiaofeng on 2017/6/26.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {
    private List<MusicActivity.Music> list;
    private Context context;

    public MusicAdapter(List<MusicActivity.Music> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MusicAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_musicrecycleview,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        AutoUtils.autoSize(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MusicAdapter.MyViewHolder holder, int position) {
        holder.tvname.setText(list.get(position).getName());
        holder.tvvendor.setText(list.get(position).getVendor());
        holder.tvduration.setText(list.get(position).getDuration());
        holder.relativeLayout.getBackground().setAlpha(5);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout relativeLayout;
        private TextView tvname;
        private TextView tvvendor;
        private TextView tvduration;
        public MyViewHolder(View view){
            super(view);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.rel_item_music);
            tvname = (TextView) view.findViewById(R.id.tv_name_music);
            tvvendor = (TextView) view.findViewById(R.id.tv_vendor_music);
            tvduration = (TextView) view.findViewById(R.id.tv_duration_music);
        }
    }
}
