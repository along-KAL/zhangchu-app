package com.example.group.zhangchu.beans;

import java.util.List;

/**
 * Created by kongalong on 2016/12/18.
 */

public class HappyLifeXiangKeXiangYiBean {


    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1482056696000
     * data : {"material":{"material_id":"167","material_name":"虾","image":"http://img.szzhangchu.com/20141107092335643.jpg","suitable_with":[{"material_id":"805","material_name":"西兰花","type":"0","suitable_desc":"补脾和胃、补肾固精","image":"http://img.szzhangchu.com/20130118163338_0.jpg"},{"material_id":"178","material_name":"海带","type":"0","suitable_desc":"补钙、防癌","image":"http://img.szzhangchu.com/20141107100420285.jpg"}],"suitable_not_with":[{"material_id":"823","material_name":"茶","type":"1","suitable_desc":"引起结石","image":"http://img.szzhangchu.com/20130118172922_0.jpg"},{"material_id":"191","material_name":"橙子","type":"1","suitable_desc":"产生毒素","image":"http://img.szzhangchu.com/20150413110622767.jpg"}]}}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    /**
     * material : {"material_id":"167","material_name":"虾","image":"http://img.szzhangchu.com/20141107092335643.jpg","suitable_with":[{"material_id":"805","material_name":"西兰花","type":"0","suitable_desc":"补脾和胃、补肾固精","image":"http://img.szzhangchu.com/20130118163338_0.jpg"},{"material_id":"178","material_name":"海带","type":"0","suitable_desc":"补钙、防癌","image":"http://img.szzhangchu.com/20141107100420285.jpg"}],"suitable_not_with":[{"material_id":"823","material_name":"茶","type":"1","suitable_desc":"引起结石","image":"http://img.szzhangchu.com/20130118172922_0.jpg"},{"material_id":"191","material_name":"橙子","type":"1","suitable_desc":"产生毒素","image":"http://img.szzhangchu.com/20150413110622767.jpg"}]}
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
        /**
         * material_id : 167
         * material_name : 虾
         * image : http://img.szzhangchu.com/20141107092335643.jpg
         * suitable_with : [{"material_id":"805","material_name":"西兰花","type":"0","suitable_desc":"补脾和胃、补肾固精","image":"http://img.szzhangchu.com/20130118163338_0.jpg"},{"material_id":"178","material_name":"海带","type":"0","suitable_desc":"补钙、防癌","image":"http://img.szzhangchu.com/20141107100420285.jpg"}]
         * suitable_not_with : [{"material_id":"823","material_name":"茶","type":"1","suitable_desc":"引起结石","image":"http://img.szzhangchu.com/20130118172922_0.jpg"},{"material_id":"191","material_name":"橙子","type":"1","suitable_desc":"产生毒素","image":"http://img.szzhangchu.com/20150413110622767.jpg"}]
         */

        private MaterialBean material;

        public MaterialBean getMaterial() {
            return material;
        }

        public void setMaterial(MaterialBean material) {
            this.material = material;
        }

        public static class MaterialBean {
            private String material_id;
            private String material_name;
            private String image;
            /**
             * material_id : 805
             * material_name : 西兰花
             * type : 0
             * suitable_desc : 补脾和胃、补肾固精
             * image : http://img.szzhangchu.com/20130118163338_0.jpg
             */

            private List<SuitableWithBean> suitable_with;
            /**
             * material_id : 823
             * material_name : 茶
             * type : 1
             * suitable_desc : 引起结石
             * image : http://img.szzhangchu.com/20130118172922_0.jpg
             */

            private List<SuitableNotWithBean> suitable_not_with;

            public String getMaterial_id() {
                return material_id;
            }

            public void setMaterial_id(String material_id) {
                this.material_id = material_id;
            }

            public String getMaterial_name() {
                return material_name;
            }

            public void setMaterial_name(String material_name) {
                this.material_name = material_name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public List<SuitableWithBean> getSuitable_with() {
                return suitable_with;
            }

            public void setSuitable_with(List<SuitableWithBean> suitable_with) {
                this.suitable_with = suitable_with;
            }

            public List<SuitableNotWithBean> getSuitable_not_with() {
                return suitable_not_with;
            }

            public void setSuitable_not_with(List<SuitableNotWithBean> suitable_not_with) {
                this.suitable_not_with = suitable_not_with;
            }

            public static class SuitableWithBean {
                private String material_id;
                private String material_name;
                private String type;
                private String suitable_desc;
                private String image;

                public String getMaterial_id() {
                    return material_id;
                }

                public void setMaterial_id(String material_id) {
                    this.material_id = material_id;
                }

                public String getMaterial_name() {
                    return material_name;
                }

                public void setMaterial_name(String material_name) {
                    this.material_name = material_name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getSuitable_desc() {
                    return suitable_desc;
                }

                public void setSuitable_desc(String suitable_desc) {
                    this.suitable_desc = suitable_desc;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }

            public static class SuitableNotWithBean {
                private String material_id;
                private String material_name;
                private String type;
                private String suitable_desc;
                private String image;

                public String getMaterial_id() {
                    return material_id;
                }

                public void setMaterial_id(String material_id) {
                    this.material_id = material_id;
                }

                public String getMaterial_name() {
                    return material_name;
                }

                public void setMaterial_name(String material_name) {
                    this.material_name = material_name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getSuitable_desc() {
                    return suitable_desc;
                }

                public void setSuitable_desc(String suitable_desc) {
                    this.suitable_desc = suitable_desc;
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
}
