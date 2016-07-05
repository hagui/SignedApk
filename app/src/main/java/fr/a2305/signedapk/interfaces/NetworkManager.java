package fr.a2305.signedapk.interfaces;

import android.net.wifi.WifiInfo;

import java.util.List;

import fr.a2305.signedapk.utils.NetworkMessage;

/**
 *  -
 * Created by hagui on 2016.
 */
public interface  NetworkManager extends Controller {
    void setVip(String var1) throws Exception;

    boolean isVLanEnabled();

    void start() throws Exception;

    void stop();

    void replace(NetworkManager var1);

    void registerListener(NetworkEventListener var1);

    void unregisterListener(NetworkEventListener var1);

    List<String> getInteractionNodesIpList();

    boolean isInteractionIp(String var1);

    void setServer(boolean var1);

    String getLocalNodeName();

    String getLocalIpAddress();

    String getLocalPort();

    String getNodeIp(String var1);

    int getNodePort(String var1);

    boolean isLocalDevice(String var1);

    int sendData(NetworkMessage var1);

    void connect(String var1, String var2, String var3);

    void connect(List<String> var1);

    WifiInfo getWifiInfo();

    boolean isWifiAvailable();

    String getMacAddress();


}
