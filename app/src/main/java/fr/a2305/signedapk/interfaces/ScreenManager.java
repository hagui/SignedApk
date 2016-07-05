package fr.a2305.signedapk.interfaces;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;

import fr.a2305.signedapk.screen.ScreenUDM;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public interface ScreenManager extends Controller{

    void setCaptureSize();

    void setScreenSize();

    Point getScreenSize();

    Bitmap getScreenBitmap(int var1 , int var2);

    Bitmap getScreenBitmap();

    byte[] getScreenBytes(ScreenManager.Codec var1);

    byte[] getScreenBytes(ScreenManager.Codec var1, int var2, int var3);

    byte[] getScreenBytes(ScreenManager.Codec var1, Bitmap var2);

    void startEncoder(ScreenManager.Codec var1, int var2, int var3, ScreenUDM.Quality var4);

    void stopEncoder(ScreenManager.Codec var1);

    void updateQuality(ScreenManager.Codec var1, ScreenUDM.Quality var2);

    void startDecoder(ScreenManager.Codec var1, int var2, int var3);

    Bitmap decode(ScreenManager.Codec var1, byte[] var2);

    public enum Codec {
        JPEG_CODEC(Integer.valueOf(0)),
        SCREEN_CODEC(Integer.valueOf(1));

        private final Integer a;
        private static final HashMap<Integer, Codec> b;

        static {
            b = new HashMap();
            Iterator var1 = EnumSet.allOf(ScreenManager.Codec.class).iterator();

            while(var1.hasNext()) {
                ScreenManager.Codec var0 = (ScreenManager.Codec)var1.next();
                b.put(var0.getId(), var0);
            }

        }

        private Codec(Integer var3) {
            this.a = var3;
        }

        public final Integer getId() {
            return this.a;
        }

        public static ScreenManager.Codec getEnumById(Integer var0) {
            return (ScreenManager.Codec)b.get(var0);
        }
    }
}
