package fr.a2305.signedapk.screen;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;

/**
 * ${PROJECTED_NAME} -
 * Created by hagui on 2016.
 */
public class ScreenUDM {

    public ScreenUDM() {
    }

    public class ENCODER {
        public static final int JPEG_CODEC = 1;
        public static final int SCREEN_CODEC = 2;

        public ENCODER() {
        }
    }

    public static enum Quality {
        LOW_QUALITY(Integer.valueOf(0)),
        MID_QUALITY(Integer.valueOf(1)),
        HIGH_QUALITY(Integer.valueOf(2));

        private final Integer a;
        private static final HashMap<Integer, Quality> b;

        static {
            b = new HashMap();
            Iterator var1 = EnumSet.allOf(ScreenUDM.Quality.class).iterator();

            while(var1.hasNext()) {
                ScreenUDM.Quality var0 = (ScreenUDM.Quality)var1.next();
                b.put(var0.getId(), var0);
            }

        }

        private Quality(Integer var3) {
            this.a = var3;
        }

        public final Integer getId() {
            return this.a;
        }

        public static ScreenUDM.Quality getEnumById(Integer var0) {
            return (ScreenUDM.Quality)b.get(var0);
        }
    }

}
