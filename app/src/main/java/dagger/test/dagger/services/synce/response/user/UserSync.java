package dagger.test.dagger.services.synce.response.user;

import android.content.Context;

import java.util.List;

import dagger.test.dagger.services.RestAPI;
import dagger.test.dagger.services.synce.response.HomeResponse;
import dagger.test.dagger.services.synce.response.request.HomeRequest;
import dagger.test.dagger.utils.Constant;
import dagger.test.dagger.utils.NetworkAccess;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 4/29/2018.
 */

public class UserSync {

    Context mContext;
    RestAPI mRestAPI;
    private String TAG = "UserSync";

    public UserSync(Context mContext, RestAPI restAPI) {
        this.mContext = mContext;
        this.mRestAPI = restAPI;
    }

    public interface UserSyncCallback {
        interface HomeCallback {
            void onSuccessUserCreate(List<HomeResponse.Datum> result);

            void onFailedUserCreate(String message);
        }
    }


    public void homeInit(final UserSyncCallback.HomeCallback callback) {

        if (!NetworkAccess.isNetworkAvailable(mContext)) {
            callback.onFailedUserCreate(null);
        }

        HomeRequest request = new HomeRequest();


        mRestAPI.homeInit("007979790-").enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {

                if (response.body().isStatus()) {
                    callback.onSuccessUserCreate(response.body().getData());
                } else {
                    callback.onFailedUserCreate(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                callback.onFailedUserCreate(Constant.ERROR_OOPS);
            }
        });
    }
}
