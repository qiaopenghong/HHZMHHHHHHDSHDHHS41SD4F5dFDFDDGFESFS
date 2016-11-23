package com.hhzmy.main.com.hhzmy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hhzmy.main.R;
import com.hhzmy.main.com.hhzmy.bean.Data;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;
/**
 * Created by qiao on 2016/11/16.
 */
public class HomeTwoAdapter extends RecyclerView.Adapter<HomeTwoAdapter.MyViewHolder> {
    private List<Data.DataBean.TagBean> d;
    private Context context;
    public HomeTwoAdapter(Context context, List<Data.DataBean.TagBean> d) {
        this.context=context;
        this.d = d;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder2 = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.home_item2, parent,
                false));
        return holder2;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder2,int position) {
        ImageLoader.getInstance().displayImage("http://image1.suning.cn"+d.get(position).getPicUrl(), holder2.iv);
    }

    @Override
    public int getItemCount() {
        return d.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        public MyViewHolder(View view) {
            super(view);
            iv = (ImageView) view.findViewById(R.id.h_iv_one);
        }
    }
}