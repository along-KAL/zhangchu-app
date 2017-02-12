

package com.example.group.zhangchu.module.happylife.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.beans.HappyLifeCateBean;
import com.example.group.zhangchu.beans.HappyLifeCourseDetailBean;
import com.example.group.zhangchu.module.happylife.activitys.CourseDetailActivity;
import com.example.group.zhangchu.module.happylife.fragments.FoodMaterialFragment;
import com.example.group.zhangchu.module.happylife.fragments.HowToDoFragment;
import com.example.group.zhangchu.module.happylife.fragments.RelateCommonSenseFragment;
import com.example.group.zhangchu.module.happylife.fragments.XiangKeXiangYiFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_HEADER_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_SECOUND_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_VP_COUNT;

/**
 * Created by kongalong on 2016/12/12.
 */
public class CourseDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private Context mContext;
    private List<HappyLifeCourseDetailBean.DataBean> mCourseDetailData;

    public CourseDetailAdapter(Context context,
                               List<HappyLifeCourseDetailBean.DataBean> courseDetailData) {

        this.mContext = context;
        this.mCourseDetailData = courseDetailData;

    }

    public int getItemViewType(int position) {

        switch(position){
            case 0:
                return HAPPYLIFE_COURSEDETAIL_HEADER_COUNT;
            case 1:
                return HAPPYLIFE_COURSEDETAIL_SECOUND_COUNT;
            default:
                return HAPPYLIFE_COURSEDETAIL_VP_COUNT;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch(viewType){

            //头布局
            case HAPPYLIFE_COURSEDETAIL_HEADER_COUNT:

                return new CourseDetailAdapter.ViewHolder1(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail_header_item, parent,false));


            //
            case HAPPYLIFE_COURSEDETAIL_SECOUND_COUNT:

                return new CourseDetailAdapter.ViewHolder2(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail_second_item, parent,false));


            //VP
            case HAPPYLIFE_COURSEDETAIL_VP_COUNT:

                return new CourseDetailAdapter.ViewHolder3(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail_vp_item, parent,false));


            default:
                return null;

        }


    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);

        //没数据直接跳出
        if(mCourseDetailData.get(0)==null){return;}

        switch(itemViewType){
            //头布局
            case HAPPYLIFE_COURSEDETAIL_HEADER_COUNT:

                CourseDetailAdapter.ViewHolder1 holder1 = (CourseDetailAdapter.ViewHolder1)holder;
                //获取header图片并显示
                Glide.with(mContext)
                        .load(mCourseDetailData.get(0).getImage())
                        .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .crossFade()
                        .into(holder1.mMainImage);


                break;
            //
            case HAPPYLIFE_COURSEDETAIL_SECOUND_COUNT:


                CourseDetailAdapter.ViewHolder2 holder2 = (CourseDetailAdapter.ViewHolder2)holder;

                holder2.mMainTitle.setText(mCourseDetailData.get(0).getDashes_name());
                holder2.mContentText.setText(mCourseDetailData.get(0).getMaterial_desc());
                holder2.mHardText.setText(mCourseDetailData.get(0).getHard_level());
                holder2.mTimeText.setText(mCourseDetailData.get(0).getCooke_time());
                holder2.mTasteText.setText(mCourseDetailData.get(0).getTaste());

                break;
            //Vp
            case HAPPYLIFE_COURSEDETAIL_VP_COUNT:
                //创建viewpager中的fragment
                CourseDetailAdapter.ViewHolder3 holder3 = (CourseDetailAdapter.ViewHolder3)holder;

                List<Fragment> mCourseDetailFragments;
                mCourseDetailFragments = new ArrayList<>();

                mCourseDetailFragments.add(HowToDoFragment
                        .newInstance(mCourseDetailData.get(0).getStep()));

                mCourseDetailFragments.add(new FoodMaterialFragment());
                mCourseDetailFragments.add(new RelateCommonSenseFragment());
                mCourseDetailFragments.add(new XiangKeXiangYiFragment());

                String[] tiltes = mContext.getResources().getStringArray(R.array.happy_life_coursedetail_tab_title);

                FragmentManager supportFragmentManager = ((CourseDetailActivity)mContext).
                        getSupportFragmentManager();
                FragmentPagerAdapter adapter = new CourseDetailPagerAdapter
                        (supportFragmentManager,mCourseDetailFragments,tiltes);
                holder3.mViewPager.setAdapter(adapter);
                holder3.mTabLayout.setupWithViewPager(holder3.mViewPager);




                break;


            default:
                break;
        }




    }



    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onClick(View v) {
        this.mOnClickListener.onClick(v,(HappyLifeCateBean.DataBean.DataBean1)v.getTag());
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView mMainImage;
        private  ImageView mPlayImage;
        private TextView mHeadertext1;
        private  TextView mHeadertext2;
        private  TextView mHeadertext3;


        public ViewHolder1(View itemView) {
            super(itemView);

            mMainImage =  (ImageView) itemView.findViewById(R.id.coursedetail_header_image);
            mPlayImage = (ImageView) itemView.findViewById(R.id.coursedetail_header_play_image);
            mHeadertext1 = (TextView) itemView.findViewById(R.id.coursedetail_headertext1_text);
            mHeadertext2 = (TextView) itemView.findViewById(R.id.coursedetail_headertext2_text);
            mHeadertext3 = (TextView) itemView.findViewById(R.id.coursedetail_headertext3_text);

        }
    }


    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView mMainTitle;
        private  TextView mContentText;
        private  TextView mHardText;
        private  TextView mTimeText;
        private  TextView mTasteText;

        public ViewHolder2(View itemView) {
            super(itemView);

            mMainTitle = (TextView) itemView.findViewById(R.id.coursedetail_main_title);
            mContentText = (TextView) itemView.findViewById(R.id.coursedetail_content_text);
            mHardText = (TextView) itemView.findViewById(R.id.coursedetail_hard_text);
            mTimeText = (TextView) itemView.findViewById(R.id.coursedetail_time_text);
            mTasteText = (TextView) itemView.findViewById(R.id.coursedetail_taste_text);

        }
    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder {

        private ViewPager mViewPager;

        private TabLayout mTabLayout;

        public ViewHolder3(View itemView) {
            super(itemView);
            mViewPager = (ViewPager) itemView.findViewById(R.id.coursedetail_view_pager);
            mTabLayout = (TabLayout) itemView.findViewById(R.id.coursedetail_tab_layout);
        }
    }
    private OnRecycleItemOnClickListener mOnClickListener;
    public void setOnRecycleItemOnClickListener(OnRecycleItemOnClickListener onClickListener){

        this.mOnClickListener = onClickListener;

    }
    public interface OnRecycleItemOnClickListener{
        void onClick(View v, HappyLifeCateBean.DataBean.DataBean1 data);
    }
}

