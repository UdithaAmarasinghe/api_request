package dagger.test.dagger.services;

import dagger.test.dagger.services.synce.response.HomeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Admin on 4/29/2018.
 */

public interface RestAPI {


    @GET("index/home_init")
    Call<HomeResponse> homeInit(@Header("Authorization") String token);
}
