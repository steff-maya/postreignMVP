package com.jappy.postreign.posts.presentation;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jappy.postreign.R;
import com.jappy.postreign.app.App;
import com.jappy.postreign.app.BaseActivity;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by jappy on 08-08-17.
 */

public class WebViewPostActivity extends BaseActivity  implements WebViewPosts {

    @BindView(R.id.webView)
    WebView webView;
    @Inject
    WebViewPresenter mPresenter;
    @Override
    public void init() {

        ButterKnife.bind(this);
        Bundle b = getIntent().getExtras();
        ((App) getApplicationContext()).getAppComponent().inject(this);
        mPresenter.init(this);
        mPresenter.showDialog();

        String url = b.getString("url");
        WebView webView = (WebView) findViewById(R.id.webView);
        Log.d("TAG", "init: " + url);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                mPresenter.hideDialog();
            }
        });





    }



    @Override
    public void setContentView() {
        setContentView(R.layout.activity_web_view_post);

    }

    @Override
    public void checkPermission() {

    }
}
