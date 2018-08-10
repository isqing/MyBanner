package com.example.admin.mybanner.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.example.admin.mybanner.banner.BannerPageChangeListener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * create by yqli on 2018/8/10
 */
public class BannerViewPager extends ViewPager {
    private BannerHandler bannerHandler;
    private Timer mTimer;
    BannerPageChangeListener bannerPageChangeListener;
    public BannerViewPager(@NonNull Context context) {
        super(context);
        init(context);
    }

    public BannerViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init (Context context){
        bannerHandler = new BannerHandler(context);
        bannerPageChangeListener = new BannerPageChangeListener(this);
        addOnPageChangeListener(bannerPageChangeListener);
    }
    /**
     * 开启自动轮播
     *
     * @param period banner轮播的周期
     */
    public void startPlay(long period) {
        //banner的vp_views数量大于1时，才允许自动轮播
        int count = getAdapter().getCount();
        if (count > 1) {
            bannerHandler.sendEmptyMessage(1);
            mTimer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    bannerHandler.sendEmptyMessage(1);
                }
            };
            mTimer.schedule(timerTask, 3000, period);
        }
    }

    /**
     * 关闭自动轮播
     */
    public void stopPlay() {
        if (mTimer != null) {
            mTimer.cancel();
        }
    }

    private  class BannerHandler extends Handler {

        public BannerHandler(Context context) {
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
                //实现循环自动播放的效果
            int count = getAdapter().getCount();
            int mCurrPosition = (getCurrentItem() + 1);
                mCurrPosition = mCurrPosition % count;
                setCurrentItem(mCurrPosition);
        }
    }
}
