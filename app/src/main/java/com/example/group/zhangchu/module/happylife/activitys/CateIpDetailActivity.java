package com.example.group.zhangchu.module.happylife.activitys;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.VolleyError;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.api.Apis;
import com.example.group.zhangchu.beans.HappyLifeCateCommentListBean;
import com.example.group.zhangchu.beans.HappyLifeCateCourseRelateBean;
import com.example.group.zhangchu.beans.HappyLifeCateDetailBean;
import com.example.group.zhangchu.beans.HappyLifeCateZanBean;
import com.example.group.zhangchu.common.BaseActivity;
import com.example.group.zhangchu.module.happylife.adapter.CateDetailAdapter;
import com.example.group.zhangchu.utils.JsonUtil;
import com.example.group.zhangchu.utils.VolleyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class CateIpDetailActivity extends BaseActivity {

    @BindView(R.id.happylife_cateipdetail_recycleview)
    RecyclerView mRecyclerView;


    private List<Object> mData;

    private HappyLifeCateDetailBean.DataBean mDetailBean;
    private HappyLifeCateZanBean.DataBean mZanBean;
    private List<HappyLifeCateCourseRelateBean.DataBean.DataBean1> mCourseRelateBean;
    private List<HappyLifeCateCommentListBean.DataBean.DataBean1> mCommentListBean;
    private CateDetailAdapter mCateDetailAdapter;

    //判断数据是否全部加载完
    private int index = 0;
    //选集更新数据标志
    private boolean sign = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cate_ip_detail;
    }

    @Override
    protected void initView() {
        //初始化美食ip详情recycleview
        initDetialRecycleView();
    }


    @Override
    protected void initEvent() {




        //选集监听
        mCateDetailAdapter.setOnCheckedChangeListener(new CateDetailAdapter.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(HappyLifeCateDetailBean.DataBean.DataBean1 detailBean) {
                sign = true;

                int course_id = detailBean.getCourse_id();
                //加载点赞数据
                Map<String, String> map2 = new HashMap<String, String>();
                map2.put("post_id", String.valueOf(course_id));//methodName=CourseLogo
                map2.put("methodName", "DianzanList");//version: 4.4.0
                map2.put("version", "4.40");//version: 4.4.0
                postLoadZanData(Apis.CATE_IP_API, map2);

                //加载相关课程数据
                Map<String, String> map3 = new HashMap<String, String>();
                map3.put(" size", "10");//methodName=CourseLogo
                map3.put("page", "1");//version: 4.4.0
                map3.put("course_id", String.valueOf(course_id));//version: 4.4.0
                map3.put("methodName", "CourseRelate");//version: 4.4.0
                map3.put("version", "4.40");//version: 4.4.0
                postLoadCourseRelateData(Apis.CATE_IP_API, map3);

            }
        });

    }

    private void initDetialRecycleView() {

        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this.getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);

        mData = new ArrayList<>();

        //创建并设置Adapter
        mCateDetailAdapter = new CateDetailAdapter(this,mData);
        mRecyclerView.setAdapter(mCateDetailAdapter);

    }




    @Override
    protected void initData() {

        //获取seriesId
        String seriesId = getIntent().getStringExtra("seriesId");
        Log.d("flag", "initData: " +seriesId);
        //加载Detail页面数据
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("methodName", "CourseSeriesView");//methodName=CourseLogo
        map1.put("series_id", seriesId);//version: 4.4.0
        map1.put("version", "4.40");//version: 4.4.0
        postLoadDetailData(Apis.CATE_IP_API, map1);

        //加载点赞数据
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("post_id", "2101");//methodName=CourseLogo
        map2.put("methodName", "DianzanList");//version: 4.4.0
        map2.put("version", "4.40");//version: 4.4.0
        postLoadZanData(Apis.CATE_IP_API, map2);

        //加载相关课程数据
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put(" size", "10");//methodName=CourseLogo
        map3.put("page", "1");//version: 4.4.0
        map3.put("course_id", "2101");//version: 4.4.0
        map3.put("methodName", "CourseRelate");//version: 4.4.0
        map3.put("version", "4.40");//version: 4.4.0
        postLoadCourseRelateData(Apis.CATE_IP_API, map3);

        //加载评论数据
        Map<String, String> map4 = new HashMap<String, String>();
        map4.put("relate_id", seriesId);
        map4.put(" size", "20");//methodName=CourseLogo
        map4.put("page", "1");//version: 4.4.0
        map4.put("methodName", "CommentList");//version: 4.4.0
        map4.put("type", "2");//version: 4.4.0
        map4.put("version", "4.40");//version: 4.4.0
        postLoadCommentListData(Apis.CATE_IP_API, map4);

    }



    private void postLoadDetailData(String url, final Map<String,String> map){

        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                Log.d("flag", "onResponse1: " +response);
                mDetailBean = JsonUtil
                        .parseJsonToHappyLifeCateDetailBean(response).getData();

                refleshData();
            }
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("flag", "onErrorResponse: 1");
            }
        });

    }


    private void postLoadZanData(String url, Map<String, String> map) {

        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                Log.d("flag", "onResponse2: " +response);
                mZanBean = JsonUtil
                        .parseJsonToHappyLifeCateZanBean(response).getData();

                refleshData();

            }
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("flag", "onErrorResponse: 2");
            }
        });

    }

    private void postLoadCourseRelateData(String url, Map<String, String> map) {
        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                Log.d("flag", "onResponse3: " +response);
                mCourseRelateBean = JsonUtil
                        .parseJsonToHappyLifeCateCourseRelateBean(response)
                        .getData().getData();

                refleshData();

            }
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("flag", "onErrorResponse: 3");
            }
        });
    }


    private void postLoadCommentListData(String url, Map<String, String> map) {
        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {

                Log.d("flag", "onResponse4: " +response);
                mCommentListBean = JsonUtil
                        .parseJsonToHappyLifeCateCommentListBean(response)
                        .getData().getData();

                refleshData();

            }
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("flag", "onErrorResponse: 4");
            }
        });
    }

    //加synchronized同步一下，防止多线程安全问题
    private synchronized void refleshData() {
        index++;

        //sign==4,说明数据都加载完了sign2 == true说明选集更新了数据

        if(index == 4||(sign && index==2)){

            //重置index清空mData
            index = 0;
            mData.clear();

            mData.add(mDetailBean);
            mData.add(mZanBean);
            mData.add(mCourseRelateBean);
            if (mCommentListBean != null) {
                mData.addAll(mCommentListBean);
            }


            mCateDetailAdapter.notifyDataSetChanged();
        }

    }
}
