package com.example.admin.mybanner.banner;

import android.support.v4.view.ViewPager;
import android.util.Log;

/**
 * create by yqli on 2018/8/9
 */
public class BannerPageChangeListener implements ViewPager.OnPageChangeListener {

    private int currentPosition;
    private ViewPager viewPager;

    public BannerPageChangeListener( ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == ViewPager.SCROLL_STATE_IDLE) {
//            Log.i("currentPosition===",currentPosition+","+(viewPager.getAdapter().getCount() - 1));
            if (currentPosition == viewPager.getAdapter().getCount() - 1) {
                viewPager.setCurrentItem(1, false);
                Log.i("currentPosition==1",currentPosition+"");
            }
            else if (currentPosition == 0) {
                viewPager.setCurrentItem(viewPager.getAdapter().getCount() - 2, false);
                Log.i("currentPosition==2",currentPosition+"");
            }
        }
    }

    @Override
    public void onPageScrolled(int scrolledPosition, float percent, int pixels) {
        //empty
//        if (scrolledPosition == 0 && pixels == 0)
//            viewPager.setCurrentItem(viewPager.getAdapter().getCount() - 2, false);
//        else if (scrolledPosition == viewPager.getAdapter().getCount() - 1 && pixels == 0)
//            viewPager.setCurrentItem(1, false);
    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;
        Log.i("currentPosition==3",currentPosition+"");
    }

}
