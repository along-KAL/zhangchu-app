package com.example.group.zhangchu.beans.FoodMaterial;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 *
 * 这是三级界面食材相宜相克的数据类
 */

public class MaterialSuitable {


    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1481856107000
     * data : {"material":{"material_id":"106","material_name":"猪肝","image":"http://img.szzhangchu.com/20150413102824670.jpg","suitable_with":[{"material_id":"4","material_name":"奶白菜","type":"0","suitable_desc":"保肝护肾","image":"http://img.szzhangchu.com/20150418102923296.jpg"},{"material_id":"776","material_name":"咖啡","type":"0","suitable_desc":"清热解毒、补肝明目","image":"http://img.szzhangchu.com/1442386633751_1128557220.jpg"}],"suitable_not_with":[{"material_id":"44","material_name":"山药","type":"1","suitable_desc":"破坏维生素C","image":"http://img.szzhangchu.com/20141107102023496.jpg"},{"material_id":"187","material_name":"山楂","type":"1","suitable_desc":"破坏维生素C","image":"http://img.szzhangchu.com/20150518162713869.jpg"}]}}
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
         * material : {"material_id":"106","material_name":"猪肝","image":"http://img.szzhangchu.com/20150413102824670.jpg","suitable_with":[{"material_id":"4","material_name":"奶白菜","type":"0","suitable_desc":"保肝护肾","image":"http://img.szzhangchu.com/20150418102923296.jpg"},{"material_id":"776","material_name":"咖啡","type":"0","suitable_desc":"清热解毒、补肝明目","image":"http://img.szzhangchu.com/1442386633751_1128557220.jpg"}],"suitable_not_with":[{"material_id":"44","material_name":"山药","type":"1","suitable_desc":"破坏维生素C","image":"http://img.szzhangchu.com/20141107102023496.jpg"},{"material_id":"187","material_name":"山楂","type":"1","suitable_desc":"破坏维生素C","image":"http://img.szzhangchu.com/20150518162713869.jpg"}]}
         */

        private MaterialBean material;

        public MaterialBean getMaterial() {
            return material;
        }

        public void setMaterial(MaterialBean material) {
            this.material = material;
        }

        public static class MaterialBean {
            /**
             * material_id : 106
             * material_name : 猪肝
             * image : http://img.szzhangchu.com/20150413102824670.jpg
             * suitable_with : [{"material_id":"4","material_name":"奶白菜","type":"0","suitable_desc":"保肝护肾","image":"http://img.szzhangchu.com/20150418102923296.jpg"},{"material_id":"776","material_name":"咖啡","type":"0","suitable_desc":"清热解毒、补肝明目","image":"http://img.szzhangchu.com/1442386633751_1128557220.jpg"}]
             * suitable_not_with : [{"material_id":"44","material_name":"山药","type":"1","suitable_desc":"破坏维生素C","image":"http://img.szzhangchu.com/20141107102023496.jpg"},{"material_id":"187","material_name":"山楂","type":"1","suitable_desc":"破坏维生素C","image":"http://img.szzhangchu.com/20150518162713869.jpg"}]
             */

            private String material_id;
            private String material_name;
            private String image;
            private List<SuitableWithBean> suitable_with;
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
                /**
                 * material_id : 4
                 * material_name : 奶白菜
                 * type : 0
                 * suitable_desc : 保肝护肾
                 * image : http://img.szzhangchu.com/20150418102923296.jpg
                 */

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
                /**
                 * material_id : 44
                 * material_name : 山药
                 * type : 1
                 * suitable_desc : 破坏维生素C
                 * image : http://img.szzhangchu.com/20141107102023496.jpg
                 */

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
