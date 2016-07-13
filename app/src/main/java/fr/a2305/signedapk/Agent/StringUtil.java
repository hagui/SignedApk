package fr.a2305.signedapk.Agent;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ${PROJECTED_NAME} -
 * Created by hagui on 2016.
 */

public class StringUtil {
    public static final String TOKEN = "%#";

    public StringUtil() {
    }

    public static boolean equals(String var0, String var1) {
        return var0 == null?var1 == null:var0.equals(var1);
    }

    public static String trim(String var0) {
        return var0 == null?null:var0.trim();
    }

    public static String ltrim(String var0) {
        int var1 = var0.length();

        int var2;
        for(var2 = 0; var2 < var1 && var0.charAt(var2) <= 32; ++var2) {
            ;
        }

        return var0.substring(var2, var1);
    }

    public static String rtrim(String var0) {
        int var1;
        for(var1 = var0.length(); var1 > 0 && var0.charAt(var1 - 1) <= 32; --var1) {
            ;
        }

        return var0.substring(0, var1);
    }

    public static String remove(String var0, String var1) {
        return isNull(var0)?"":replace(var0, var1, "");
    }

    public static String removeComma(String var0) {
        return remove(var0, ",");
    }

    public static String removeColon(String var0) {
        return remove(var0, ":");
    }

    public static boolean isNull(String var0) {
        return var0 == null || var0.trim().length() == 0;
    }

    public static boolean isNull(Object var0) {
        if(var0 instanceof String) {
            String var1 = (String)var0;
            return isNull(var1);
        } else {
            return true;
        }
    }

    public static boolean isNotNull(String var0) {
        return !isNull(var0);
    }

    public static boolean isNotNull(Object var0) {
        if(var0 instanceof String) {
            String var1 = (String)var0;
            return isNotNull(var1);
        } else {
            return false;
        }
    }

    public static String replaceNull(String var0) {
        return replaceNull(var0, "");
    }

    public static String replaceNull(Object var0) {
        if((var0 = var0) == null || !"java.lang.String".equals(var0.getClass().getName())) {
            var0 = "";
        }

        return replaceNull((String)var0, "");
    }

    public static String replaceNull(String var0, String var1) {
        return isNull(var0)?var1:var0.trim();
    }

    public static String replaceNull(Object var0, String var1) {
        String var2;
        return isNull(var2 = replaceNull(var0))?var1:var2.trim();
    }

    public static String replace(String var0, String var1, String var2) {
        return replace(var0, var1, var2, -1);
    }

    public static String replace(String var0, String var1, String var2, int var3) {
        if(!isNull(var0) && !isNull(var1) && var2 != null && var3 != 0) {
            int var4 = 0;
            int var5;
            if((var5 = var0.indexOf(var1, 0)) == -1) {
                return var0;
            } else {
                int var6 = var1.length();
                int var7 = ((var7 = var2.length() - var6) < 0?0:var7) * (var3 < 0?16:(var3 > 64?64:var3));

                StringBuffer var8;
                for(var8 = new StringBuffer(var0.length() + var7); var5 != -1; var5 = var0.indexOf(var1, var4)) {
                    var8.append(var0.substring(var4, var5)).append(var2);
                    var4 = var5 + var6;
                    --var3;
                    if(var3 == 0) {
                        break;
                    }
                }

                var8.append(var0.substring(var4));
                return var8.toString();
            }
        } else {
            return var0;
        }
    }

