package com.jappy.postreign.app;

import android.app.Application;
import android.content.Context;

import com.jappy.postreign.Utility.UrlHelper;
import com.jappy.postreign.utility.dagger.AppModule;
import com.jappy.postreign.utility.dagger.DaggerNetComponent;
import com.jappy.postreign.utility.dagger.ImplModule;
import com.jappy.postreign.utility.dagger.NetComponent;
import com.jappy.postreign.utility.dagger.NetModule;
import com.jappy.postreign.utility.dagger.ServicesModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by jappy on 08-08-17.
 */

public class App extends Application {
    private NetComponent mNetComponent;
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        initRealmConfiguration();
        App.context = getApplicationContext();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(UrlHelper.getBaseUrl()))
                .servicesModule(new ServicesModule())
                .implModule(new ImplModule())
                .build();

    }

    private void initRealmConfiguration() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static Context getContext() {
        return App.context;
    }


    public NetComponent getAppComponent() {
        return mNetComponent;
    }
}
