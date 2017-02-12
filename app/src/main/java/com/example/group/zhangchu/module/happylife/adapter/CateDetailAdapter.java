package com.example.group.zhangchu.module.happylife.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.beans.HappyLifeCateCommentListBean;
import com.example.group.zhangchu.beans.HappyLifeCateCourseRelateBean;
import com.example.group.zhangchu.beans.HappyLifeCateDetailBean;
import com.example.group.zhangchu.beans.HappyLifeCateZanBean;
import com.example.group.zhangchu.common.activitys.VideoActivity;
import com.example.group.zhangchu.module.happylife.activitys.CateIpDetailActivity;
import com.example.group.zhangchu.module.happylife.activitys.UserDetailActivity;
import com.example.group.zhangchu.utils.CircleTransform;
import com.example.group.zhangchu.widget.CustomRadioGroup;

import java.util.List;

import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_DETAIL_COMMENT_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_DETAIL_COURSE_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_DETAIL_HEADER_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_DETAIL_SECOUND_COUNT;

/**
 * Created by kongalong on 2016/12/13.
 */
public class CateDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private Context mContext;
    private List<Object> mData;

    //第几集
    private int index = 0;

    //解决重复常见radiobutton
    private boolean sign = false;
    //显示title Content的向上向下标志
    private boolean sign2 = false;

    public CateDetailAdapter(Context context, List<Object> data) {

        this.mContext = context;
        this.mData = data;

    }


    public int getItemViewType(int position) {

        switch(position){
            case 0:
                return HAPPYLIFE_DETAIL_HEADER_COUNT;
            case 1:
                return HAPPYLIFE_DETAIL_SECOUND_COUNT;
            case 2:
                return HAPPYLIFE_DETAIL_COURSE_COUNT;
             default:
                 return HAPPYLIFE_DETAIL_COMMENT_COUNT;
        }

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch(viewType){

            //头布局
            case HAPPYLIFE_DETAIL_HEADER_COUNT:

                return new ViewHolder1(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_detail_header_item, parent,false));


            //包括点赞等布局
            case HAPPYLIFE_DETAIL_SECOUND_COUNT:

                return new ViewHolder2(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_detail_second_item, parent,false));


            //相关课程
            case HAPPYLIFE_DETAIL_COURSE_COUNT:

                return new ViewHolder3(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_detail_course_item, parent,false));


            //评论
            case HAPPYLIFE_DETAIL_COMMENT_COUNT:

                return new ViewHolder4(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_detail_comment_item, parent,false));

            default:
                return null;

        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int itemViewType = getItemViewType(position);

        switch(itemViewType){
            //头布局
            case HAPPYLIFE_DETAIL_HEADER_COUNT:

                ViewHolder1 holder1 = (ViewHolder1)holder;
                //为播放按钮设置监听
                holder1.mPlayImage.setOnClickListener(this);

                HappyLifeCateDetailBean.DataBean o1 = (HappyLifeCateDetailBean
                        .DataBean)mData.get(0);
                //点击选集，图片随着改变
                String imageUrl = null;
                if(!sign){
                    imageUrl = o1.getSeries_image();
                }else{
                    imageUrl = o1.getData()
                            .get(index).getCourse_image();
                }
                Glide.with(mContext)
                        .load(imageUrl)
                        .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .crossFade()
                        .into(holder1.mMainImage);
                holder1.mCountText.setText("上课人数：" + o1.getData()
                        .get(index).getCourse_id());

                break;
            //包括点赞等布局
            case HAPPYLIFE_DETAIL_SECOUND_COUNT:

                final ViewHolder2 holder2 = (ViewHolder2)holder;


                holder2.mTitleText.setOnClickListener(this);
                holder2.mTitleText.setTag(holder2.mTitleText.getId(),holder2.mContentText);

                HappyLifeCateDetailBean.DataBean o2 = (HappyLifeCateDetailBean
                        .DataBean)mData.get(0);
                //赞数据
                HappyLifeCateZanBean.DataBean o3  = (HappyLifeCateZanBean.DataBean)
                        mData.get(1);

                holder2.mTitleText.setText(o2.getData().get((index)).getCourse_name());
                holder2.mContentText.setText(o2.getSeries_title());
                holder2.mUpdataText.setText("更新至"+o2.getEpisode()+"集");

                //使用自定义radiogroup实现选集布局
                if(!sign){
                    for (int j = 0; j < o2.getData().size(); j++) {

                        RadioButton radioButton = new RadioButton(mContext);
                        //radioButton.setPadding(20, 0, 1000 / 6, 0);  // 设置文字距离按钮四周的距离
                        radioButton.setButtonDrawable(R.color.colorAlpha);
                        radioButton.setBackgroundResource(R.drawable.happylife_detail_xuanji_selector);
                        radioButton.setId(j); //设置RadioButton的id
                      //  radioButton.setTextColor(R.drawable.font_selector);
                        //radioButton.setTag(o3.getData().get(j).getUser_id()); //tag用于存储RadioButton的一些数据
                        radioButton.setTextColor(mContext.getResources().getColorStateList(R.color.happylife_xuanji_font_selector));
                        radioButton.setGravity(Gravity.CENTER);
                        radioButton.setText(String.valueOf(j+1));
                        radioButton.setTextSize(13); //默认单位是 sp
                        radioButton.setHeight(30); //默认单位是px
                        radioButton.setWidth(50); //默认单位是px
                        holder2.mCustomRadioGroup.addView(radioButton); //添加到RadioGroup中
                    }
                }
                sign = true;


                holder2.mCustomRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        index = checkedId;
                        mOnCheckedChangeListener.onCheckedChanged(((HappyLifeCateDetailBean.DataBean)
                                mData.get(0)).getData().get(index));
                    }
                });


                //Log.d("flag", "位厨友觉得很赞: " +o3.getTotal());
                holder2.mZanText.setText(o3.getCount()+"位厨友觉得很赞");
                //获取屏幕信息
                DisplayMetrics dm = new DisplayMetrics();
                ((CateIpDetailActivity)mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
                int screenWidth = dm.widthPixels;
                int size = screenWidth / 7 ;
                //赞用户
                //必须先清空容器中的view
                holder2.mZanContainer.removeAllViews();
                for (int j = 0; j < o3.getData().size(); j++) {
                    ImageView imageView = new ImageView(mContext);
                    //加载圆形图片
                    Glide.with(mContext)
                            .load(o3.getData().get(j).getHead_img())
                            .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                            .transform(new CircleTransform(mContext))
                            .placeholder(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher)
                            .crossFade()
                            .into(imageView);
                    holder2.mZanContainer.addView(imageView);

                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = size;
                    layoutParams.height = size;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setTag("zanPerson");
                    imageView.setId(j);
                    imageView.setOnClickListener(this);
                }

                break;
            //相关视频
            case HAPPYLIFE_DETAIL_COURSE_COUNT:

                ViewHolder3 holder3 = (ViewHolder3)holder;

                //设置相关视频adapter
                //创建默认的线性LayoutManager
                LinearLayoutManager layoutManager =
                        new LinearLayoutManager(((CateIpDetailActivity)mContext).getApplicationContext());
                holder3.mCourseRecyclerView.setLayoutManager(layoutManager);
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
                holder3.mCourseRecyclerView.setHasFixedSize(true);

                //创建并设置Adapter
                CateDetailCourseAdapter cateDetailCourseAdapter =
                        new CateDetailCourseAdapter(mContext,
                                ((List<HappyLifeCateCourseRelateBean.DataBean.DataBean1>)
                                        mData.get(2)));

                holder3.mCourseRecyclerView.setAdapter(cateDetailCourseAdapter);
                //设置评论数
                holder3.mComment_count_title.setText(String.valueOf(mData.size()-3+"条评论"));

                break;
            //评论
            case HAPPYLIFE_DETAIL_COMMENT_COUNT:

                ViewHolder4 holder4 = (ViewHolder4)holder;

                //加载圆形图片
                Glide.with(mContext)
                        .load(((HappyLifeCateCommentListBean.DataBean.DataBean1)
                                mData.get(position)).getHead_img())
                        .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .transform(new CircleTransform(mContext))
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .crossFade()
                        .into(holder4.mCommentImage);


                holder4.mNameText.setText(((HappyLifeCateCommentListBean.DataBean.DataBean1)
                        mData.get(position)).getNick());
                holder4.mCommentContentText.setText(((HappyLifeCateCommentListBean.DataBean.DataBean1)
                        mData.get(position)).getContent());
                holder4.mDateText.setText(((HappyLifeCateCommentListBean.DataBean.DataBean1)
                        mData.get(position)).getCreate_time());


                holder4.mCommentImage.setOnClickListener(this);

                break;
            default:
                break;
        }

    }



    @Override
    public int getItemCount() {
        return mData.size();
    }




    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView mMainImage;
        private ImageView mPlayImage;
        private  TextView mCountText;

        public ViewHolder1(View itemView) {
            super(itemView);

            mMainImage =  (ImageView) itemView.findViewById(R.id.happylife_detail_header_image);
            mCountText = (TextView) itemView.findViewById(R.id.happylife_detail_header_class_count);
            mPlayImage = (ImageView) itemView.findViewById(R.id.happylife_detail_header_play_image);

        }
    }
    public static class ViewHolder2 extends RecyclerView.ViewHolder {

        private  TextView mTitleText;
        private  TextView mContentText;
        private  TextView mUpdataText;
        private CustomRadioGroup mCustomRadioGroup;
        private  TextView mZanText;
        private LinearLayout mZanContainer;

        public ViewHolder2(View itemView) {
            super(itemView);

            mTitleText =  (TextView) itemView.findViewById(R.id.happylife_detail_second_title);
            mContentText = (TextView) itemView.findViewById(R.id.happylife_detail_second_detail_content);
            mUpdataText = (TextView) itemView.findViewById(R.id.happylife_detail_updata_text);
            mCustomRadioGroup = (CustomRadioGroup) itemView.findViewById(R.id.happylife_detail_second_select_container);
            mZanText = (TextView) itemView.findViewById(R.id.happylife_detail_zan_text);
            mZanContainer = (LinearLayout) itemView.findViewById(R.id.happylife_detail_second_zan_container);

        }


    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder {

        private RecyclerView mCourseRecyclerView;
        private TextView mComment_count_title;



        public ViewHolder3(View itemView) {
            super(itemView);

            mCourseRecyclerView =  (RecyclerView) itemView.findViewById(R.id.happylife_detail_course_recycleview);
            mComment_count_title =  (TextView) itemView.findViewById(R.id.happylife_detail_comment_count_title);

        }
    }

    public static class ViewHolder4 extends RecyclerView.ViewHolder {

        private ImageView mCommentImage;
        private  TextView mNameText;
        private  TextView mCommentContentText;
        private  TextView mDateText;

        public ViewHolder4(View itemView) {
            super(itemView);

            mCommentImage = (ImageView) itemView.findViewById(R.id.happylife_detail_comment_image);
            mNameText = (TextView) itemView.findViewById(R.id.happylife_detail_comment_name);
            mCommentContentText = (TextView) itemView.findViewById(R.id.happylife_detail_comment_content);
            mDateText = (TextView) itemView.findViewById(R.id.happylife_detail_comment_date_text);

        }
    }


    //点击事件监听
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            //头布局播放按钮
            case R.id.happylife_detail_header_play_image:
                HappyLifeCateDetailBean.DataBean.DataBean1 dataBean1 = ((HappyLifeCateDetailBean.DataBean)
                        mData.get(0)).getData().get(index);
                Intent intent=new Intent(mContext, VideoActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("video", dataBean1.getCourse_video());
                bundle.putString("image", dataBean1.getCourse_image());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            //显示详细内容的事件
            case R.id.happylife_detail_second_title:
                if(!sign2){
                    Drawable drawable = mContext.getResources().getDrawable(R.mipmap.icon_gray_arrow_up);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight()); //设置边界
                    ((TextView)v).setCompoundDrawables(null, null, drawable, null);//画在右边
                    //修改sign2，下次再按，就变成向下了
                    ((TextView)v.getTag(v.getId())).setVisibility(View.VISIBLE);
                    sign2 = true;
                }else{
                    Drawable drawable = mContext.getResources().getDrawable(R.mipmap.icon_gray_arrow_down);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight()); //设置边界
                    ((TextView)v).setCompoundDrawables(null, null, drawable, null);//画在右边
                    //修改sign2，下次再按，就变成向上了
                    ((TextView)v.getTag(v.getId())).setVisibility(View.GONE);
                    sign2 = false;
                }

            break;
            default:
                break;
                }

        //赞的人
        if(((String)v.getTag())!=null&&((String)v.getTag()).equals("zanPerson")){

            mContext.startActivity(new Intent(mContext, UserDetailActivity.class));


        }



    }

  /*  private OnClickListener mOnClickListener;
    public void setOnClickListener(
            OnClickListener onClickListener){
        this.mOnClickListener = onClickListener;
    }
    public interface OnClickListener{

        void onClick(View v);

    }*/


    //RadioGroup监听事件
    private OnCheckedChangeListener mOnCheckedChangeListener;
    public void setOnCheckedChangeListener(
            OnCheckedChangeListener onCheckedChangeListener){
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }
    public interface OnCheckedChangeListener{

        void onCheckedChanged(HappyLifeCateDetailBean.DataBean.DataBean1 detailBean);

    }

}