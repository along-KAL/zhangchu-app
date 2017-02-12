package com.example.group.zhangchu.utils;

import com.example.group.zhangchu.beans.CookBookBean;
import com.example.group.zhangchu.beans.HappLifeCateLogoBean;
import com.example.group.zhangchu.beans.HappyLifeCateBean;
import com.example.group.zhangchu.beans.HappyLifeCateCommentListBean;
import com.example.group.zhangchu.beans.HappyLifeCateCourseRelateBean;
import com.example.group.zhangchu.beans.HappyLifeCateDetailBean;
import com.example.group.zhangchu.beans.HappyLifeCateZanBean;
import com.example.group.zhangchu.beans.HappyLifeCourseDetailBean;
import com.example.group.zhangchu.beans.HappyLifeCourseDetailFoodMaterialBean;
import com.example.group.zhangchu.beans.HappyLifeRelateCommonSenseBean;
import com.example.group.zhangchu.beans.HappyLifeXiangKeXiangYiBean;
import com.google.gson.Gson;

/**
 * Created by kongalong on 2016/12/12.
 */

public class JsonUtil {



    /**
     * 美食IP  数据解析
     */
    public static HappyLifeCateBean parseJsonToHappyLifeCateIPBeans(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeCateBean.class);

    }

    /**
     * 美食IP logo  数据解析
     */
    public static HappLifeCateLogoBean parseJsonToHappLifeCateIPLogoBeans(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappLifeCateLogoBean.class);

    }

    /**
     * 美食IP 详情页面  数据解析
     */
    public static HappyLifeCateDetailBean parseJsonToHappyLifeCateDetailBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeCateDetailBean.class);

    }
    /**
     * 美食IP 详情页面  数据解析
     */
    public static HappyLifeCateZanBean parseJsonToHappyLifeCateZanBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeCateZanBean.class);

    }
    /**
     * 美食IP 详情页面  数据解析
     */
    public static HappyLifeCateCourseRelateBean parseJsonToHappyLifeCateCourseRelateBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeCateCourseRelateBean.class);

    }
    /**
     * 美食IP 详情页面  数据解析
     */
    public static HappyLifeCateCommentListBean parseJsonToHappyLifeCateCommentListBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeCateCommentListBean.class);

    }


    /**
     * 美食IP coursedetail  数据解析
     */
    public static HappyLifeCourseDetailBean parseJsonToHappyLifeCourseDetailBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeCourseDetailBean.class);

    }

    /**
     * 美食IP coursedetail food_material  数据解析
     */
    public static HappyLifeCourseDetailFoodMaterialBean parseJsonToHappyLifeCourseDetailFoodMaterialBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeCourseDetailFoodMaterialBean.class);

    }
    /**
     * 美食IP coursedetail commomsense  数据解析
     */
    public static HappyLifeRelateCommonSenseBean parseJsonToHappyLifeRelateCommonSenseBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeRelateCommonSenseBean.class);

    }
    /**
     * 美食IP coursedetail commomsense  数据解析
     */
    public static HappyLifeXiangKeXiangYiBean parseJsonToHappyLifeXiangKeXiangYiBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeXiangKeXiangYiBean.class);

    }


    /**
     * CookBookBean  数据解析
     */
    public static CookBookBean parseJsonToCookBookBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, CookBookBean.class);

    }











}
