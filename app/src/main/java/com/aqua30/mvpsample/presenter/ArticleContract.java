package com.aqua30.mvpsample.presenter;

import com.aqua30.mvpsample.model.pojo.Article;

import java.util.List;

/**
 * Created by Saurabh(aqua) on 06-08-2017.
 */

public interface ArticleContract {

    /* callbacks between presenter and views */
    interface Views {
        void showList(List<Article> list);
        void showProgress(boolean is_progress_active);
        void showError(String message);
        void refreshData();
    }

    /* callbacks between presenter and model */
    interface Presenter {
        void onArticleAdded();
    }
}
