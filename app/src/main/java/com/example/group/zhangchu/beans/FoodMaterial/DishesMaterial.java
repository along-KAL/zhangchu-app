package com.example.group.zhangchu.beans.FoodMaterial;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 *
 * 这是三级接口食材Fragment的数据
 */

public class DishesMaterial {


    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1481851731000
     * data : {"material_image":"http://img.szzhangchu.com/1464435455459_8252485996.jpg","material":[{"material_name":"菠菜","material_weight":"60克"},{"material_name":"猪肝","material_weight":"120克"},{"material_name":"红枣","material_weight":"70克"},{"material_name":"花生米","material_weight":"35克"},{"material_name":"桂圆肉","material_weight":"100克"},{"material_name":"熟红腰豆","material_weight":"100克"},{"material_name":"黑芝麻","material_weight":"2.5克"},{"material_name":"姜丝","material_weight":"7克"},{"material_name":"葱花","material_weight":"2克"},{"material_name":"盐","material_weight":"6克"},{"material_name":"食用油适量,生抽","material_weight":"15毫升"},{"material_name":"料酒","material_weight":"15毫升"},{"material_name":"陈醋","material_weight":"15毫升"},{"material_name":"芝麻油","material_weight":"5毫升"},{"material_name":"黑胡椒","material_weight":"4克"}],"spices":[{"title":"黑胡椒","image":"http://img.szzhangchu.com/1447334061698_2803873973.JPG"},{"title":"生抽","image":"http://img.szzhangchu.com/1446302250672_3857195729.jpg"},{"title":"料酒","image":"http://img.szzhangchu.com/1439278701254_6067208209.jpg"},{"title":"食用油","image":"http://img.szzhangchu.com/1439279020793_1063836165.jpg"},{"title":"陈醋","image":"http://img.szzhangchu.com/1439279401525_5896244135.jpg"},{"title":"盐","image":"http://img.szzhangchu.com/1446302300109_3829074140.jpg"},{"title":"芝麻油","image":"http://img.szzhangchu.com/1439349315745_4844927170.jpg"}]}
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
         * material_image : http://img.szzhangchu.com/1464435455459_8252485996.jpg
         * material : [{"material_name":"菠菜","material_weight":"60克"},{"material_name":"猪肝","material_weight":"120克"},{"material_name":"红枣","material_weight":"70克"},{"material_name":"花生米","material_weight":"35克"},{"material_name":"桂圆肉","material_weight":"100克"},{"material_name":"熟红腰豆","material_weight":"100克"},{"material_name":"黑芝麻","material_weight":"2.5克"},{"material_name":"姜丝","material_weight":"7克"},{"material_name":"葱花","material_weight":"2克"},{"material_name":"盐","material_weight":"6克"},{"material_name":"食用油适量,生抽","material_weight":"15毫升"},{"material_name":"料酒","material_weight":"15毫升"},{"material_name":"陈醋","material_weight":"15毫升"},{"material_name":"芝麻油","material_weight":"5毫升"},{"material_name":"黑胡椒","material_weight":"4克"}]
         * spices : [{"title":"黑胡椒","image":"http://img.szzhangchu.com/1447334061698_2803873973.JPG"},{"title":"生抽","image":"http://img.szzhangchu.com/1446302250672_3857195729.jpg"},{"title":"料酒","image":"http://img.szzhangchu.com/1439278701254_6067208209.jpg"},{"title":"食用油","image":"http://img.szzhangchu.com/1439279020793_1063836165.jpg"},{"title":"陈醋","image":"http://img.szzhangchu.com/1439279401525_5896244135.jpg"},{"title":"盐","image":"http://img.szzhangchu.com/1446302300109_3829074140.jpg"},{"title":"芝麻油","image":"http://img.szzhangchu.com/1439349315745_4844927170.jpg"}]
         */

        private String material_image;
        private List<MaterialBean> material;
        private List<SpicesBean> spices;

        public String getMaterial_image() {
            return material_image;
        }

        public void setMaterial_image(String material_image) {
            this.material_image = material_image;
        }

        public List<MaterialBean> getMaterial() {
            return material;
        }

        public void setMaterial(List<MaterialBean> material) {
            this.material = material;
        }

        public List<SpicesBean> getSpices() {
            return spices;
        }

        public void setSpices(List<SpicesBean> spices) {
            this.spices = spices;
        }

        public static class MaterialBean {
            /**
             * material_name : 菠菜
             * material_weight : 60克
             */

            private String material_name;
            private String material_weight;

            public String getMaterial_name() {
                return material_name;
            }

            public void setMaterial_name(String material_name) {
                this.material_name = material_name;
            }

            public String getMaterial_weight() {
                return material_weight;
            }

            public void setMaterial_weight(String material_weight) {
                this.material_weight = material_weight;
            }
        }

        public static class SpicesBean {
            /**
             * title : 黑胡椒
             * image : http://img.szzhangchu.com/1447334061698_2803873973.JPG
             */

            private String title;
            private String image;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
