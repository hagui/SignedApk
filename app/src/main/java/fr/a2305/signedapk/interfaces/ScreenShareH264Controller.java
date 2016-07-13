package fr.a2305.signedapk.interfaces;

import android.view.Surface;

import java.util.List;

/**
 * ${PROJECTED_NAME} -
 * Created by hagui on 2016.
 */
public interface ScreenShareH264Controller extends ScreenShareController{
    void startScreenSend(int var1, int var2, int var3, int var4, List<String> var5);

    void startScreenReceive(int var1, int var2, String var3, int var4, int var5, Surface var6);

    void pauseScreenReceive();

    void resumeScreenReceive();

    void addRecipient(String var1);

    void addRecipientList(List<String> var1);

    void removeRecipient(String var1);

    void resetRecipient(List<String> var1);

    void setRotateClientDisplayOrientation(int var1);
}
