package com.example.admin.mybanner;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.mybanner.banner.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BannerViewPager vpBanner;
    List<Fragment> fragments;
    BannerPagerAdapter bannerPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = new ArrayList<>();
        vpBanner = (BannerViewPager) findViewById(R.id.vp_banner);
        ThreeFragment oneFragment4 = ThreeFragment.newInstance(30);
        fragments.add(oneFragment4);//把最后一个加到第一个
        OneFragment oneFragment = OneFragment.newInstance(0);
        fragments.add(oneFragment);
        TwoFragment twoFragment = TwoFragment.newInstance(0);
        fragments.add(twoFragment);
        ThreeFragment threeFragment = ThreeFragment.newInstance(0);
        fragments.add(threeFragment);
        OneFragment oneFragment0 = OneFragment.newInstance(05);
        fragments.add(oneFragment0);
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