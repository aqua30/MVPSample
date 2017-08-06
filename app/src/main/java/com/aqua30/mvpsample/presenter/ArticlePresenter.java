package com.aqua30.mvpsample.presenter;


import com.aqua30.mvpsample.model.apis.DataRepository;
import com.aqua30.mvpsample.model.pojo.Article;
import com.aqua30.mvpsample.model.pojo.ArticleModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Saurabh(aqua) on 06-08-2017.
 */

public class ArticlePresenter implements ArticleContract.Presenter {

    private ArticlePresentationModel model; /* object for the model class to store data */
    private ArticleContract.Views views_contract;   /* creating a link to view class */

    public ArticlePresenter(){
        model = new ArticlePresentationModel();
        model.setModelContract(this);   /* creating link between presenter and model */
    }

    public void setViewContract(ArticleContract.Views views_contract){
        this.views_contract = views_contract;
    }

    /*  get the article from database */
    public void getArticlesOnStart() {
        views_contract.showProgress(true);
        DataRepository.getArticles().enqueue(new Callback<ArticleModel>() {

            @Override
            public void onResponse(Call<ArticleModel> call, Response<ArticleModel> response) {
                ArticleModel result = response.body();
                if (result != null) {
                    switch (result.getStatus()) {
                        case 1:
                            if (!result.getNewslist().isEmpty()) {
                                model.setArticle_list(result.getNewslist());    /* set the data source */
                                views_contract.showList(result.getNewslist());
                            } else {
                                views_contract.showError("No articles found");
                            }
                            break;
                        case 0:
                            views_contract.showError("some debug");
                            break;
                    }
                } else {
                    views_contract.showError("getarticles : null returned");
                }
            }

            @Override
            public void onFailure(Call<ArticleModel> call, Throwable t) {
                views_contract.showError("some debug");
            }
        });
    }

    /* get the data model */
    public ArticlePresentationModel getModel(){
        return model;
    }

    public void addArticle() {
        Article article = new Article();
        article.setId("1");
        article.setTitle("This is the new one added");
        article.setPost_date(String.valueOf(System.currentTimeMillis()));
        model.addArticleInList(article);
    }

    @Override
    public void onArticleAdded() {
        views_contract.refreshData();
    }
}
