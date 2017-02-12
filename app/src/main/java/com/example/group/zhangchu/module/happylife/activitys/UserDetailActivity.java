package com.example.group.zhangchu.module.happylife.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.group.zhangchu.R;
import com.example.group.zhangchu.module.happylife.adapter.MyPagerAdapter;
import com.example.group.zhangchu.module.happylife.fragments.UserDetailFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailActivity extends AppCompatActivity {


    @BindView(R.id.happyLife_tab_layout)
    TabLayout mHappyLifeTabLayout;
    @BindView(R.id.happyLife_view_pager)
    ViewPager mHappyLifeViewPager;
    private List<Fragment> mFragmentList;
    private FragmentPagerAdapter adapter;
    private List<String> tabName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy_life_detail);
        ButterKnife.bind(this);
        initTabLayout();
        initViewPager();
    }


    private void initViewPager() {
        mFragmentList=new ArrayList<>();
        mFragmentList.add(new UserDetailFragment());
        mFragmentList.add(new UserDetailFragment());
        mFragmentList.add(new UserDetailFragment());

        adapter=new MyPagerAdapter(this.getSupportFragmentManager(),mFragmentList,tabName);
       mHappyLifeViewPager.setAdapter(adapter);
       mHappyLifeTabLayout.setupWithViewPager(mHappyLifeViewPager);





    }


    private void initTabLayout() {
        tabName=new ArrayList<>();
        tabName.add("推荐");
        tabName.add("订阅");
        tabName.add("历史");

        mHappyLifeTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < tabName.size(); i++) {
            mHappyLifeTabLayout.addTab(mHappyLifeTabLayout.newTab().setText(tabName.get(i)));
        }
    }
}
