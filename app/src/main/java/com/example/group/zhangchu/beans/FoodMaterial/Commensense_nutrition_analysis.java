package com.example.group.zhangchu.beans.FoodMaterial;

/**
 * Created by Administrator on 2016/12/15.
 *
 * 这是相关常识的Fragment的数据类
 */

public class Commensense_nutrition_analysis {


    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1481792321000
     * data : {"nutrition_analysis":"菠菜有个优美的名字，在古代称之为\u201c红嘴绿鹦哥\u201d，\u201c红嘴\u201d指微红色的根部。菠菜除了别称美，营养价值也高，含有丰富的叶绿素、膳食纤维、维生素A、维生素K、铁元素等营养成分，具有补铁补血、润肠通便、提高免疫力等作用。","production_direction":"发酵时间可以延长至3个月或更久，酵素味道更佳。","image":""}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nutrition_analysis : 菠菜有个优美的名字，在古代称之为“红嘴绿鹦哥”，“红嘴”指微红色的根部。菠菜除了别称美，营养价值也高，含有丰富的叶绿素、膳食纤维、维生素A、维生素K、铁元素等营养成分，具有补铁补血、润肠通便、提高免疫力等作用。
         * production_direction : 发酵时间可以延长至3个月或更久，酵素味道更佳。
         * image :
         */

        private String nutrition_analysis;
        private String production_direction;
        private String image;

        public String getNutrition_analysis() {
            return nutrition_analysis;
        }

        public void setNutrition_analysis(String nutrition_analysis) {
            this.nutrition_analysis = nutrition_analysis;
        }

        public String getProduction_direction() {
            return production_direction;
        }

        public void setProduction_direction(String production_direction) {
            this.production_direction = production_direction;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
