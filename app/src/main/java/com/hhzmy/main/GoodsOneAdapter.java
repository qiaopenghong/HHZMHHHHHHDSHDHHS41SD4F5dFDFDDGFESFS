package com.hhzmy.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by qiao on 2016/11/17.
 */
public class GoodsOneAdapter extends FragmentPagerAdapter {
    private List<Fragment> folist;

    public GoodsOneAdapter(FragmentManager fm, List<Fragment> folist) {
        super(fm);
        this.folist = folist;
    }

    @Override
    public Fragment getItem(int position) {
        return folist.get(position);
    }

    @Override
    public int getCount() {
        return folist.size();
    }
}
