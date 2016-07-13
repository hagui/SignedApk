package fr.a2305.signedapk.interfaces;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;

/**
 * android signed aok -
 * Created by hagui on 2016.
 */
public interface ScreenShareAgent extends Controller{
    int STREAMING_PORT = 7236;
    boolean REAL_TIME_QOS = false;

    ScreenShareH264Controller getScreenShareH264();

    ScreenShareStreamingController getScreenShareStreaming();

    public static enum PlayingStatus {
        STOPPED,
        STARTED,
        PLAYING,
        ERROR;

        private PlayingStatus() {
        }
    }

    public interface PlayingStatusChangedListener {
        void onPlayingStatusChanged(ScreenShareAgent.PlayingStatus var1);
    }

    public static enum StreamingStatus {
        NOT_CONNECTED(Integer.valueOf(0)),
        CONNECTING(Integer.valueOf(1)),
        CONNECTED(Integer.valueOf(2)),
        DISCONNECTING(Integer.valueOf(3));

        private final Integer a;
        private static final HashMap<Integer, ScreenShareAgent.StreamingStatus> b;

        static {
            b = new HashMap();
            Iterator var1 = EnumSet.allOf(ScreenShareAgent.StreamingStatus.class).iterator();

            while(var1.hasNext()) {
                ScreenShareAgent.StreamingStatus var0 = (ScreenShareAgent.StreamingStatus)var1.next();
                b.put(var0.getId(), var0);
            }

        }

        private StreamingStatus(Integer var3) {
            this.a = var3;
        }

        public static ScreenShareAgent.StreamingStatus getStreamingStatus(Integer var0) {
            return (ScreenShareAgent.StreamingStatus)b.get(var0);
        }

        public final Integer getId() {
            return this.a;
        }
    }

    public interface StreamingStatusChangedListener {
        void onStreamingStatusChanged(ScreenShareAgent.StreamingStatus var1);
    }

}



