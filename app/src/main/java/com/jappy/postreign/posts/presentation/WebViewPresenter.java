package com.jappy.postreign.posts.presentation;

import com.jappy.postreign.posts.data.PostService;
import com.jappy.postreign.posts.model.model.ListPosts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by jappy on 08-08-17.
 */

public class WebViewPresenter {


    private WebViewPosts mView;



    @Inject
    public WebViewPresenter() {
    }

    void init(WebViewPosts view) {
        this.mView = view;

    }

    void showDialog() {
        mView.showProgressDialog(false);

    }

    void hideDialog() {
        mView.hideProgressDialog();

    }


}
