package com.example.group.zhangchu.beans;

import java.util.List;

/**
 * Created by kongalong on 2016/12/18.
 */

public class HappyLifeCourseDetailFoodMaterialBean {


    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1482051397000
     * data : {"material_image":"http://img.szzhangchu.com/ylzt_20140730100056204.jpg","material":[{"material_name":"鸡蛋","material_weight":"4个"},{"material_name":"紫菜","material_weight":"25克"},{"material_name":"虾仁","material_weight":"65克"},{"material_name":"胡萝卜","material_weight":"55克"},{"material_name":"芹菜","material_weight":"35克"},{"material_name":"盐、鸡粉","material_weight":"各2克"},{"material_name":"白糖","material_weight":"3克"},{"material_name":"料酒","material_weight":"4毫升"},{"material_name":"生粉、水淀粉、食用油","material_weight":"各适量"}],"spices":[{"title":"料酒","image":"http://img.szzhangchu.com/1439278701254_6067208209.jpg"},{"title":"鸡粉","image":"http://img.szzhangchu.com/1447334138022_2974659229.JPG"},{"title":"食用油","image":"http://img.szzhangchu.com/1439279020793_1063836165.jpg"},{"title":"盐","image":"http://img.szzhangchu.com/1446302300109_3829074140.jpg"},{"title":"水淀粉","image":"http://img.szzhangchu.com/1439279768833_9900185974.jpg"},{"title":"白糖","image":"http://img.szzhangchu.com/1445083290679_7713822686.jpg"},{"title":"淀粉（生粉）","image":"http://img.szzhangchu.com/1439343397675_6551778597.jpg"}]}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    /**
     * material_image : http://img.szzhangchu.com/ylzt_20140730100056204.jpg
     * material : [{"material_name":"鸡蛋","material_weight":"4个"},{"material_name":"紫菜","material_weight":"25克"},{"material_name":"虾仁","material_weight":"65克"},{"material_name":"胡萝卜","material_weight":"55克"},{"material_name":"芹菜","material_weight":"35克"},{"material_name":"盐、鸡粉","material_weight":"各2克"},{"material_name":"白糖","material_weight":"3克"},{"material_name":"料酒","material_weight":"4毫升"},{"material_name":"生粉、水淀粉、食用油","material_weight":"各适量"}]
     * spices : [{"title":"料酒","image":"http://img.szzhangchu.com/1439278701254_6067208209.jpg"},{"title":"鸡粉","image":"http://img.szzhangchu.com/1447334138022_2974659229.JPG"},{"title":"食用油","image":"http://img.szzhangchu.com/1439279020793_1063836165.jpg"},{"title":"盐","image":"http://img.szzhangchu.com/1446302300109_3829074140.jpg"},{"title":"水淀粉","image":"http://img.szzhangchu.com/1439279768833_9900185974.jpg"},{"title":"白糖","image":"http://img.szzhangchu.com/1445083290679_7713822686.jpg"},{"title":"淀粉（生粉）","image":"http://img.szzhangchu.com/1439343397675_6551778597.jpg"}]
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
        private String material_image;
        /**
         * material_name : 鸡蛋
         * material_weight : 4个
         */

        private List<MaterialBean> material;
        /**
         * title : 料酒
         * image : http://img.szzhangchu.com/1439278701254_6067208209.jpg
         */

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
