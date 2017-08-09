package com.jappy.postreign.utility.dagger;


import com.jappy.postreign.posts.model.PostRealmImpl;
import com.jappy.postreign.posts.model.PostRetrofitImpl;
import com.jappy.postreign.posts.model.PostRetrofitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by jappy on 08-08-17.
 */

@Module
public class ImplModule {


    @Provides
    @Singleton
    PostRealmImpl providesPostRealmImpl() {
        return new PostRealmImpl();
    }

    @Provides
    @Singleton
    PostRetrofitImpl providesPostRetrofitImpl(Retrofit retrofit) {
        return new PostRetrofitImpl(retrofit.create(PostRetrofitService.class));
    }
}
