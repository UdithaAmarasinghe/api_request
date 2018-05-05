package dagger.test.dagger.dagger.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.test.dagger.dagger.qulifier.ApplicationContext;

/**
 * Created by Admin on 4/29/2018.
 */

@Module
public class ContextModule {

    Context mContext;

    public ContextModule(Context context) {
        mContext = context.getApplicationContext();
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context providesContext() {
        return mContext;
    }
}