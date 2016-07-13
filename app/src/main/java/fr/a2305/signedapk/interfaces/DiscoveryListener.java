package fr.a2305.signedapk.interfaces;

import java.util.List;

/**
 * SignedAPK-
 * Created by hagui on 2016.
 */
public interface DiscoveryListener extends Controller {
    public enum InterfaceType {
        WIFI,
        BLE,
        NSD,
        P2P;

        private InterfaceType(){

        }

    }

    List<DiscoveryListener.InterfaceType> getAvailableInterfaceType();

    void startAdvertising(DiscoveryListener.InterfaceType var1 , byte[] var2);

    void startAdvertising(DiscoveryListener.InterfaceType var1 , byte[] var2 , int var3);

    void stopAdvertising(DiscoveryListener.InterfaceType var1);

    void registerServiceDetectListener(DiscoveryListener.InterfaceType var1, ServiceDetectedListener var2);

    void unregisterServiceDetectListener(DiscoveryListener.InterfaceType var1, ServiceDetectedListener var2);
}
