package com.example.viewpageindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/26.
 */
public class fragment1 extends Fragment{

    public static fragment1 NewInstant(String title){
        Bundle bundle = new Bundle();
        bundle.putString("title", title);

        fragment1 fragment = new fragment1();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.fragmetn1, null);
        TextView textView = (TextView) view.findViewById(R.id.text1);
        textView.setText("内容"+bundle.getString("title"));

        return view;
    }
}
