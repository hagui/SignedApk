package fr.a2305.signedapk.utils;

/**
 * signedApk -
 * Created by hagui on 2016.
 */
public class NetworkMessage {
    private static NetworkMessage i;
    private boolean g;
    private boolean f;
    private Runnable h;
    private NetworkMessage.CastMethod a;
    private NetworkMessage.Protocole b;
    private int c;
    private byte[] d;


    public NetworkMessage(){
    }

    private static synchronized NetworkMessage b(){
        return i == null?(i = new NetworkMessage()):(!i.g?i:new NetworkMessage());
    }


    public enum CastMethod {
        ALL,
        UNICAST;

        private CastMethod(){
        }
    }
    public static enum Protocole {
        TCP,
        UDP,
        MULTITASK;

        private Protocole(){
        }

    }
}
