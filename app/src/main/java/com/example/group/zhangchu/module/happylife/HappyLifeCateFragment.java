package com.example.group.zhangchu.module.happylife;


        import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.api.Apis;
import com.example.group.zhangchu.beans.HappLifeCateLogoBean;
import com.example.group.zhangchu.beans.HappyLifeCateBean;
import com.example.group.zhangchu.common.BaseFragment;
import com.example.group.zhangchu.module.happylife.activitys.CateIpDetailActivity;
import com.example.group.zhangchu.module.happylife.adapter.CateAdapter;
import com.example.group.zhangchu.module.happylife.adapter.CateLogoAdapter;
import com.example.group.zhangchu.utils.JsonUtil;
import com.example.group.zhangchu.utils.VolleyUtils;
import com.example.group.zhangchu.widget.PullToRefleshRecycleView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HappyLifeCateFragment extends BaseFragment {
    @BindView(R.id.happylife_cate_logo_recycle_view)
    RecyclerView mLogoRecyclerView;

    @BindView(R.id.happylife_cate_recycle_view)
    PullToRefleshRecycleView mCatePullToRefleshRecycleView;

    //美食ip logo数据和adapter
    private HappLifeCateLogoBean mHappyLifeCateLogoBeans;
    private List<HappLifeCateLogoBean.DataBean.AlbumsBean> albumList;
    private CateLogoAdapter mCateLogoAdapter;

    //美食ip 数据和adapter
    private HappyLifeCateBean mHappyLifeCateBeans;
    private List<HappyLifeCateBean.DataBean.DataBean1> CateDataList;
    private CateAdapter mCateAdapter;


    //private String path = Apis.CATE_IP_API+"&methodName=CourseLogo"+"&version=4.4.0";
    // private String path = Apis.CATE_IP_API+"&methodName=CourseLogo"+"&version=4.4.0";
    private int pageIndex = 1;
    private RecyclerView mRefreshableView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_happy_life_cate;
    }

    @Override
    protected void initView(View ret) {

        //初始化美食ip第一行logo
        initLogoRecycleView();
        //初始化美食ip数据
        initCateRecycleView();
    }

    //初始化事件
    @Override
    protected void initEvent() {

        //recycleView上下拉刷新监听
        mCatePullToRefleshRecycleView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                //加载cate页面数据
                Map<String, String> map2 = new HashMap<String, String>();
                pageIndex = 1;
                map2.put("page", String.valueOf(pageIndex));//methodName=CourseLogo
                map2.put("methodName", "CourseIndex");//version: 4.4.0
                map2.put("size", "20");//version: 4.4.0
                map2.put("version", "4.40");//version: 4.4.0
                postLoadData2(Apis.CATE_IP_API, map2);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                //加载cate页面数据
                Map<String, String> map2 = new HashMap<String, String>();

                map2.put("page", String.valueOf(pageIndex));//methodName=CourseLogo
                map2.put("methodName", "CourseIndex");//version: 4.4.0
                map2.put("size", "20");//version: 4.4.0
                map2.put("version", "4.40");//version: 4.4.0
                postLoadData2(Apis.CATE_IP_API, map2);


            }
        });

        //recycleView item点击事件监听

        mCateLogoAdapter.setOnRecycleItemOnClickListener
                (new CateLogoAdapter.OnRecycleViewItemOnClickListener() {
                    @Override
                    public void onItemClick(View view,
                                            HappLifeCateLogoBean
                                                    .DataBean.AlbumsBean data) {
                        Intent intent = new Intent(getContext(), CateIpDetailActivity.class);
                        intent.putExtra("seriesId",data.getSeries_id());
                        startActivity(intent);

                    }
                });

        //recycleView item点击事件监听

        mCateAdapter.setOnRecycleItemOnClickListener
                (new CateAdapter.OnRecycleItemOnClickListener() {

                    @Override
                    public void onClick(View v, HappyLifeCateBean.DataBean.DataBean1 data) {
                        Intent intent = new Intent(getContext(), CateIpDetailActivity.class);
                        intent.putExtra("seriesId",String.valueOf(data.getSeries_id()));
                        startActivity(intent);

                    }
                });

    }


    private void initLogoRecycleView() {

        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext());
        mLogoRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mLogoRecyclerView.setHasFixedSize(true);

        albumList = new ArrayList<>();
        //创建并设置Adapter
        mCateLogoAdapter = new CateLogoAdapter(getContext(),albumList);

        mLogoRecyclerView.setAdapter(mCateLogoAdapter);

    }




    private void initCateRecycleView() {
        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext());
        mRefreshableView = mCatePullToRefleshRecycleView.getRefreshableView();
        mCatePullToRefleshRecycleView.setMode(PullToRefreshBase.Mode.BOTH);
        mRefreshableView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRefreshableView.setHasFixedSize(true);

        CateDataList = new ArrayList<>();
        //创建并设置Adapter
        mCateAdapter = new CateAdapter(getContext(),CateDataList);

        mRefreshableView.setAdapter(mCateAdapter);

    }


    @Override
    protected void initData() {

        //加载logo数据
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("methodName", "CourseLogo");//methodName=CourseLogo
        map1.put("version", "4.4.0");//version: 4.4.0
        postLoadData1(Apis.CATE_IP_API, map1);

        //加载cate页面数据
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("page", String.valueOf(pageIndex));//methodName=CourseLogo
        map2.put("methodName", "CourseIndex");//version: 4.4.0
        map2.put("size", "20");//version: 4.4.0
        map2.put("version", "4.40");//version: 4.4.0
        postLoadData2(Apis.CATE_IP_API, map2);

    }


    private void postLoadData1(String url, final Map<String,String> map){

        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                mHappyLifeCateLogoBeans = JsonUtil
                        .parseJsonToHappLifeCateIPLogoBeans(response);

                refleshCateLogoData(mHappyLifeCateLogoBeans);
            }
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        // }

    }

    private void postLoadData2(String url, final Map<String,String> map){

        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                mHappyLifeCateBeans = JsonUtil
                        .parseJsonToHappyLifeCateIPBeans(response);

                refleshCateData(mHappyLifeCateBeans);
                //完成刷新
                mCatePullToRefleshRecycleView.onRefreshComplete();
                //解决刷新完不能滑出数据
                mRefreshableView.smoothScrollBy(0,-1);
                pageIndex++;
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }


    //更新美食ip logo数据
    private void refleshCateLogoData(HappLifeCateLogoBean happLifeCateLogoBeans){

        albumList.addAll(happLifeCateLogoBeans
                .getData().getAlbums());
        mCateLogoAdapter.notifyDataSetChanged();
    }

    //更新美食ip数据
    private void refleshCateData(HappyLifeCateBean happyLifeCateBeans){

        CateDataList.addAll(happyLifeCateBeans
                .getData().getData());
        //Log.d("flag", "refleshCateData: "+CateDataList);
        mCateAdapter.notifyDataSetChanged();
    }




}

