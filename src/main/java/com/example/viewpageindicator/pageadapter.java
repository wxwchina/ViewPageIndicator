package com.example.viewpageindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/5/26.
 */
public class pageadapter extends FragmentPagerAdapter {
    private int count;

    public pageadapter(FragmentManager fm,int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        return fragment1.NewInstant(++position+"");
    }

    @Override
    public int getCount() {
        return count;
    }
}
