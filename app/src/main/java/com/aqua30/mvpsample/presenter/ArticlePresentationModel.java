package com.aqua30.mvpsample.presenter;

import com.aqua30.mvpsample.model.pojo.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh(aqua) on 06-08-2017.
 */

public class ArticlePresentationModel {

    private ArticleContract.Presenter presenter_contract;

    private List<Article> article_list = new ArrayList<>();

    public List<Article> getArticle_list() {
        return article_list;
    }

    public void setArticle_list(List<Article> article_list) {
        this.article_list = article_list;
    }

    public void addArticleInList(Article article) {
        getArticle_list().add(article);
        presenter_contract.onArticleAdded();
    }

    public boolean isListEmpty() {
        return getArticle_list().isEmpty();
    }

    public void setModelContract(ArticleContract.Presenter presenter_contract){
        this.presenter_contract = presenter_contract;
    }
}
