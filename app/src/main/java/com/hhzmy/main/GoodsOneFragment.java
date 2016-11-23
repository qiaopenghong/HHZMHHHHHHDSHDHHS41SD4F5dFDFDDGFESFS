package com.hhzmy.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiao on 2016/11/17.
 */
public class GoodsOneFragment extends Fragment{

    private NoScrollViewPager vp;
    private LinearLayout ll;
    private List<Fragment> folist;
    private List<TextView> goodsone_list=new ArrayList<TextView>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(),R.layout.goodsone_item,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ll = (LinearLayout) getView().findViewById(R.id.goodsone_ll);
        vp = (NoScrollViewPager) getView().findViewById(R.id.goodsone_vp);
        folist = new ArrayList<Fragment>();
        XgoodsFragmeng g1=new XgoodsFragmeng();
        XGoosoneFragment g2=new XGoosoneFragment();
        XGoodsTwoFragment g3=new XGoodsTwoFragment();
        folist.add(g1);
        folist.add(g2);
        folist.add(g3);
        for (int i = 0; i < ll.getChildCount(); i++) {
            TextView tv = (TextView) ll.getChildAt(i);
            final int num = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (TextView tv : goodsone_list) {
                        tv.setTextColor(Color.GREEN);
                    }
                    vp.setCurrentItem(num);
                }
            });
            goodsone_list.add(tv);
        }
        goodsone_list.get(0).setTextColor(Color.GREEN);
        vp.setAdapter(new GoodsOneAdapter(getChildFragmentManager(),folist));
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (TextView tv : goodsone_list) {
                    tv.setTextColor(Color.BLACK);
                }
                goodsone_list.get(position).setTextColor(Color.GREEN);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
