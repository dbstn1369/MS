package com.example.jsh.helloworld.vo;

import java.io.Serializable;

public class Event implements Serializable{
    private String leftTop;
    private String rightTop;

    private String title;
    private String content;

    private String leftBottom;
    private String rightBottom;

    private String url;

    private Event(EventBuilder eventBuilder){
        this.leftTop = eventBuilder.leftTop;
        this.rightTop = eventBuilder.rightTop;

        this.title = eventBuilder.title;
        this.content = eventBuilder.content;

        this.leftBottom = eventBuilder.leftBottom;
        this.rightBottom = eventBuilder.rightBottom;

        this.url = eventBuilder.url;
    }

    public String getLeftTop() {
        return leftTop;
    }

    public String getRightTop() {
        return rightTop;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getLeftBottom() {
        return leftBottom;
    }

    public String getRightBottom() {
        return rightBottom;
    }

    public String getUrl() {
        return url;
    }

    public static class EventBuilder {
        private String leftTop;
        private String rightTop;

        private String title;
        private String content;

        private String leftBottom;
        private String rightBottom;

        private String url;

        public EventBuilder setLeftTop(String leftTop) {
            this.leftTop = leftTop;
            return this;
        }
        public EventBuilder setRightTop(String rightTop) {
            this.rightTop = rightTop;
            return this;
        }
        public EventBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        public EventBuilder setContent(String content) {
            this.content = content;
            return this;
        }
        public EventBuilder setLeftBottom(String leftBottom) {
            this.leftBottom = leftBottom;
            return this;
        }
        public EventBuilder setRightBottom(String rightBottom) {
            this.rightBottom = rightBottom;
            return this;
        }
        public EventBuilder setUrl(String url) {
            this.url = url;
            return this;
        }
        public Event build() {
            return new Event(this);
        }
    }
}
