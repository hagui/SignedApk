package fr.a2305.signedapk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public class AppsUtils {


    private static final String TAG = AppsUtils.class.getSimpleName();

    private AppsUtils() {
        throw new AssertionError();
    }

    public static String getAppVersion(Context context) {
        String appVersion = null;

        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            appVersion = info.versionName;
        } catch (Exception e) {
            Log.e(TAG, "PackageManager Exception", e);
        } finally {
            return appVersion;
        }
    }

    public static String getDeviceId(Context context){
        String id = null;
        try {
            id = Settings.Secure.getString(context.getContentResolver() , Settings.Secure._ID);
        } catch (Exception e) {
            Log.e(TAG, "PackageManager Exception", e);
        } finally {
            return id;
        }
    }

    public static String getDeviceModel(Context context) {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        } else {
            return manufacturer + " " + model;
        }
    }

    public static boolean isFroyo() {
        // Can use static final constants like FROYO, declared in later versions
        // of the OS since they are inlined at compile time. This is guaranteed
        // behavior.
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }

    public static boolean isGingerbread() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    public static boolean isHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean isHoneycombMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }

    public static boolean isJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean isKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean isLolipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public static boolean isLolipop_mr() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1;
    }

    public static boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }


}
