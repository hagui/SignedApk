package fr.a2305.signedapk.interfaces;

/**
 * signedApk -
 * Created by hagui on 2016.
 */
public interface ServiceBroker {
    <T> Object getService(T var1) throws IllegalStateException;
    void replaceService(String var1, Controller var2);
}
