package com.aqua30.mvpsample.model.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;


/**
 * Created by Saurabh(aqua) on 02-11-2016.
 */

public class ViewHelper {

    private static ProgressDialog progressDialog;

    public static void showProgress(Context context, String msg){
        if (progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = ProgressDialog.show(context,"",msg,true);
        progressDialog.show();
    }

    public static void hideProgress(){
        if (progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public static void setViewVisibility(View v, boolean isVisible){
        v.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public static Bitmap getBitmapOFRootView(View v) {
        v.setDrawingCacheEnabled(true);
        Bitmap bitmap = v.getDrawingCache();
        return bitmap;
    }

}
