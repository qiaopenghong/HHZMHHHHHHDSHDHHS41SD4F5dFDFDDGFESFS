package com.hhzmy.main.com.hhzmy.bean;

import java.util.List;

/**
 * Created by a on 2016/11/14.
 */
public class Data {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {


        private List<TagBean> tag;

        public List<TagBean> getTag() {
            return tag;
        }

        public void setTag(List<TagBean> tag) {
            this.tag = tag;
        }

        public static class TagBean {


            private String picUrl;
            private String elementName;
            private String linkUrl;
            public String getLinkUrl() {
                return linkUrl;
            }
            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }


            public String getElementName() {
                return elementName;
            }

            public void setElementName(String elementName) {
                this.elementName = elementName;
            }



            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }
        }
    }




}
