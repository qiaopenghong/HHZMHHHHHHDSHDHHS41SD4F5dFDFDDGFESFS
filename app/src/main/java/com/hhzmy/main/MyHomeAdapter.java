package com.hhzmy.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hhzmy.main.com.hhzmy.bean.Data;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by qiao on 2016/11/14.
 */
public class MyHomeAdapter extends PagerAdapter {
    List<Data.DataBean> d;
    Context context;
    public MyHomeAdapter(Context context, List<Data.DataBean> d) {
        this.d = d;
        this.context = context;
    }
    @Override
    public int getCount() {

        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container,final int position) {
        View view = View.inflate(context, R.layout.home_page_vp, null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(0).getTag().get(position % d.get(0).getTag().size()).getPicUrl(), iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,WebViewActivity.class);
                intent.putExtra("jump",d.get(0).getTag().get(position%d.get(0).getTag().size()).getLinkUrl());
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
