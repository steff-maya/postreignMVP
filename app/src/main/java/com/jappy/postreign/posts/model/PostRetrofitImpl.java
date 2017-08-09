package com.jappy.postreign.posts.model;





import com.jappy.postreign.posts.data.PostRepository;
import com.jappy.postreign.posts.model.model.ListPosts;
import com.jappy.postreign.posts.model.model.Posts;
import com.jappy.postreign.utility.NetworkParser;

import java.util.List;

import javax.inject.Inject;


import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jappy on 08-08-17.
 */

public class PostRetrofitImpl implements PostRepository {
    private static final String TAG = "UserRetrofitImpl";
    private PostRetrofitService mRetrofitService;

    @Inject
    public PostRetrofitImpl(PostRetrofitService retrofitService) {
        this.mRetrofitService = retrofitService;
    }


    @Override
    public Observable<Posts> fetchPosts() {


        return  null;

    }

    @Override
    public Observable<List<ListPosts>> fetchPostsList() {
        return mRetrofitService.fetchPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).map(new Func1<Response<Posts>, List<ListPosts>>() {
                    @Override
                    public List<ListPosts> call(Response<Posts> postsResponse) {
                        if (postsResponse.isSuccessful()) {
                            return NetworkParser.cacheResponse(postsResponse.body().getHits());
                        }
                        throw new RuntimeException(postsResponse.message());

                    }
                });
    }


}


