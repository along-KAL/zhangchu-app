
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
import com.example.group.zhangchu.beans.HappyLifeXiangKeXiangYiBean;

import java.util.List;

import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_XIANGYIXIANGKE_HEADER_COUNT;
import static com.example.group.zhangchu.common.constant.Constant.HAPPYLIFE_COURSEDETAIL_XIANGYIXIANGKE_SUIT_COUNT;

/**
 * Created by kongalong on 2016/12/12.
 */
public class CourseDetailXiangKeXiangYiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<Object> mData;
    private List<Integer> mSize;
    public CourseDetailXiangKeXiangYiAdapter(Context context,
                                          List<Object> data, List<Integer> size) {

        this.mContext = context;
        this.mData = data;
        this.mSize = size;

    }

    public int getItemViewType(int position) {

        if(position == 0){
            return HAPPYLIFE_COURSEDETAIL_XIANGYIXIANGKE_HEADER_COUNT;
        }else {
            return HAPPYLIFE_COURSEDETAIL_XIANGYIXIANGKE_SUIT_COUNT;

        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch(viewType){

            //头布局
            case HAPPYLIFE_COURSEDETAIL_XIANGYIXIANGKE_HEADER_COUNT:

                return new CourseDetailXiangKeXiangYiAdapter.ViewHolder1(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail_commonsense_header_item, parent,false));


            //
            case HAPPYLIFE_COURSEDETAIL_XIANGYIXIANGKE_SUIT_COUNT:

                return new CourseDetailXiangKeXiangYiAdapter.ViewHolder2(LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.happylife_coursedetail_xiangkexiangyi_another, parent,false));


            default:
                return null;

        }

        /**
         * 事件分发机制原理
         * view绘制原理
         * 动画原理
         * 消息机制原理
         * intentService原理
         * handlerThread原理
         *
         *
         */

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);

        HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean materialBean =
                (HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean) mData.get(0);

        switch(itemViewType){
            //头布局
            case HAPPYLIFE_COURSEDETAIL_XIANGYIXIANGKE_HEADER_COUNT:

                CourseDetailXiangKeXiangYiAdapter.ViewHolder1 holder1 = (CourseDetailXiangKeXiangYiAdapter.ViewHolder1)holder;
                //获取header图片并显示
                Glide.with(mContext)
                        .load(materialBean.getImage())
                        .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .crossFade()
                        .into(holder1.mMainImage);


                break;
            //
            case HAPPYLIFE_COURSEDETAIL_XIANGYIXIANGKE_SUIT_COUNT:
                CourseDetailXiangKeXiangYiAdapter.ViewHolder2 holder2 = (CourseDetailXiangKeXiangYiAdapter.ViewHolder2)holder;
               /* List<HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean
                        .SuitableWithBean> suitableData = (List<HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean
                        .SuitableWithBean>)mData.get(1);
                List<HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean
                        .SuitableNotWithBean> notSuitableData = (List<HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean
                        .SuitableNotWithBean>)mData.get(2);*/

                if(position==1){
                    holder2.mTitleText.setVisibility(View.VISIBLE);
                    holder2.mTitleText.setText("与"+materialBean.getMaterial_name()+"搭配相宜的食材");

                }else if(mSize.get(0)==position){

                    holder2.mTitleText.setVisibility(View.VISIBLE);
                    holder2.mTitleText.setText("与"+materialBean.getMaterial_name()+"搭配相克的食材");

                }else{
                    holder2.mTitleText.setVisibility(View.GONE);
                }

                if(mData.get(position) instanceof HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean
                        .SuitableWithBean ){
                    HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean
                            .SuitableWithBean data = (HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean
                            .SuitableWithBean)mData.get(position);
                    //获取header图片并显示
                    Glide.with(mContext)
                            .load(data.getImage())
                            .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher)
                            .crossFade()
                            .into(holder2.mIconImage);

                    holder2.mNameText.setText(data.getMaterial_name());
                    holder2.mDescText.setText(data.getSuitable_desc());


                }else{
                    HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean
                            .SuitableNotWithBean data = (HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean
                            .SuitableNotWithBean)mData.get(position);

                    //获取header图片并显示
                    Glide.with(mContext)
                            .load(data.getImage())
                            .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher)
                            .crossFade()
                            .into(holder2.mIconImage);

                    holder2.mNameText.setText(data.getMaterial_name());
                    holder2.mDescText.setText(data.getSuitable_desc());
                }



            default:
                break;
        }


    }



    @Override
    public int getItemCount() {
        //返回数据总的大小

        return  mData.size();
      /*  return  mData.size()!=0?((List<HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean.SuitableWithBean>)
                mData.get(1)).size()+((List<HappyLifeXiangKeXiangYiBean.DataBean.MaterialBean.SuitableNotWithBean>)
                mData.get(2)).size()+1:0;*/
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
        private ImageView mIconImage;
        private  TextView mNameText;
        private  TextView mDescText;



        public ViewHolder2(View itemView) {
            super(itemView);

            mTitleText = (TextView) itemView.findViewById(R.id.happylife_coursedetail_xiangkexiangyi_title);
            mIconImage = (ImageView) itemView.findViewById(R.id.happylife_coursedetail_xiangkexiangyi_icon);
            mNameText = (TextView) itemView.findViewById(R.id.happylife_coursedetail_xiangkexiangyi_name);
            mDescText = (TextView) itemView.findViewById(R.id.happylife_coursedetail_xiangkexiangyi_desc);
        }
    }



}



