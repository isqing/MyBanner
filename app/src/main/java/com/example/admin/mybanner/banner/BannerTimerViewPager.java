package com.example.admin.mybanner.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * create by yqli on 2018/8/10
 */
public class BannerTimerViewPager extends ViewPager {
    private BannerHandler bannerHandler;
    private Timer mTimer;
    private List<Integer> mTimers;
    BannerPageChangeListener bannerPageChangeListener;

    public BannerTimerViewPager(@NonNull Context context) {
        super(context);
        init(context);
    }

    public BannerTimerViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mTimers = new ArrayList<>();
        bannerHandler = new BannerHandler(context);
        bannerPageChangeListener = new BannerPageChangeListener(this);
        addOnPageChangeListener(bannerPageChangeListener);
    }

    /**
     * 开启自动轮播
     *
     * @param
     */
    public void startPlay() {
        //banner的vp_views数量大于1时，才允许自动轮播
        int count = getAdapter().getCount();
        if (count > 1) {
            bannerHandler.sendEmptyMessageDelayed(1, 0);
//            bannerHandler.sendEmptyMessage(1);
//            mTimer = new Timer();
//            TimerTask timerTask = new TimerTask() {
//                @Override
//                public void run() {
//                    bannerHandler.sendEmptyMessage(1);
//                }
//            };
//            mTimer.schedule(timerTask, 3000, period);
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

    private class BannerHandler extends Handler {

        public BannerHandler(Context context) {
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //实现循环自动播放的效果
            int count = getAdapter().getCount();
            int mCurrPosition = getCurrentItem();
            mCurrPosition = (mCurrPosition % (count - 1)) + 1;
            setCurrentItem(mCurrPosition);
            if (mTimers != null && mTimers.size() > 0) {
                bannerHandler.sendEmptyMessageDelayed(1, mTimers.get(getCurrentItem()));
            } else {
                bannerHandler.sendEmptyMessageDelayed(1, 3000);
            }
        }
    }

    public void setmTimers(List<Integer> mTimers) {
        this.mTimers = mTimers;
    }
}
