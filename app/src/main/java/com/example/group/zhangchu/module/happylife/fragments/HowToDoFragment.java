package com.example.group.zhangchu.module.happylife.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.group.zhangchu.R;
import com.example.group.zhangchu.beans.HappyLifeCourseDetailBean;
import com.example.group.zhangchu.common.BaseFragment;
import com.example.group.zhangchu.module.happylife.adapter.CourseDetailHowToDoAdapter;

import java.util.List;

import butterknife.BindView;

public class HowToDoFragment extends BaseFragment {

    @BindView(R.id.howtodo_recycleview)
    RecyclerView mCourseDetailHowToDoRecycle;



    //数据
    private static List<HappyLifeCourseDetailBean.DataBean.StepBean> mData;
    private CourseDetailHowToDoAdapter mCourseDetailHowToDoAdapter;


    public static HowToDoFragment newInstance(List<HappyLifeCourseDetailBean.DataBean.StepBean> data) {
        HowToDoFragment fragment = new HowToDoFragment();

        mData = data;
        //Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);

        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_how_to_do;
    }

    @Override
    protected void initView(View ret) {
        mCourseDetailHowToDoRecycle.requestDisallowInterceptTouchEvent(false);
        //初始化
        initHowToDoRecycleView();
    }

    private void initHowToDoRecycleView() {

        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext());
        mCourseDetailHowToDoRecycle.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mCourseDetailHowToDoRecycle.setHasFixedSize(true);

        //mData = new ArrayList<>();
        //创建并设置Adapter
        mCourseDetailHowToDoAdapter = new CourseDetailHowToDoAdapter(getContext(),mData);

        mCourseDetailHowToDoRecycle.setAdapter(mCourseDetailHowToDoAdapter);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }
}
