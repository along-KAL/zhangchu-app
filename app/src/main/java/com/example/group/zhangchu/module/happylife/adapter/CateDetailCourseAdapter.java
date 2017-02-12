package com.example.group.zhangchu.module.happylife.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.beans.HappyLifeCateCourseRelateBean;
import com.example.group.zhangchu.common.activitys.VideoActivity;
import com.example.group.zhangchu.module.happylife.activitys.CourseDetailActivity;

import java.util.List;

/**
 * Created by kongalong on 2016/12/12.
 */
public class CateDetailCourseAdapter extends RecyclerView.Adapter<CateDetailCourseAdapter.ViewHolder> implements View.OnClickListener{

    Context mContext;
    List<HappyLifeCateCourseRelateBean.DataBean.DataBean1> mAlbumList;

    public CateDetailCourseAdapter(Context context , List<HappyLifeCateCourseRelateBean.DataBean.DataBean1>
                                   albumList) {
        this.mContext = context;
        this.mAlbumList = albumList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.happylife_cate_detail_course_item, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //为item设置点击事件
        int id = 9;
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(mAlbumList.get(position));
        holder.itemView.setId(R.id.detail_course_item);

        //加载圆形图片
        Glide.with(mContext)
                .load(mAlbumList.get(position).getRelation().getDishes_image())
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.mImageView);

        //为view设置监听
        holder.mPlayImageView.setOnClickListener(this);
        //为view设置tag，在点击事件获取data
        holder.mPlayImageView.setTag(holder.mPlayImageView.getId(),mAlbumList.get(position));

        holder.mTitleText.setText(mAlbumList.get(position).getRelation().getDishes_title());
    }

    @Override
    public int getItemCount() {

        return mAlbumList.size();
    }

   // private OnRecycleViewItemOnClickListener mOnRecycleViewItemOnClickListener;

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.detail_course_item){

            String dishes_id = ((HappyLifeCateCourseRelateBean.DataBean.DataBean1)
                    v.getTag()).getRelation().getDishes_id();
            //跳转课程activity
            Intent intent = new Intent(mContext, CourseDetailActivity.class);
            intent.putExtra("dishes_id",dishes_id);
            mContext.startActivity(intent);
        }else{
            HappyLifeCateCourseRelateBean.DataBean.DataBean1.RelationBean relation
                    = ((HappyLifeCateCourseRelateBean.DataBean.DataBean1)
                    v.getTag(v.getId())).getRelation();

            Intent intent=new Intent(mContext, VideoActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("video", relation.getMaterial_video());
            bundle.putString("image", relation.getDishes_image());
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }

    }

 /*   //为view设置监听事件
    public void setOnRecycleItemOnClickListener
    (OnRecycleViewItemOnClickListener onRecycleItemOnClickListener){
        this.mOnRecycleViewItemOnClickListener = onRecycleItemOnClickListener;
    }*/



    public static class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView mImageView;
        private ImageView mPlayImageView;
        private TextView mTitleText;

        public ViewHolder(View itemView) {

            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.happylife_detail_course_image);
            mPlayImageView = (ImageView) itemView.findViewById(R.id.happylife_detail_course_play_image);
            mTitleText = (TextView) itemView.findViewById(R.id.happylife_detail_course_title_text);
        }

    }

 /*   //自定义监听接口
    public interface OnRecycleViewItemOnClickListener{

        void onItemClick(View view, HappLifeCateLogoBean.DataBean.AlbumsBean data);

    }*/



}
