package com.jappy.postreign.posts.presentation;


import com.jappy.postreign.posts.model.model.ListPosts;

import java.util.List;

/**
 * Created by jappy on 08-08-17.
 */

interface PostView {


    void showToast(String message);

    void notifyPostChanged(List<ListPosts> list);

    void showProgressDialog(boolean cancel);

    void hideProgressDialog();
}
