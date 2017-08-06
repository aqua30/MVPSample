package com.aqua30.mvpsample.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.aqua30.mvpsample.R;
import com.aqua30.mvpsample.model.pojo.Article;
import com.aqua30.mvpsample.presenter.ArticleContract;
import com.aqua30.mvpsample.presenter.ArticlePresenter;
import com.aqua30.mvpsample.model.util.ViewHelper;
import com.aqua30.mvpsample.view.adapters.ArticleListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Saurabh(aqua) on 02-08-2017.
 */

public class MainActivity extends BaseActivity implements ArticleContract.Views {

    @BindView(R.id.article_recycler_view)RecyclerView articleList;
    @BindView(R.id.no_response_view)TextView noResponseView;

    private ArticleListAdapter articleListAdapter;
    private ArticlePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ArticlePresenter();
        presenter.setViewContract(this);

        articleListAdapter = new ArticleListAdapter(this,presenter);
        articleList.setAdapter(articleListAdapter);

        presenter.getArticlesOnStart();
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.ac_main;
    }

    @OnClick(R.id.add_article)
    void onAddArticleClick(){
        presenter.addArticle();
    }

    @Override
    public void showList(List<Article> list) {
        ViewHelper.setViewVisibility(noResponseView, false);
        ViewHelper.setViewVisibility(articleList, true);
        articleListAdapter.notifyData();
    }

    @Override
    public void showProgress(boolean is_progress_active) {
        if (is_progress_active)
            noResponseView.setText("Loading articles...");
        ViewHelper.setViewVisibility(noResponseView, is_progress_active);
        ViewHelper.setViewVisibility(articleList, !is_progress_active);
    }

    @Override
    public void showError(String message) {
        ViewHelper.setViewVisibility(noResponseView, true);
        noResponseView.setText("No article found");
        ViewHelper.setViewVisibility(articleList, false);
    }

    @Override
    public void refreshData() {
        articleListAdapter.notifyData();
        articleList.smoothScrollToPosition(presenter.getModel().getArticle_list().size() - 1);
    }
}
