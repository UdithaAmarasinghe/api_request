package dagger.test.dagger.view.activites;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.test.dagger.DaggerApplication;
import dagger.test.dagger.services.RestAPI;

/**
 * Created by Admin on 4/29/2018.
 */

public abstract class BaseActivity extends AppCompatActivity{
    public Context mContext;

    @Inject
    RestAPI mRestAPI;

    public BaseActivity() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        DaggerApplication.activityPaused();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DaggerApplication.activityResumed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DaggerApplication) getApplication()).getNetComponent().inject(this);
        init();
    }

    private void init() {

    }

}
