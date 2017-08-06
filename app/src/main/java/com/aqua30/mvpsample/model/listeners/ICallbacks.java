package com.aqua30.mvpsample.model.listeners;

/**
 * Created by Saurabh(aqua) on 05-04-2017.
 */

public interface ICallbacks<T> {

    void onResponseProgress();
    void onResponseCompleted(T code, T result);
    void onResponseFailure(T result);
}
