package com.example.group.zhangchu.beans;

/**
 * Created by kongalong on 2016/12/18.
 */

public class HappyLifeRelateCommonSenseBean {


    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1482054799000
     * data : {"nutrition_analysis":"虾仁含有蛋白质、维生素A、氨茶碱、钾、碘、镁、磷等营养成分，具有增强免疫力、补肾壮阳、理气开胃等功效。","production_direction":"封口时也可用牙签固定住，这样生坯就不容易散开。","image":"http://img.szzhangchu.com/20141107092335643.jpg"}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    /**
     * nutrition_analysis : 虾仁含有蛋白质、维生素A、氨茶碱、钾、碘、镁、磷等营养成分，具有增强免疫力、补肾壮阳、理气开胃等功效。
     * production_direction : 封口时也可用牙签固定住，这样生坯就不容易散开。
     * image : http://img.szzhangchu.com/20141107092335643.jpg
     */

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
