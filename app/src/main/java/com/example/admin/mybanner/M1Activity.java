package com.example.admin.mybanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.mybanner.banner.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

public class M1Activity extends AppCompatActivity {
    BannerViewPager vpBanner;
    List<Fragment> fragments;
    BannerPagerAdapter bannerPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);
        fragments = new ArrayList<>();
        vpBanner = (BannerViewPager) findViewById(R.id.vp_banner);
        ThreeFragment threeFragment1 = ThreeFragment.newInstance();
        fragments.add(threeFragment1);
        OneFragment oneFragment = OneFragment.newInstance();
        fragments.add(oneFragment);
        TwoFragment twoFragment = TwoFragment.newInstance();
        fragments.add(twoFragment);
        ThreeFragment threeFragment = ThreeFragment.newInstance();
        fragments.add(threeFragment);
        OneFragment oneFragment1= OneFragment.newInstance();
        fragments.add(oneFragment1);
        bannerPagerAdapter = new BannerPagerAdapter(getSupportFragmentManager(), fragments);
        vpBanner.setAdapter(bannerPagerAdapter);
        vpBanner.startPlay(3000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vpBanner.stopPlay();
    }
}