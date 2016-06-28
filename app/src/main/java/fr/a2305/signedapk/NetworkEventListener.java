package fr.a2305.signedapk;

/**
 * MilliwebSignedApk-
 * Created by hagui on 2016.
 */
public interface NetworkEventListener {
    void onServiceStarted(boolean var1);

    void onServiceStopped();

    void onDataRecevied(int var1, String var2, byte[] var3);

    void onNodeAdded(String var1, String var2, boolean var3);

    void onNodeRemoved(String var1, String var2, boolean var3);

    void onNodeDisconnected(String var1, String var2, boolean var3);

    void onNodeReconnected(String var1, String var2, boolean var3);

    void onNodeReconfigured(String var1, String var2, int var3);
}
