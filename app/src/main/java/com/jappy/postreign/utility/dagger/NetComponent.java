package com.jappy.postreign.utility.dagger;


import com.jappy.postreign.posts.model.PostRetrofitImpl;
import com.jappy.postreign.posts.presentation.PostActivity;
import com.jappy.postreign.posts.presentation.WebViewPostActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jappy on 08-08-17.
 */


@Singleton
@Component(modules = {AppModule.class, NetModule.class,ServicesModule.class,ImplModule.class})
public interface NetComponent {


    void inject(PostActivity postActivity);
    void inject(WebViewPostActivity webViewPostActivity);

    void inject(PostRetrofitImpl postRetrofit);
}