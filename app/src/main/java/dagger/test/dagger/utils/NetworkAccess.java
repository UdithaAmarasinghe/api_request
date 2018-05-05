package dagger.test.dagger.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * Created by Admin on 4/29/2018.
 */

public class NetworkAccess {
    private static Context mContext;

    public NetworkAccess(Context context) {
        mContext = context;
    }

    public static boolean isNetworkAvailable(final Context context/*, ColoredSnackBar coloredSnackBar*/) {

        mContext = context;

        boolean state = isInternetAvailable();

        if (!state) {
            //coloredSnackBar.showSnackBar("No internet connection", ColoredSnackBar.TYPE_ERROR, Snackbar.LENGTH_LONG);
            Toast.makeText(context, "No internet connection", Toast.LENGTH_SHORT).show();
        }

        return state;
    }

    private static boolean isInternetAvailable() {

        final ConnectivityManager connectivityManager = ((ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE));

        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

}

