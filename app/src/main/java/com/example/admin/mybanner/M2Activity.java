package com.example.admin.mybanner;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.admin.mybanner.banner.BannerFragment;
import com.example.admin.mybanner.banner.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

public class M2Activity extends AppCompatActivity {
    BannerViewPager vpBanner;
    List<Fragment> fragments;
    BannerPagerAdapter bannerPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2);
        fragments = new ArrayList<>();
        vpBanner = (BannerViewPager) findViewById(R.id.vp_banner);
        BannerFragment b31=BannerFragment.newInstance(2,"kkkkkkkkkkkkkk");
        fragments.add(b31);
        BannerFragment b1=BannerFragment.newInstance(0,R.drawable.what_1);
        fragments.add(b1);
        String path= Environment.getExternalStorageDirectory().getPath()+"/Music/mv.mp4";
        Log.i("path==",path+"");
        BannerFragment b2=BannerFragment.newInstance(1,path);
        fragments.add(b2);
        BannerFragment b3=BannerFragment.newInstance(2,"kkkkkkkkkkkkkk");
        fragments.add(b3);
        BannerFragment b11=BannerFragment.newInstance(0,R.drawable.what_1);
        fragments.add(b11);
        bannerPagerAdapter = new BannerPagerAdapter(getSupportFragmentManager(), fragments);
        vpBanner.setAdapter(bannerPagerAdapter);
        vpBanner.startPlay(3000);
        vpBanner.setCurrentItem(1);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vpBanner.stopPlay();
    }
}