package fr.a2305.signedapk.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * ${PROJECTED_NAME} -
 * Created by hagui on 2016.
 */
public interface HttpRequestManager extends Controller {
    void request(String var1, Map<String, String> var2, HttpRequestManager.MethodType var3, ResponseListener var4, Object var5);

    void request(String var1, RequestParam var2, Map<String, String> var3, HttpRequestManager.MethodType var4, ResponseListener var5, Object var6);

    void request(String var1, Map<String, String> var2, String var3, Object var4, HttpRequestManager.MethodType var5, ResponseListener var6, Object var7);

    void requestDownload(String var1, Map<String, String> var2, String var3, DownloadListener var4, Object var5) throws FileNotFoundException, IOException;

    void setTimeOUt(int var1);

    void setConnectionTimeOut(int var1);

    void cancelRequest(int var1);

    void requestUpload(String var1, Map<String, String> var2, String var3, String var5, Map<String, String> var6, HttpRequestManager.MethodType var7, UploadListener var8, Object var9) throws FileNotFoundException, IOException;


    public static enum MethodType {
        GET,
        POST,
        PUT,
        DELETE;

        private MethodType() {
        }

    }
}
