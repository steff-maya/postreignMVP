package com.jappy.postreign.posts.model;



import com.jappy.postreign.posts.data.PostRepository;
import com.jappy.postreign.posts.model.model.ListPosts;
import com.jappy.postreign.posts.model.model.Posts;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by jappy on 08-08-17.
 */


public class PostRealmImpl implements PostRepository {
    private static final String TAG = "UserRetrofitImpl";
    private Realm mRealm;

    @Inject
    public PostRealmImpl() {
        this.mRealm = Realm.getDefaultInstance();
    }


    @Override
    public Observable<Posts> fetchPosts() {
        return null;
    }

    @Override
    public Observable<List<ListPosts>> fetchPostsList() {
        return mRealm.where(ListPosts.class).findAllSorted("createdAtI", Sort.ASCENDING).asObservable()
                .map(new Func1<RealmResults<ListPosts>, List<ListPosts>>() {
                    @Override
                    public List<ListPosts> call(RealmResults<ListPosts> results) {
                        return mRealm.copyFromRealm(results);
                    }
                });
    }


}


