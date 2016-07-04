package fr.a2305.signedapk.interfaces;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public class RequestParam {


    private ArrayList<RequestParam.a> a = new ArrayList();

    public RequestParam() {
    }

    public void addParam(String var1, String var2) {
        this.a.add(new RequestParam.a(var1, var2));
    }

    public int size() {
        return this.a.size();
    }

    public String getKey(int var1) {
        return ((RequestParam.a)this.a.get(var1)).a;
    }

    public String getValue(int var1) {
        return ((RequestParam.a)this.a.get(var1)).b;
    }

    public static String encodeParam(String var0, String var1) {
        try {
            return new String(URLEncoder.encode(var0, "UTF-8") + "=" + URLEncoder.encode(var1, "UTF-8"));
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static String makeURL(boolean var0, String var1, int var2, String var3, RequestParam var4) {
        StringBuffer var5 = new StringBuffer();
        if(var0) {
            var5.append("https://" + var1 + ":" + var2 + "/" + var3);
        } else {
            var5.append("http://" + var1 + ":" + var2 + "/" + var3);
        }

        if(var4 != null) {
            var5.append("/");

            for(int var7 = 0; var7 < var4.size(); ++var7) {
                try {
                    if(var4.getKey(var7) != null && var4.getValue(var7) != null) {
                        var5.append(URLEncoder.encode(var4.getKey(var7), "UTF-8"));
                        var5.append("=");
                        var5.append(URLEncoder.encode(var4.getValue(var7), "UTF-8"));
                        if(var7 < var4.size() - 1) {
                            var5.append('&');
                        }
                    }
                } catch (UnsupportedEncodingException var6) {
                    var6.printStackTrace();
                    return null;
                }
            }
        }

        return var5.toString();
    }


    public static String makeApiWithParam(String var0, RequestParam var1) {
        StringBuffer var4 = new StringBuffer(var0);
        if(var1 != null) {
            var4.append('?');

            for(int var2 = 0; var2 < var1.size(); ++var2) {
                try {
                    if(var1.getKey(var2) != null && var1.getValue(var2) != null) {
                        var4.append(URLEncoder.encode(var1.getKey(var2), "UTF-8"));
                        var4.append("=");
                        var4.append(URLEncoder.encode(var1.getValue(var2), "UTF-8"));
                        if(var2 < var1.size() - 1) {
                            var4.append('&');
                        }
                    }
                } catch (UnsupportedEncodingException var3) {
                    var3.printStackTrace();
                    return null;
                }
            }
        }

        return var4.toString();
    }


    private static class a {
        private String a;
        private String b;

        public a(String var1, String var2) {
            this.a = var1;
            this.b = var2;
        }
    }
}
