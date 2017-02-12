package com.example.group.zhangchu.beans.FoodMaterial;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 *
 * 这是三级接口，即Fragment做法的数据类
 */

public class DishesView {

    /**
     * code : 0
     * msg : success
     * version : 4.1
     * timestamp : 1481787834000
     * data : {"dashes_id":"15503","dashes_name":"菠菜酵素","material_video":"http://video.szzhangchu.com/bocaijiaosuA.mp4","process_video":"http://video.szzhangchu.com/bocaijiaosuB.mp4","hard_level":"容易","taste":"酸","cooke_time":"5分钟","image":"http://img.szzhangchu.com/1466263964792_2686515751.JPG","material_desc":"将菠菜做成酵素，除了用于保健饮用，还可以每周定期涂抹在脸上，连续用一段时间，能有效清洁皮肤毛孔，保持皮肤细致光滑。","share_amount":"0","dishes_name":"菠菜酵素","dishes_title":"菠菜酵素","dishes_id":"15503","cooking_time":"5分钟","comment_count":"0","agreement_amount":"30","tags_info":[{"id":324,"text":"腌","type":2},{"id":313,"text":"增强免疫力","type":2},{"id":317,"text":"甜","type":2},{"id":302,"text":"补铁","type":2},{"id":289,"text":"增强免疫力","type":2}],"share_url":"http://m.izhangchu.com/web/dishes_view/index.html?&dishes_id=15503","step":[{"dishes_step_id":"204496","dishes_id":"15503","dishes_step_order":"1","dishes_step_image":"http://img.szzhangchu.com/1466263661265_7035984978.jpg","dishes_step_desc":"手洗净擦干，将洗净晾干的菠菜切小段，装盘。"},{"dishes_step_id":"204497","dishes_id":"15503","dishes_step_order":"2","dishes_step_image":"http://img.szzhangchu.com/1466263715077_7294730774.jpg","dishes_step_desc":"备好高温消毒并晾干的玻璃瓶，瓶底倒入一层绵白糖，铺平。"},{"dishes_step_id":"204498","dishes_id":"15503","dishes_step_order":"3","dishes_step_image":"http://img.szzhangchu.com/1466263733991_7584014613.jpg","dishes_step_desc":"放入一半切好的菠菜。"},{"dishes_step_id":"204499","dishes_id":"15503","dishes_step_order":"4","dishes_step_image":"http://img.szzhangchu.com/1466263756054_1969261749.jpg","dishes_step_desc":"再放入一层绵白糖。"},{"dishes_step_id":"204500","dishes_id":"15503","dishes_step_order":"5","dishes_step_image":"http://img.szzhangchu.com/1466263773627_3260217739.jpg","dishes_step_desc":"将材料上下抓匀。"},{"dishes_step_id":"204501","dishes_id":"15503","dishes_step_order":"6","dishes_step_image":"http://img.szzhangchu.com/1466263791892_1328902804.jpg","dishes_step_desc":"放入剩余切好的菠菜。"},{"dishes_step_id":"204502","dishes_id":"15503","dishes_step_order":"7","dishes_step_image":"http://img.szzhangchu.com/1466263808607_9462518761.jpg","dishes_step_desc":"加入适量绵白糖。"},{"dishes_step_id":"204503","dishes_id":"15503","dishes_step_order":"8","dishes_step_image":"http://img.szzhangchu.com/1466263828337_8642980040.jpg","dishes_step_desc":"再次将材料上下抓匀。"},{"dishes_step_id":"204504","dishes_id":"15503","dishes_step_order":"9","dishes_step_image":"http://img.szzhangchu.com/1466263919434_5709183527.jpg","dishes_step_desc":"放入剩余绵白糖，铺平。"},{"dishes_step_id":"204505","dishes_id":"15503","dishes_step_order":"10","dishes_step_image":"http://img.szzhangchu.com/1466263939447_6535017743.jpg","dishes_step_desc":"盖上盖，放置于避光通风处，从第二天开始，每天搅拌1~2次，至发酵完成即可。依季节及材料的不同，完成发酵所需的时间也会不同，一般大概需5~10天，冬季可能需2周。"}],"like":0,"extra":[],"commoditys":[]}
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
         * dashes_id : 15503
         * dashes_name : 菠菜酵素
         * material_video : http://video.szzhangchu.com/bocaijiaosuA.mp4
         * process_video : http://video.szzhangchu.com/bocaijiaosuB.mp4
         * hard_level : 容易
         * taste : 酸
         * cooke_time : 5分钟
         * image : http://img.szzhangchu.com/1466263964792_2686515751.JPG
         * material_desc : 将菠菜做成酵素，除了用于保健饮用，还可以每周定期涂抹在脸上，连续用一段时间，能有效清洁皮肤毛孔，保持皮肤细致光滑。
         * share_amount : 0
         * dishes_name : 菠菜酵素
         * dishes_title : 菠菜酵素
         * dishes_id : 15503
         * cooking_time : 5分钟
         * comment_count : 0
         * agreement_amount : 30
         * tags_info : [{"id":324,"text":"腌","type":2},{"id":313,"text":"增强免疫力","type":2},{"id":317,"text":"甜","type":2},{"id":302,"text":"补铁","type":2},{"id":289,"text":"增强免疫力","type":2}]
         * share_url : http://m.izhangchu.com/web/dishes_view/index.html?&dishes_id=15503
         * step : [{"dishes_step_id":"204496","dishes_id":"15503","dishes_step_order":"1","dishes_step_image":"http://img.szzhangchu.com/1466263661265_7035984978.jpg","dishes_step_desc":"手洗净擦干，将洗净晾干的菠菜切小段，装盘。"},{"dishes_step_id":"204497","dishes_id":"15503","dishes_step_order":"2","dishes_step_image":"http://img.szzhangchu.com/1466263715077_7294730774.jpg","dishes_step_desc":"备好高温消毒并晾干的玻璃瓶，瓶底倒入一层绵白糖，铺平。"},{"dishes_step_id":"204498","dishes_id":"15503","dishes_step_order":"3","dishes_step_image":"http://img.szzhangchu.com/1466263733991_7584014613.jpg","dishes_step_desc":"放入一半切好的菠菜。"},{"dishes_step_id":"204499","dishes_id":"15503","dishes_step_order":"4","dishes_step_image":"http://img.szzhangchu.com/1466263756054_1969261749.jpg","dishes_step_desc":"再放入一层绵白糖。"},{"dishes_step_id":"204500","dishes_id":"15503","dishes_step_order":"5","dishes_step_image":"http://img.szzhangchu.com/1466263773627_3260217739.jpg","dishes_step_desc":"将材料上下抓匀。"},{"dishes_step_id":"204501","dishes_id":"15503","dishes_step_order":"6","dishes_step_image":"http://img.szzhangchu.com/1466263791892_1328902804.jpg","dishes_step_desc":"放入剩余切好的菠菜。"},{"dishes_step_id":"204502","dishes_id":"15503","dishes_step_order":"7","dishes_step_image":"http://img.szzhangchu.com/1466263808607_9462518761.jpg","dishes_step_desc":"加入适量绵白糖。"},{"dishes_step_id":"204503","dishes_id":"15503","dishes_step_order":"8","dishes_step_image":"http://img.szzhangchu.com/1466263828337_8642980040.jpg","dishes_step_desc":"再次将材料上下抓匀。"},{"dishes_step_id":"204504","dishes_id":"15503","dishes_step_order":"9","dishes_step_image":"http://img.szzhangchu.com/1466263919434_5709183527.jpg","dishes_step_desc":"放入剩余绵白糖，铺平。"},{"dishes_step_id":"204505","dishes_id":"15503","dishes_step_order":"10","dishes_step_image":"http://img.szzhangchu.com/1466263939447_6535017743.jpg","dishes_step_desc":"盖上盖，放置于避光通风处，从第二天开始，每天搅拌1~2次，至发酵完成即可。依季节及材料的不同，完成发酵所需的时间也会不同，一般大概需5~10天，冬季可能需2周。"}]
         * like : 0
         * extra : []
         * commoditys : []
         */

