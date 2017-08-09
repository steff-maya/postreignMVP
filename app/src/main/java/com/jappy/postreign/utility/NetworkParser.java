package com.jappy.postreign.utility;

import com.jappy.postreign.posts.model.model.ListPosts;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by jappy on 08-08-17.
 */
public class NetworkParser {
    public static <T extends RealmObject> List<T> cacheResponse(final RealmList<T> passedObject) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(passedObject);
        realm.commitTransaction();
        return passedObject;
    }


}
