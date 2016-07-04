package fr.a2305.signedapk.interfaces;

/**
 * SignedAPK -
 * Created by hagui on 2016.
 */
public interface UploadListener {
    void onUpload(UploadListener.Status var1);

    public enum Status {
        IDLE,
        STARDTED,
        ONGOING,
        DONE,
        STOPPED;

        private Status() {
        }
    }

        public static class UploadProgressStatus {
            long a;
            UploadListener.Status b;

            public UploadProgressStatus() {
            }
        }


}