    public static boolean isNumeric(String var0) {
        if(var0 == null) {
            return false;
        } else {
            int var1 = var0.length();

            for(int var2 = 0; var2 < var1; ++var2) {
                if(!Character.isDigit(var0.charAt(var2))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static int parseInt(String var0) {
        return parseInt((String)var0, 0);
    }

    public static int parseInt(Object var0) {
        return parseInt((String)replaceNull(var0), 0);
    }

    public static int parseInt(Object var0, int var1) {
        return parseInt(replaceNull(var0), var1);
    }

    public static int parseInt(String var0, int var1) {
        int var2;
        if(isNull(var0)) {
            var2 = var1;
        } else if(!isNumeric(var0)) {
            var2 = var1;
        } else {
            var2 = Integer.parseInt(var0);
        }

        return var2;
    }

    public static long parseLong(String var0) {
        return parseLong(var0, 0L);
    }

    public static long parseLong(String var0, long var1) {
        long var3;
        if(isNull(var0)) {
            var3 = var1;
        } else if(!isNumeric(var0)) {
            var3 = var1;
        } else {
            var3 = Long.parseLong(var0);
        }

        return var3;
    }

    public static List<String> changeList(String[] var0) {
        ArrayList var1 = new ArrayList();
        if(var0 == null) {
            return var1;
        } else {
            int var2 = 0;

            for(int var3 = var0.length; var2 < var3; ++var2) {
                var1.add(var0[var2]);
            }

            return var1;
        }
    }

    public static String[] toTokenArray(String var0, String var1) {
        String[] var2 = null;

        try {
            StringTokenizer var4;
            var2 = new String[(var4 = new StringTokenizer(var0, var1)).countTokens()];

            for(int var5 = 0; var4.hasMoreTokens(); var2[var5++] = var4.nextToken()) {
                ;
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return var2;
    }

    public static String strip(String var0, String var1) {
        if(var0 != null && !"".equals(var0.trim())) {
            for(int var2 = -1; (var2 = var0.indexOf(var1, var2)) != -1; ++var2) {
                String var3 = var0.substring(0, var2);
                var0 = var0.substring(var2 + 1, var0.length());
                var0 = var3 + var0;
            }

            return var0;
        } else {
            return "";
        }
    }

    public static boolean isStringInteger(Object var0) {
        boolean var1 = false;
        if(var0 instanceof String || var0 instanceof Integer) {
            var1 = true;
        }

        return var1;
    }

    public static int getByteSize(String var0, String var1) {
        if(var0 != null && var0.length() != 0) {
            byte[] var3;
            try {
                if(isNotNull(var1)) {
                    var3 = var0.getBytes(var1);
                } else {
                    var3 = var0.getBytes(Charset.defaultCharset());
                }
            } catch (UnsupportedEncodingException var2) {
                return 0;
            }

            return var3 == null?0:var3.length;
        } else {
            return 0;
        }
    }

    public static String toHexString(byte[] var0) {
        if(var0 != null && var0.length != 0) {
            StringBuffer var1 = new StringBuffer(var0.length * 2);

            for(int var3 = 0; var3 < var0.length; ++var3) {
                String var2 = "0" + Integer.toHexString(255 & var0[var3]);
                var1.append(var2.substring(var2.length() - 2));
            }

            return var1.toString();
        } else {
            return null;
        }
    }

    public static byte[] toByte(String var0) {
        if(isNull(var0)) {
            return null;
        } else {
            byte[] var1 = new byte[var0.length() / 2];

            for(int var2 = 0; var2 < var1.length; ++var2) {
                var1[var2] = (byte)Integer.parseInt(var0.substring(2 * var2, 2 * var2 + 2), 16);
            }

            return var1;
        }
    }

    public static boolean compareByteArray(byte[] var0, byte[] var1) {
        return Arrays.equals(var0, var1);
    }

    public static String printHexString(byte[] var0, int var1, int var2) {
        return var2 == 0?"<empty string>":(var2 >= 40?a(var0, var1, 10) + " ... " + a(var0, var1 + var2 - 10, 10) + " [" + var2 + " bytes]":a(var0, var1, var2));
    }

    private static String a(byte[] var0, int var1, int var2) {
        StringBuffer var3 = new StringBuffer();
        String var4 = "0123456789ABCDEF";

        try {
            for(int var5 = 0; var5 < var2; ++var5) {
                int var6 = var0[var1 + var5] >>> 4 & 15;
                int var7 = var0[var1 + var5] & 15;
                var3.append(var4.substring(var6, var6 + 1));
                var3.append(var4.substring(var7, var7 + 1));
            }
        } catch (IndexOutOfBoundsException var8) {
            Log.e(var8.toString() , " Hex Display : Length = " + var2 + ", Offset = " + var1);
        }

        return var3.toString();
    }

    public static String stackTraceToString(Throwable var0) {
        try {
            StringWriter var1 = new StringWriter();
            PrintWriter var2 = new PrintWriter(var1);
            var0.printStackTrace(var2);
            return "------\r\n" + var1.toString() + "------\r\n";
        } catch (Exception var3) {
            return stackTraceToString2(var0);
        }
    }

    public static String stackTraceToString2(Throwable var0) {
        String var1 = "";

        try {
            ByteArrayOutputStream var2 = new ByteArrayOutputStream();
            PrintStream var3 = new PrintStream(var2, true, "UTF-8");
            var0.printStackTrace(var3);
            var3.close();
            var1 = var2.toString();
            var2.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return var1;
    }

    public static final String replaceString(String var0, String var1, String var2) {
        if(var0 != null && var0.length() != 0) {
            StringBuffer var3;
            int var4;
            for(var3 = new StringBuffer(); (var4 = var0.indexOf(var1)) >= 0; var0 = var0.substring(var4 + var1.length())) {
                var3.append(var0.substring(0, var4));
                var3.append(var2);
            }

            if(var0.length() > 0) {
                var3.append(var0);
            }

            return var3.toString();
        } else {
            return var0;
        }
    }

    public static final String ascii2Html(String var0) {
        return var0 != null && var0.length() != 0?replaceString(var0, "\n", "<br>"):var0;
    }

    public static String parseCurrentDateTime() {
        long var0 = System.currentTimeMillis();
        SimpleDateFormat var2 = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date var3 = new Date(var0);
        return var2.format(var3);
    }
}
