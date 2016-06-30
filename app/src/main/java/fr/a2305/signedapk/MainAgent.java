package fr.a2305.signedapk;

import android.content.Context;
import android.os.Handler;

import fr.a2305.signedapk.exception.AgentNotFoundException;

/**
 * MilliwebSignedApk -
 * Created by hagui on 2016.
 * The MainAgent is the basic classe of the application
 * Creation of Agent of the logic Application  is managed by AgentManager.
 * Agent can known changes of settings and changes (using Broadcast receiver)
 */
public abstract class MainAgent {
    protected Context context;
    protected NetworkManager networkManager;
    protected DeviceManager deviceManager;
    protected WifiManager discoveryManager;
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

    protected void notifyUnsupportedAgent(int var1  , String var2){
    }

    //TODO implement after implementation of the fetchClass
    protected final MainAgent getAgent(Class<? extends MainAgent> var1){
        MainAgent var2 = null;
        if((true)){
            return var2;
        } else {
            throw  new AgentNotFoundException("AgentNotSupported");
        }
    }






}
