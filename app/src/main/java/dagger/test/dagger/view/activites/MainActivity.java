package dagger.test.dagger.view.activites;

import android.os.Bundle;

import java.util.List;

import butterknife.ButterKnife;
import dagger.test.dagger.R;
import dagger.test.dagger.services.synce.response.HomeResponse;
import dagger.test.dagger.services.synce.response.request.HomeRequest;
import dagger.test.dagger.services.synce.response.user.UserSync;

public class MainActivity extends BaseActivity implements UserSync.UserSyncCallback.HomeCallback {
    UserSync mUserSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mUserSync = new UserSync(this, mRestAPI);
        HomeRequest homeRequest = new HomeRequest();
        mUserSync.homeInit(this);
    }

    @Override
    public void onSuccessUserCreate(List<HomeResponse.Datum> result) {
        System.out.println("result xxx "+result.get(0).getSubTitle());
    }

    @Override
    public void onFailedUserCreate(String message) {

    }
}
