package com.example.admin.mybanner;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * create by yqli on 2018/8/8
 */
public class BannerPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;

    public BannerPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public BannerPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
