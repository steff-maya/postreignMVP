package com.jappy.postreign.posts.data;

import android.content.Context;

import com.jappy.postreign.posts.model.model.ListPosts;
import com.jappy.postreign.posts.model.model.Posts;
import com.jappy.postreign.utility.Utility;

import java.util.List;

import rx.Observable;

/**
 * Created by jappy on 08-08-17.
 */


public class PostService implements PostRepository {

    private Context mContext;
    private PostRepository mRepo;
    private PostRepository mOfflineRepo;

    public PostService(PostRepository repo) {
        this.mRepo = repo;
    }

    public PostService(PostRepository repo, PostRepository offlineRepo, Context context) {
        this.mRepo = repo;
        this.mOfflineRepo = offlineRepo;
        this.mContext = context;
    }


    @Override
    public Observable<Posts> fetchPosts() {
        if (mContext != null && !Utility.isNetworkAvailable(mContext)) {
            return mOfflineRepo.fetchPosts();
        } else {
            return mRepo.fetchPosts();
        }

    }

    @Override
    public Observable<List<ListPosts>> fetchPostsList() {
        if (mContext != null && !Utility.isNetworkAvailable(mContext)) {
            return mOfflineRepo.fetchPostsList();
        } else {
            return mRepo.fetchPostsList();
        }
    }


}
