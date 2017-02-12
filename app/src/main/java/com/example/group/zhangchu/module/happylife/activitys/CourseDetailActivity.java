package com.example.group.zhangchu.module.happylife.activitys;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.api.Apis;
import com.example.group.zhangchu.beans.HappyLifeCourseDetailBean;
import com.example.group.zhangchu.common.BaseActivity;
import com.example.group.zhangchu.module.happylife.adapter.CourseDetailPagerAdapter;
import com.example.group.zhangchu.module.happylife.fragments.FoodMaterialFragment;
import com.example.group.zhangchu.module.happylife.fragments.HowToDoFragment;
import com.example.group.zhangchu.module.happylife.fragments.RelateCommonSenseFragment;
import com.example.group.zhangchu.module.happylife.fragments.XiangKeXiangYiFragment;
import com.example.group.zhangchu.utils.JsonUtil;
import com.example.group.zhangchu.utils.VolleyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class CourseDetailActivity extends BaseActivity {
    
    /*@BindView(R.id.coursedetail_recycle_view)
    RecyclerView mCourseDetailRecyclerView;*/

    @BindView(R.id.coursedetail_header_image)
    ImageView mHeaderImage;

    @BindView(R.id.coursedetail_header_play_image)
    ImageView mHeaderPlayImage;

    @BindView(R.id.coursedetail_headertext1_text)
    TextView mHeaderText1;

    @BindView(R.id.coursedetail_headertext2_text)
    TextView mHeaderText2;

    @BindView(R.id.coursedetail_headertext3_text)
    TextView mHeaderText3;

    @BindView(R.id.coursedetail_main_title)
    TextView mMainTitle;


    @BindView(R.id.coursedetail_content_text)
    TextView mContentText;

    @BindView(R.id.coursedetail_hard_text)
    TextView mHardText;

    @BindView(R.id.coursedetail_time_text)
    TextView mTimeText;

    @BindView(R.id.coursedetail_taste_text)
    TextView mTasteText;

    @BindView(R.id.coursedetail_tabs)
    TabLayout mTabs;

    @BindView(R.id.coursedetail_viewpager)
    ViewPager mViewPager;

    //
    private HappyLifeCourseDetailBean mCourseDetailBeans;
    /*private List<HappyLifeCourseDetailBean.DataBean> mCourseDetailDataList;
    private CourseDetailAdapter mCourseDetailAdapter;*/
    
    
    @Override
    protected int getLayoutId() {
        return R.layout.activity_cursor_detail;
    }

    @Override
    protected void initView() {


        //initCourseDetailRecycleView();
    }

/*
    private void initCourseDetailRecycleView() {
        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this.getApplicationContext());
        mCourseDetailRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mCourseDetailRecyclerView.setHasFixedSize(true);

        mCourseDetailDataList = new ArrayList<>();
        mCourseDetailDataList.add(null);
        mCourseDetailDataList.add(null);
        mCourseDetailDataList.add(null);
        //创建并设置Adapter
        mCourseDetailAdapter = new CourseDetailAdapter(this,mCourseDetailDataList);

        mCourseDetailRecyclerView.setAdapter(mCourseDetailAdapter);

    }*/

    @Override
    protected void initEvent() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:

        }

        return super.onTouchEvent(event);
    }

    /**
     * methodName			DishesView
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
        map.put("methodName", "DishesView");//methodName=CourseLogo
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
                mCourseDetailBeans = JsonUtil
                        .parseJsonToHappyLifeCourseDetailBean(response);

                refleshCateLogoData(mCourseDetailBeans);
            }
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private void refleshCateLogoData(HappyLifeCourseDetailBean courseDetailBeans) {

        //设置数据
        //获取header图片并显示
        Glide.with(this)
                .load(courseDetailBeans.getData().getImage())
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .into(mHeaderImage);

        mMainTitle.setText(courseDetailBeans.getData().getDashes_name());
        mContentText.setText(courseDetailBeans.getData().getMaterial_desc());
        mHardText.setText(courseDetailBeans.getData().getHard_level());
        mTimeText.setText(courseDetailBeans.getData().getCooke_time());
        mTasteText.setText(courseDetailBeans.getData().getTaste());


        //创建viewpager中的fragment

        List<Fragment> mCourseDetailFragments;
        mCourseDetailFragments = new ArrayList<>();

        mCourseDetailFragments.add(HowToDoFragment
                .newInstance(courseDetailBeans.getData().getStep()));

        mCourseDetailFragments.add(new FoodMaterialFragment());
        mCourseDetailFragments.add(new RelateCommonSenseFragment());
        mCourseDetailFragments.add(new XiangKeXiangYiFragment());

        String[] tiltes = this.getResources().getStringArray(R.array.happy_life_coursedetail_tab_title);

        FragmentManager supportFragmentManager = (this).
                getSupportFragmentManager();
        FragmentPagerAdapter adapter = new CourseDetailPagerAdapter
                (supportFragmentManager,mCourseDetailFragments,tiltes);
        mViewPager.setAdapter(adapter);
        mTabs.setupWithViewPager(mViewPager);

       /* mCourseDetailDataList.clear();
        mCourseDetailDataList.add(courseDetailBeans.getData());
        mCourseDetailAdapter.notifyDataSetChanged();*/

    }

}
