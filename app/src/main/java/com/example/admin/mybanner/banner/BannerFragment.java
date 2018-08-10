package com.example.admin.mybanner.banner;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.admin.mybanner.OneFragment;
import com.example.admin.mybanner.R;

/**
 * create by yqli on 2018/8/10
 */
public class BannerFragment extends Fragment {
    private final static String VIEWTYPE ="VIEWTYPE";
    private int viewType;//0 图片，1视频，2 文字
    private final static String VIEWRESOUSEID="VIEWRESOUSEID";
    private int viewResouceID;
    private final static String VIEWRESOUSESTR="VIEWRESOUSESTR";
    private String viewResouceStr;
    public final static int bannerImage=0;
    public final static int bannerVideoView=1;
    public final static int bannerTextView=2;
    private VideoView vv;
    ConstraintLayout cl;

    public static BannerFragment newInstance(int viewType,int viewResouceID) {
        BannerFragment fragment = new BannerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(VIEWTYPE, viewType);
        bundle.putInt(VIEWRESOUSEID,viewResouceID);
        fragment.setArguments(bundle);
        return fragment;
    }
    public static BannerFragment newInstance(int viewType,String viewResouceStr) {
        BannerFragment fragment = new BannerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(VIEWTYPE, viewType);
        bundle.putString(VIEWRESOUSESTR,viewResouceStr);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            viewType = getArguments().getInt(VIEWTYPE);
            viewResouceID=getArguments().getInt(VIEWRESOUSEID);
            viewResouceStr=getArguments().getString(VIEWRESOUSESTR);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_banner, container, false);
        cl=view.findViewById(R.id.cl);
        Context context=getContext();
        LinearLayout.LayoutParams layoutParams;
        layoutParams =new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        switch (viewType){
            case bannerImage:
                ImageView iv=new ImageView(context);
                cl.addView(iv,layoutParams);
                if (!TextUtils.isEmpty(viewResouceStr)){
                    Glide.with(context).load(viewResouceStr).into(iv);
                }
                if (viewResouceID!=0){
                    Glide.with(context).load(R.drawable.what_1).into(iv);
                }
                break;
            case bannerVideoView:
                vv = new VideoView(context);
                cl.addView(vv,layoutParams);
                if (!TextUtils.isEmpty(viewResouceStr)){
                  vv.setVideoPath(viewResouceStr);
                }
                break;
            case bannerTextView:
                TextView tv=new TextView(context);
                cl.addView(tv,layoutParams);
                if (!TextUtils.isEmpty(viewResouceStr)){
                    tv.setText(viewResouceStr);
                }
                break;
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (vv!=null){
            vv.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (vv!=null){
            vv.stopPlayback();
        }
    }
}