        private String dashes_id;
        private String dashes_name;
        private String material_video;
        private String process_video;
        private String hard_level;
        private String taste;
        private String cooke_time;
        private String image;
        private String material_desc;
        private String share_amount;
        private String dishes_name;
        private String dishes_title;
        private String dishes_id;
        private String cooking_time;
        private String comment_count;
        private String agreement_amount;
        private String share_url;
        private int like;
        private List<TagsInfoBean> tags_info;
        private List<StepBean> step;
        private List<?> extra;
        private List<?> commoditys;

        public String getDashes_id() {
            return dashes_id;
        }

        public void setDashes_id(String dashes_id) {
            this.dashes_id = dashes_id;
        }

        public String getDashes_name() {
            return dashes_name;
        }

        public void setDashes_name(String dashes_name) {
            this.dashes_name = dashes_name;
        }

        public String getMaterial_video() {
            return material_video;
        }

        public void setMaterial_video(String material_video) {
            this.material_video = material_video;
        }

        public String getProcess_video() {
            return process_video;
        }

        public void setProcess_video(String process_video) {
            this.process_video = process_video;
        }

        public String getHard_level() {
            return hard_level;
        }

        public void setHard_level(String hard_level) {
            this.hard_level = hard_level;
        }

        public String getTaste() {
            return taste;
        }

