package com.example.group.zhangchu.module.happylife.fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.api.Apis;
import com.example.group.zhangchu.beans.HappyLifeXiangKeXiangYiBean;
import com.example.group.zhangchu.common.BaseFragment;
import com.example.group.zhangchu.module.happylife.adapter.CourseDetailXiangKeXiangYiAdapter;
import com.example.group.zhangchu.utils.JsonUtil;
import com.example.group.zhangchu.utils.VolleyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class XiangKeXiangYiFragment extends BaseFragment {



    @BindView(R.id.coursedetail_xiangkexiangyi_recycleview)
    RecyclerView mCourseDetailXiangKeXiangYiRecyclerView;


    //
    private HappyLifeXiangKeXiangYiBean mHappyLifeXiangKeXiangYiBean;
    private List<Object> mData;
    private CourseDetailXiangKeXiangYiAdapter mCourseDetailXiangKeXiangYiAdapter;

    private List<Integer> mSize;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xiang_ke_xiang_yi;
    }

    @Override
    protected void initView(View ret) {
        initCourseDetailRecycleView();
    }
    private void initCourseDetailRecycleView() {
        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this.getActivity().getApplicationContext());
        mCourseDetailXiangKeXiangYiRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mCourseDetailXiangKeXiangYiRecyclerView.setHasFixedSize(true);

        mData = new ArrayList<>();
        mSize = new ArrayList<>();

        //创建并设置Adapter
        mCourseDetailXiangKeXiangYiAdapter = new CourseDetailXiangKeXiangYiAdapter(this.getActivity(),mData,mSize);

        mCourseDetailXiangKeXiangYiRecyclerView.setAdapter(mCourseDetailXiangKeXiangYiAdapter);

    }
    @Override
    protected void initEvent() {

    }
    /**
     * methodName			DishesSuitable
     dishes_id			7661
     token				9BCA7B5084FBD32BDE1ACD58880B9F30
     user_id				1795237
     version				4.4.0

     */
    @Override
    protected void initData() {
        //http://api.izhangchu.com/dishes_id=6621&methodName=DishesView&version=4.40&
        //加载数据http://api.izhangchu.com/&methodName=DishesView&dishes_id=7661&token
        // =9BCA7B5084FBD32BDE1ACD58880B9F30&user_id=1795237&version=4.4.0
        Map<String, String> map = new HashMap<String, String>();
        map.put("methodName", "DishesSuitable");//methodName=CourseLogo
        map.put("dishes_id", "7661");//version: 4.4.0
        map.put("token", "9BCA7B5084FBD32BDE1ACD58880B9F30");//version: 4.4.0
        map.put("user_id", "1795237");//version: 4.4.0
        map.put("version", "4.4.0");//version: 4.4.0
        postLoadData(Apis.CATE_IP_API, map);

    }

    private void postLoadData(String url, Map<String, String> map) {

        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                mHappyLifeXiangKeXiangYiBean = JsonUtil
                        .parseJsonToHappyLifeXiangKeXiangYiBean(response);

                refleshXiangKeXiangYiData(mHappyLifeXiangKeXiangYiBean);
            }
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private void refleshXiangKeXiangYiData(HappyLifeXiangKeXiangYiBean happyLifeXiangKeXiangYiBean) {

        mData.add(happyLifeXiangKeXiangYiBean.getData().getMaterial());
        mData.addAll(happyLifeXiangKeXiangYiBean.getData().getMaterial().getSuitable_with());
        mData.addAll(happyLifeXiangKeXiangYiBean.getData().getMaterial().getSuitable_not_with());

        mSize.add(happyLifeXiangKeXiangYiBean.getData().getMaterial().getSuitable_with().size());
        mCourseDetailXiangKeXiangYiAdapter.notifyDataSetChanged();

    }
}
