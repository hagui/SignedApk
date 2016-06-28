package fr.a2305.signedapk;

import android.content.Context;
import android.os.Handler;

/**
 * MilliwebSignedApk -
 * Created by hagui on 2016.
 */
public abstract class MainAgent {
    protected Context context;
    protected NetworkManager networkManager;
    protected DeviceManager deviceManager;
    protected DiscoveryManager discoveryManager;
    protected SystemManager systemManager;
    protected ScreenShareAgent screenShareManager;
    protected ScreenManager screenManager;
    protected FileShareManager fileShareManager;

    public MainAgent(Context context) {
        this.context = context;
    }

    protected final void created(Context var1, Handler var2) {
        this.context = var1;

    }

    protected abstract void onInitialized();

    protected abstract void onStarted();

    protected abstract void onStopped();

    protected  void loadAndroidManagers(){

    }


    protected boolean checkPermission(String var1) throws SecurityException {
        if(this.context.checkCallingOrSelfPermission(var1) == 0) {
            return true;
        } else {
            throw new SecurityException(var1 + " is not granted.");
        }
    }






}
