package com.example.group.zhangchu.module.cookbook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group.zhangchu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CookbookFoodMaterialFragment extends Fragment {



    public CookbookFoodMaterialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_cookbook_food_material, container, false);

        initView(ret);

        initData();

//        initRecyclerView();

        return ret;
    }

    private void initData() {



    }

    private void initRecyclerView() {

        //一定要写下面两句

    }

    private void initView(View ret) {


    }

}