        public void setTaste(String taste) {
            this.taste = taste;
        }

        public String getCooke_time() {
            return cooke_time;
        }

        public void setCooke_time(String cooke_time) {
            this.cooke_time = cooke_time;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getMaterial_desc() {
            return material_desc;
        }

        public void setMaterial_desc(String material_desc) {
            this.material_desc = material_desc;
        }

        public String getShare_amount() {
            return share_amount;
        }

        public void setShare_amount(String share_amount) {
            this.share_amount = share_amount;
        }

        public String getDishes_name() {
            return dishes_name;
        }

        public void setDishes_name(String dishes_name) {
            this.dishes_name = dishes_name;
        }

        public String getDishes_title() {
            return dishes_title;
        }

        public void setDishes_title(String dishes_title) {
            this.dishes_title = dishes_title;
        }

        public String getDishes_id() {
            return dishes_id;
        }

        public void setDishes_id(String dishes_id) {
            this.dishes_id = dishes_id;
        }

        public String getCooking_time() {
            return cooking_time;
        }

        public void setCooking_time(String cooking_time) {
            this.cooking_time = cooking_time;
        }

        public String getComment_count() {
            return comment_count;
        }

        public void setComment_count(String comment_count) {
            this.comment_count = comment_count;
        }

        public String getAgreement_amount() {
            return agreement_amount;
        }

        public void setAgreement_amount(String agreement_amount) {
            this.agreement_amount = agreement_amount;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public List<TagsInfoBean> getTags_info() {
            return tags_info;
        }

        public void setTags_info(List<TagsInfoBean> tags_info) {
            this.tags_info = tags_info;
        }

        public List<StepBean> getStep() {
            return step;
        }

        public void setStep(List<StepBean> step) {
            this.step = step;
        }

        public List<?> getExtra() {
            return extra;
        }

        public void setExtra(List<?> extra) {
            this.extra = extra;
        }

        public List<?> getCommoditys() {
            return commoditys;
        }

        public void setCommoditys(List<?> commoditys) {
            this.commoditys = commoditys;
        }

        public static class TagsInfoBean {
            /**
             * id : 324
             * text : 腌
             * type : 2
             */

            private int id;
            private String text;
            private int type;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class StepBean {
            /**
             * dishes_step_id : 204496
             * dishes_id : 15503
             * dishes_step_order : 1
             * dishes_step_image : http://img.szzhangchu.com/1466263661265_7035984978.jpg
             * dishes_step_desc : 手洗净擦干，将洗净晾干的菠菜切小段，装盘。
             */

            private String dishes_step_id;
            private String dishes_id;
            private String dishes_step_order;
            private String dishes_step_image;
            private String dishes_step_desc;

            public String getDishes_step_id() {
                return dishes_step_id;
            }

            public void setDishes_step_id(String dishes_step_id) {
                this.dishes_step_id = dishes_step_id;
            }

            public String getDishes_id() {
                return dishes_id;
            }

            public void setDishes_id(String dishes_id) {
                this.dishes_id = dishes_id;
            }

            public String getDishes_step_order() {
                return dishes_step_order;
            }

            public void setDishes_step_order(String dishes_step_order) {
                this.dishes_step_order = dishes_step_order;
            }

            public String getDishes_step_image() {
                return dishes_step_image;
            }

            public void setDishes_step_image(String dishes_step_image) {
                this.dishes_step_image = dishes_step_image;
            }

            public String getDishes_step_desc() {
                return dishes_step_desc;
            }

            public void setDishes_step_desc(String dishes_step_desc) {
                this.dishes_step_desc = dishes_step_desc;
            }
        }
    }
}
