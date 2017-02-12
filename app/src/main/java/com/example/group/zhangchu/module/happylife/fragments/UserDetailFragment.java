package com.example.group.zhangchu.module.happylife.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group.zhangchu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailFragment extends Fragment {


    public UserDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_detail, container, false);



        return ret;
    }

}
