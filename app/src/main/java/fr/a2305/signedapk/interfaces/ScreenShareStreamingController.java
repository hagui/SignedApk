package fr.a2305.signedapk.interfaces;

/**
 * ${PROJECTED_NAME} -
 * Created by hagui on 2016.
 */
public interface ScreenShareStreamingController extends ScreenShareController{

    void startScreenSend(String var1, ScreenShareStreamingController.Resolution var2);

    void startScreenReceive(String var1);

    void pauseScreenSend();

    void resumeScreenSend();

    boolean isSupportScreenStreamingService();

    <T> void registerListener(T var1);

    public static enum Resolution {
        qHD(0),
        HD(1),
        FHD(2),
        HD_SECURE(3);

        private int a;

        private Resolution(int var3) {
            this.a = var3;
        }

        public final int getId() {
            return this.a;
        }
    }
}
