package com.aqua30.mvpsample.model.pojo;

import java.io.Serializable;

/**
 * Created by Saurabh(aqua) on 24-03-2017.
 */

public class Article implements Serializable {

    private String id = "";
    private String title = "";
    private String description = "";
    private String post_date = "";
    private String source_name = "";
    private String source_url = "";
    private int has_bookmark;
    private int read_status;
    private String timeline_id = "";

    public Article(){}

    public String getTimeline_id() {
        return (timeline_id == null || timeline_id.isEmpty()) ? "" : timeline_id;
    }

    public void setTimeline_id(String timeline_id) {
        this.timeline_id = timeline_id;
    }

    public int getHas_bookmark() {
        return has_bookmark;
    }

    public void setHas_bookmark(int has_bookmark) {
        this.has_bookmark = has_bookmark;
    }

    public int getRead_status() {
        return read_status;
    }

    public void setRead_status(int read_status) {
        this.read_status = read_status;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }
}