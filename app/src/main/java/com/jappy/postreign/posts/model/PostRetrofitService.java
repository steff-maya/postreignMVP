package com.jappy.postreign.posts.model;



import com.jappy.postreign.posts.model.model.Posts;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;
/**
 * Created by jappy on 08-08-17.
 */


public interface PostRetrofitService {

    @GET("/api/v1/search_by_date?query=android")
    Observable<Response<Posts>> fetchPosts();


}


