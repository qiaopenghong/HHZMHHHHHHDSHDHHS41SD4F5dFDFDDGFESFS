package com.hhzmy.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by qiao on 2016/11/17.
 */
public class XGoodsTwoFragment extends Fragment{

    private WebView gt_webview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(),R.layout.xgoodstwo_item,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gt_webview = (WebView) getView().findViewById(R.id.goodstwo_webview);
        gt_webview.getSettings().setJavaScriptEnabled(true);
        gt_webview.loadUrl("http://product.suning.com/pds-web/product/graphicSaleApp/0000000000/102295661.html");
    }
}
