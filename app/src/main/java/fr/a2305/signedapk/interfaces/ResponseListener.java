package fr.a2305.signedapk.interfaces;

import fr.a2305.signedapk.exception.HttpClientException;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public interface ResponseListener {
    void onResponseReceived(ResponseObject var1, Object var2);

    void onExceptionReceived(HttpClientException var1, Object var2, Object var3);

    void onRequestCancelled(Object var1, Object var2);
}
