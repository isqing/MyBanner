package com.example.admin.mybanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class TwoFragment extends Fragment {

    ImageView iv;
    int i;

    public TwoFragment() {
        // Required empty public constructor
    }
    public static TwoFragment newInstance(int i) {
        TwoFragment fragment = new TwoFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("num",i);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            i=getArguments().getInt("num");
            Log.i("num",i+"");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_one, container, false);
        iv=view.findViewById(R.id.iv);
        iv.setBackgroundResource(R.drawable.what_2);
        return view;
    }

}
