package fr.a2305.signedapk.interfaces;

import android.view.Surface;

/**
 * ${PROJECTED_NAME} -
 * Created by hagui on 2016.
 */
public interface ScreenShareController {

    void stopScreenSend();

    void stopScreenReceive();

    void setSurface(Surface var1);
}
