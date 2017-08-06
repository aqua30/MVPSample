package com.aqua30.mvpsample.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aqua30.mvpsample.R;
import com.aqua30.mvpsample.model.pojo.Article;
import com.aqua30.mvpsample.presenter.ArticlePresentationModel;
import com.aqua30.mvpsample.presenter.ArticlePresenter;
import com.aqua30.mvpsample.model.util.TimeManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Saurabh(aqua) on 31-03-2016.
 */
public class ArticleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArticlePresenter presenter;
    private ArticlePresentationModel model;

    public ArticleListAdapter(Context context, ArticlePresenter presenter){
        this.context = context;
        this.presenter = presenter;
        this.model = presenter.getModel();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ly_article_list_item, parent, false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder) viewHolder;
        Article article = presenter.getModel().getArticle_list().get(position);
        holder.title.setText(article.getTitle());
        holder.time.setText(String.format("%s",
                TimeManager.getDate_from_millis(article.getPost_date(),"dd MMM yyyy")));
    }

    @Override
    public int getItemCount() {
        return model.getArticle_list() != null ? model.getArticle_list().size() : 0;
    }

    public void notifyData() {
//        this.model = presenter.getModel();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textview_article_item_title)TextView title;
        @BindView(R.id.textview_article_item_time)TextView time;

        Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.context = context;
        }

        @OnClick(R.id.ll_article_list_item_parent)
        void onItemClick(){

        }
    }
}