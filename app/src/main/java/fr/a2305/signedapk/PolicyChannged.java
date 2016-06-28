package fr.a2305.signedapk;

import android.os.Bundle;

/**
 * ${SignedApk} -
 * Created by hagui on 2016.
 */
public interface PolicyChannged extends Controller{

    boolean isAirViewAllowed();

    void allowAirView();

    void disallowAirView();

    boolean isTalkbackEnabled();

    boolean isBluetoothEnabled();

    String getDeviceName();

    void disableBluetooth();

    void enableBluetooth();

    boolean isMultiWindowEnabled();

    void disableMultiwindow();

    void enableMultiwindow();

    void allowGPS();

    void disallowGPS();

    void registerSettingsChangedListener(SystemManager.SettingsChangedListener var1);

    void unregisterSettingsChangedListener(SystemManager.SettingsChangedListener var1);

    void sysShutdown(boolean var1);

    void sysReboot();

    int getTotalMemorySize();

    int getFreeMemorySize();

    void setLockPolicy(Bundle var1);

    public interface SettingsChangedListener {
        void onSettingsChanged();
    }
}
