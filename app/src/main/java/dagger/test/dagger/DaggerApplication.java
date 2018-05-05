package dagger.test.dagger;

import android.app.Application;

import dagger.test.dagger.dagger.component.DaggerNetComponent;
import dagger.test.dagger.dagger.component.NetComponent;
import dagger.test.dagger.dagger.module.AppModule;
import dagger.test.dagger.dagger.module.ContextModule;
import dagger.test.dagger.dagger.module.NetModule;
import dagger.test.dagger.utils.Constant;

/**
 * Created by Admin on 4/29/2018.
 */

public class DaggerApplication extends Application {

    private NetComponent mNetComponent;
    public static boolean activityVisible;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .contextModule(new ContextModule(this))
                .netModule(new NetModule(Constant.BASE_URL))
                .build();
    }


    public NetComponent getNetComponent() {
        return mNetComponent;
    }


    public static boolean isActivityVisible() {
        return activityVisible; // return true or false
    }

    public static void activityResumed() {
        activityVisible = true;// this will set true when activity resumed

    }

    public static void activityPaused() {
        activityVisible = false;// this will set false when activity paused

    }
}
