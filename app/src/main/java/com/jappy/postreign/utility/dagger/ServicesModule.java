package com.jappy.postreign.utility.dagger;

import android.app.Application;

import com.jappy.postreign.posts.data.PostService;
import com.jappy.postreign.posts.model.PostRealmImpl;
import com.jappy.postreign.posts.model.PostRetrofitImpl;
import com.jappy.postreign.utility.Constant;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jappy on 08-08-17.
 */

@Module
public class ServicesModule {

    @Provides
    @Named(Constant.Named.OnlyNetwork)
    PostService providesPostService(PostRetrofitImpl postRetrofitImpl) {
        return new PostService(postRetrofitImpl);
    }


    @Provides
    @Named(Constant.Named.NetworkWithRealmCaching)
    PostService providesPostServiceWithRealmImpl(PostRetrofitImpl postRetrofitImpl, PostRealmImpl postRealm, Application application) {
        return new PostService(postRetrofitImpl, postRealm, application);
    }
}
