package fr.a2305.signedapk.interfaces;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public interface DownloadListener {

    void onDownload(DownloadListener.Status var1, long var2, long var4, Exception var6, Object var7);

    public static enum Status {
        IDLE,
        STARTED,
        ONGOING,
        DONE,
        STOPPED;

        private Status() {
        }
    }
}
