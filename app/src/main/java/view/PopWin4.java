package view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiaofeng.sleep.R;

/**
 * Created by jiaofeng on 2017/6/25.
 */

public class PopWin4 extends PopupWindow {
    private Context context;
    private View view;
    private TextView tv1,tv2;
    private ImageView imglogo;
    private TextView tvshow;

    public PopWin4(Context context, View.OnClickListener onClickListener){
        this.view = LayoutInflater.from(context).inflate(R.layout.popwin2,null);

        tv1 = (TextView) view.findViewById(R.id.tv_cancel_pop);
        tv2 = (TextView) view.findViewById(R.id.tv_sure_pop);
        imglogo = (ImageView) view.findViewById(R.id.img_logo_pop);
        tvshow = (TextView) view.findViewById(R.id.tv_showtitle_pop);
        imglogo.setImageResource(R.mipmap.popuplogo3x);
        tvshow.setText("睡眠时间到了，是否立即进入设置");


        tv1.setOnClickListener(onClickListener);
        tv2.setOnClickListener(onClickListener);

        this.setOutsideTouchable(false);

        this.setContentView(this.view);
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setFocusable(false);

        ColorDrawable drawable = new ColorDrawable(00000);
        this.setBackgroundDrawable(drawable);

    }
}
