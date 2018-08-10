package com.example.admin.mybanner;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.admin.mybanner.banner.BannerFragment;
import com.example.admin.mybanner.banner.BannerTimerViewPager;
import com.example.admin.mybanner.banner.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

public class M2Activity extends AppCompatActivity {
    BannerTimerViewPager vpBanner;
    List<Fragment> fragments;
    BannerPagerAdapter bannerPagerAdapter;
    private List<Integer> mTimers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2);
        fragments = new ArrayList<>();
        vpBanner = (BannerTimerViewPager) findViewById(R.id.vp_banner);
        mTimers=new ArrayList<>();//自定义每个轮播的时间，注意第一个和最后一个
        mTimers.add(5000);//最后一个
        mTimers.add(3000);
        mTimers.add(1000);
        mTimers.add(5000);
        mTimers.add(3000);//第一个
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
        vpBanner.setmTimers(mTimers);
        vpBanner.startPlay();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vpBanner.stopPlay();
    }
}