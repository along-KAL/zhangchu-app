

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

import java.util.List;

import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_COMMONSENSE_HEADER_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_COMMONSENSE_MATERIAL_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_HEADER_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_SECOUND_COUNT;

/**
 * Created by kongalong on 2016/12/12.
 */
public class CourseDetailCommonSenseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<Object> mData;
    public CourseDetailCommonSenseAdapter(Context context,
                                           List<Object> data) {

        this.mContext = context;
        this.mData = data;

    }

    public int getItemViewType(int position) {

        if(position == 0){
            return HAPPYLIFE_COURSEDETAIL_COMMONSENSE_HEADER_COUNT;
        }else {
            return HAPPYLIFE_COURSEDETAIL_COMMONSENSE_MATERIAL_COUNT;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch(viewType){

            //头布局
            case HAPPYLIFE_COURSEDETAIL_COMMONSENSE_HEADER_COUNT:

                return new CourseDetailCommonSenseAdapter.ViewHolder1(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail_commonsense_header_item, parent,false));


            //
            case HAPPYLIFE_COURSEDETAIL_COMMONSENSE_MATERIAL_COUNT:

                return new CourseDetailCommonSenseAdapter.ViewHolder2(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail__commonsense_another, parent,false));



            default:
                return null;

        }


    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);


        switch(itemViewType){
            //头布局
            case HAPPYLIFE_COURSEDETAIL_HEADER_COUNT:

                CourseDetailCommonSenseAdapter.ViewHolder1 holder1 = (CourseDetailCommonSenseAdapter.ViewHolder1)holder;
                //获取header图片并显示
                Glide.with(mContext)
                        .load((String)mData.get(position))
                        .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .crossFade()
                        .into(holder1.mMainImage);


                break;
            //
            case HAPPYLIFE_COURSEDETAIL_SECOUND_COUNT:
                CourseDetailCommonSenseAdapter.ViewHolder2 holder2 = (CourseDetailCommonSenseAdapter.ViewHolder2)holder;


                if(position==1){
                    holder2.mTitleText.setText("相关常识");

                    holder2.mContentText.setText((String)mData.get(position));
                }else{
                    holder2.mTitleText.setText("制作指导");

                    holder2.mContentText.setText((String)mData.get(position));

                }



                break;


            default:
                break;
        }


    }



    @Override
    public int getItemCount() {
        //返回数据总的大小
        return mData.size();
    }


    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView mMainImage;



        public ViewHolder1(View itemView) {
            super(itemView);

            mMainImage =  (ImageView) itemView.findViewById(R.id.happylife_coursedetail_commonsense_header_image);

        }
    }


    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView mTitleText;
        private  TextView mContentText;


        public ViewHolder2(View itemView) {
            super(itemView);

            mTitleText = (TextView) itemView.findViewById(R.id.happylife_coursedetail__commonsense_another_title);
            mContentText = (TextView) itemView.findViewById(R.id.happylife_coursedetail__commonsense_another_content);
        }
    }



}



