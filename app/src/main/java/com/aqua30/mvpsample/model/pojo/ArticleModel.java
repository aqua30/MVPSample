package com.aqua30.mvpsample.model.pojo;

import java.util.List;

/**
 * Created by Saurabh(aqua) on 05-04-2017.
 */

public class ArticleModel extends BasicResponseModel{

    private List<Article> article_list;

    public List<Article> getArticles_in_timeline() {
        return articles_in_timeline;
    }

    public void setArticles_in_timeline(List<Article> articles_in_timeline) {
        this.articles_in_timeline = articles_in_timeline;
    }

    private List<Article> articles_in_timeline;

    public List<Article> getNewslist() {
        return article_list;
    }

    public void setNewslist(List<Article> article_list) {
        this.article_list = article_list;
    }
}
