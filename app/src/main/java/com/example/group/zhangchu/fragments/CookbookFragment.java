package com.example.group.zhangchu.fragments;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.group.zhangchu.R;
import com.example.group.zhangchu.common.BaseFragment;
import com.example.group.zhangchu.module.cookbook.CookbookClassifyFragment;
import com.example.group.zhangchu.module.cookbook.CookbookFoodMaterialFragment;
import com.example.group.zhangchu.module.cookbook.CookbookRecommendFragment;
import com.example.group.zhangchu.module.cookbook.adapter.CookbookViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CookbookFragment extends BaseFragment {

    @BindView(R.id.cookbook_tab_layout)
     TabLayout mTabLayout;

    @BindView(R.id.cookbook_view_pager)
     ViewPager mViewPager;

    private List<Fragment> mCookbookDatas;
    private Object mCookRecomeFragment;
    private FragmentManager mManager;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cookbook;
    }



    //在这初始化view
    @Override
    protected void initView(View ret) {

    }


    //在这初始化事件
    @Override
    protected void initEvent() {

    }

    //在这初始化数据
    @Override
    protected void initData() {

        mCookbookDatas = new ArrayList<>();

        mCookbookDatas.add(new CookbookRecommendFragment());
        mCookbookDatas.add(new CookbookFoodMaterialFragment());
        mCookbookDatas.add(new CookbookClassifyFragment());

        String[] tiltes = getActivity().getResources().getStringArray(R.array.cook_book_tab_title);

        mManager = getActivity().
                getSupportFragmentManager();

        FragmentPagerAdapter adapter = new CookbookViewPagerAdapter
                (mManager,mCookbookDatas,tiltes);

        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

    }


}
