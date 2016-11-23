package com.hhzmy.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by qiao on 2016/11/17.
 */
public class GoodsAdapter extends FragmentPagerAdapter{
    private List<Fragment> title;
    public GoodsAdapter(Context context, FragmentManager fm, List<Fragment> title) {
        super(fm);
        this.title = title;
    }
    @Override
    public Fragment getItem(int position) {
        return title.get(position);
    }
    @Override
    public int getCount() {

        return title.size();
    }
}
