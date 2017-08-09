package com.jappy.postreign.posts.presentation;


import com.jappy.postreign.posts.data.PostService;
import com.jappy.postreign.posts.model.model.ListPosts;
import com.jappy.postreign.posts.model.model.Posts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by jappy on 08-08-17.
 */

class PostPresenter {
    private List<ListPosts> postList = new ArrayList<>();

    private PostView mView;
    private PostService mService;


    @Inject
    public PostPresenter() {
    }

    void init(PostView view, PostService service) {
        this.mView = view;
        this.mService = service;
    }

    void fetchAllPosts() {
        mView.showProgressDialog(false);
        mService.fetchPostsList()
                .subscribe(new Subscriber <List<ListPosts>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.hideProgressDialog();
                        mView.showToast(e.getMessage());
                    }

                    @Override
                    public void onNext(List<ListPosts> posts) {
                        mView.hideProgressDialog();
                        mView.notifyPostChanged(posts);

                        postList.addAll(posts);

                    }
                });
    }

    List<ListPosts>  getPostList() {
        return postList;
    }
}
