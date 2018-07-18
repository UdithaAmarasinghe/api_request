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
		//check user login
		       if (isLogin()) {
            //todo add userkey value
            HomeActivity.startActivity(this, mPreferences.getUserKey(), "","");
        } else {
            LoginActivity.startActivity(this, mSearchCode);
            goNextAnimation();
        }

        finish();
		
		
		!!!!!!!!!
		 AppSharedPreference mSharedPreferences = new AppSharedPreference(mContext);
        mSharedPreferences.clearSharefPreference();
        startActivity(new Intent(mContext, SplashActivity.class));
        finish();
		
		
		
        mUserSync = new UserSync(this, mRestAPI);
        HomeRequest homeRequest = new HomeRequest();
        mUserSync.homeInit(this);
    }

    @Override
    public void onSuccessUserCreate(List<HomeResponse.Datum> result) {
        System.out.println("result xxx "+result.get(0).getSubTitle());
		
		/* RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        rvFavourite.setLayoutManager(mLayoutManager);
        List<FavouriteTypes> selectableItems = new ArrayList<>();
        for (int x = 0; x < response.getData().size(); x++) {
            selectableItems.add(new FavouriteTypes(response.getData().get(x).getId(), response.getData().get(x).getName(), response.getData().get(x).getImage()));
        }
        favouritesListAdapter = new FavouritesListAdapter(mContext, new FavouritesListAdapter.FavouritesListAdapterCallback() {
            @Override
            public void SelectFavouriteData(String id, String businessName) {
                BusinessProfileActivity.startActivity(getActivity(), id, businessName);
            }
        });
        favouritesListAdapter.addAll(selectableItems);
        rvFavourite.setAdapter(favouritesListAdapter);
        rvFavourite.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity()).drawable(R.drawable.shape_editext_bg).size(2).build());*/
    }

    @Override
    public void onFailedUserCreate(String message) {

    }
}
