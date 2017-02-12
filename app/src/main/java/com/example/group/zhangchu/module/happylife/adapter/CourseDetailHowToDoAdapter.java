package com.example.group.zhangchu.module.happylife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.beans.HappyLifeCourseDetailBean;

import java.util.List;

/**
 * Created by kongalong on 2016/12/18.
 */

/**
 * Created by kongalong on 2016/12/12.
 */
public class CourseDetailHowToDoAdapter extends RecyclerView.Adapter<CourseDetailHowToDoAdapter.ViewHolder>{

    private Context mContext;
    private List<HappyLifeCourseDetailBean.DataBean.StepBean> mData;

    public CourseDetailHowToDoAdapter(Context context,
                                      List<HappyLifeCourseDetailBean.DataBean.StepBean> data) {

        this.mContext = context;
        this.mData = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.coursedetail_howtodo_item, parent,false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mData.get(position).getDishes_step_image())
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.mMainImage);


        holder.mText.setText(mData.get(position).getDishes_step_desc());

    }



    @Override
    public int getItemCount() {

        return mData== null? 0:mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mMainImage;
        private  TextView mText;

        public ViewHolder(View itemView) {
            super(itemView);

            mMainImage =  (ImageView) itemView.findViewById(R.id.coursedetail_howtodo_image);
            mText = (TextView) itemView.findViewById(R.id.coursedetail_howtodo_text);

        }
    }

}
