package com.example.group.zhangchu.module.happylife.fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.api.Apis;
import com.example.group.zhangchu.beans.HappyLifeCourseDetailFoodMaterialBean;
import com.example.group.zhangchu.common.BaseFragment;
import com.example.group.zhangchu.module.happylife.adapter.CourseDetailFoodMaterialAdapter;
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
public class FoodMaterialFragment extends BaseFragment {

    @BindView(R.id.coursedetail_foodmaterial_recycleview)
    RecyclerView mCourseDetailFoodMaterialRecyclerView;


    //
    private HappyLifeCourseDetailFoodMaterialBean mHappyLifeCourseDetailFoodMaterialBean;
    private List<Object> mData;
    private CourseDetailFoodMaterialAdapter mCourseDetailFoodMaterialAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_food_material;
    }

    @Override
    protected void initView(View ret) {
        initCourseDetailRecycleView();
    }
    private void initCourseDetailRecycleView() {
        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this.getActivity().getApplicationContext());
        mCourseDetailFoodMaterialRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mCourseDetailFoodMaterialRecyclerView.setHasFixedSize(true);

        mData = new ArrayList<>();

        //创建并设置Adapter
        mCourseDetailFoodMaterialAdapter = new CourseDetailFoodMaterialAdapter(this.getActivity(),mData);

        mCourseDetailFoodMaterialRecyclerView.setAdapter(mCourseDetailFoodMaterialAdapter);

    }
    @Override
    protected void initEvent() {

    }
    /**
     * methodName			DishesMaterial
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
        map.put("methodName", "DishesMaterial");//methodName=CourseLogo
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
                mHappyLifeCourseDetailFoodMaterialBean = JsonUtil
                        .parseJsonToHappyLifeCourseDetailFoodMaterialBean(response);

                refleshFoodMaterailData(mHappyLifeCourseDetailFoodMaterialBean);
            }
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private void refleshFoodMaterailData(HappyLifeCourseDetailFoodMaterialBean courseDetailBeans) {

        mData.add(courseDetailBeans.getData().getMaterial_image());
        mData.add(courseDetailBeans.getData().getMaterial());
        mData.add(courseDetailBeans.getData().getSpices());
        mCourseDetailFoodMaterialAdapter.notifyDataSetChanged();

    }


}
