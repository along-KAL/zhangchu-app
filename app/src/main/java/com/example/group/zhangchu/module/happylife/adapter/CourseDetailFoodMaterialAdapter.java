

package com.example.group.zhangchu.module.happylife.adapter;

        import android.content.Context;
import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.group.zhangchu.R;
import com.example.group.zhangchu.beans.HappyLifeCourseDetailFoodMaterialBean;

import java.util.List;

import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_FOODMATERIAL_HEADER_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_FOODMATERIAL_MATERIAL_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_FOODMATERIAL_SPICES_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_HEADER_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_SECOUND_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_VP_COUNT;

/**
 * Created by kongalong on 2016/12/12.
 */
public class CourseDetailFoodMaterialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<Object> mData;
    public CourseDetailFoodMaterialAdapter(Context context,
                                           List<Object> data) {

        this.mContext = context;
        this.mData = data;

    }

    public int getItemViewType(int position) {

        if(position == 0){
            return HAPPYLIFE_COURSEDETAIL_FOODMATERIAL_HEADER_COUNT;
        }else if(position>0&&position<((List<HappyLifeCourseDetailFoodMaterialBean.DataBean.MaterialBean>)
                mData.get(1)).size()+1){
            return HAPPYLIFE_COURSEDETAIL_FOODMATERIAL_MATERIAL_COUNT;
        }else{
            return HAPPYLIFE_COURSEDETAIL_FOODMATERIAL_SPICES_COUNT;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch(viewType){

            //头布局
            case HAPPYLIFE_COURSEDETAIL_FOODMATERIAL_HEADER_COUNT:

                return new CourseDetailFoodMaterialAdapter.ViewHolder1(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail_foodmaterial_header_item, parent,false));


            //
            case HAPPYLIFE_COURSEDETAIL_FOODMATERIAL_MATERIAL_COUNT:

                return new CourseDetailFoodMaterialAdapter.ViewHolder2(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail__foodmaterial_material_item, parent,false));


            //VP
            case HAPPYLIFE_COURSEDETAIL_FOODMATERIAL_SPICES_COUNT:

                return new CourseDetailFoodMaterialAdapter.ViewHolder3(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail__foodmaterial_spices_item, parent,false));



            default:
                return null;

        }


    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);

        Log.d("flag", "onBindViewHolder: " +position);
        switch(itemViewType){
            //头布局
            case HAPPYLIFE_COURSEDETAIL_HEADER_COUNT:

                CourseDetailFoodMaterialAdapter.ViewHolder1 holder1 = (CourseDetailFoodMaterialAdapter.ViewHolder1)holder;
                //获取header图片并显示
                Glide.with(mContext)
                        .load((String)mData.get(0))
                        .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .crossFade()
                        .into(holder1.mMainImage);


                break;
            //
            case HAPPYLIFE_COURSEDETAIL_SECOUND_COUNT:

                CourseDetailFoodMaterialAdapter.ViewHolder2 holder2 = (CourseDetailFoodMaterialAdapter.ViewHolder2)holder;

                holder2.mNameText.setText(((List<HappyLifeCourseDetailFoodMaterialBean
                        .DataBean.MaterialBean>)mData.get(1)).get(position-1)
                        .getMaterial_name());

                holder2.mNameText.setText(((List<HappyLifeCourseDetailFoodMaterialBean
                        .DataBean.MaterialBean>)mData.get(1)).get(position-1)
                        .getMaterial_weight());

                break;
            //Vp
            case HAPPYLIFE_COURSEDETAIL_VP_COUNT:

                CourseDetailFoodMaterialAdapter.ViewHolder3 holder3 = (CourseDetailFoodMaterialAdapter.ViewHolder3)holder;

                //获取header图片并显示
                Glide.with(mContext)
                        .load(((List<HappyLifeCourseDetailFoodMaterialBean
                                .DataBean.SpicesBean>)mData.get(2))
                                .get(position-
                                        ((List<HappyLifeCourseDetailFoodMaterialBean
                                .DataBean.MaterialBean>)mData.get(1))
                                .size()-1).getImage())
                        .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .crossFade()
                        .into(holder3.mImage);

                holder3.mText.setText(((List<HappyLifeCourseDetailFoodMaterialBean
                        .DataBean.SpicesBean>)mData.get(2)).get(position-
                        ((List<HappyLifeCourseDetailFoodMaterialBean
                                .DataBean.MaterialBean>)mData.get(1))
                                .size()-1)
                        .getTitle());



                break;


            default:
                break;
        }


    }



    @Override
    public int getItemCount() {
        //返回数据总的大小

        if(mData.size() == 2){
            return mData.size()!=0?((List<HappyLifeCourseDetailFoodMaterialBean.DataBean.MaterialBean>)
                    mData.get(1)).size()+1:0;
        }else if(mData.size() == 1){

                return mData.size()!=0?((List<HappyLifeCourseDetailFoodMaterialBean.DataBean.MaterialBean>)
                        mData.get(1)).size()+((List<HappyLifeCourseDetailFoodMaterialBean.DataBean.SpicesBean>)
                        mData.get(2)).size()+1:0;

        }else{
            return 0;
        }

    }


    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView mMainImage;



        public ViewHolder1(View itemView) {
            super(itemView);

            mMainImage =  (ImageView) itemView.findViewById(R.id.happylife_coursedetail_foodmaterial_header_image);

        }
    }


    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView mNameText;
        private  TextView mCountText;


        public ViewHolder2(View itemView) {
            super(itemView);

            mNameText = (TextView) itemView.findViewById(R.id.happylife_coursedetail__foodmaterial_material_text1);
            mCountText = (TextView) itemView.findViewById(R.id.happylife_coursedetail__foodmaterial_material_text2);
        }
    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder {

        private ImageView mImage;

        private TextView mText;

        public ViewHolder3(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.happylife_coursedetail__foodmaterial_spices_image);
            mText = (TextView) itemView.findViewById(R.id.happylife_coursedetail__foodmaterial_spices_text);
        }
    }

}


