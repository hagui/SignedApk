package fr.a2305.signedapk.exception;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public class HttpClientException extends Exception {

    private static final long serialVersionUID = 7708836626979499373L;
    public static final int ERR_NONE = 0;
    public static final int ERR_CLIENT_ILLEGAL_STATE = -2;
    public static final int ERR_UNRECOVERABLE_KEY = -3;
    public static final int ERR_KEY_MANAGEMENT = -4;
    public static final int ERR_CERTIFICATE = -5;
    public static final int ERR_CLIENT_KEY_MANAGEMENT = -6;
    public static final int ERR_CLIENT_KEYSTORE = -7;
    public static final int ERR_CLIENT_UNRECOVERABLE_KEY = -8;
    public static final int ERR_CLIENT_NO_SUCH_AlGORITHM = -9;
    private int a;
    private Exception b;

    public HttpClientException() {
        this.a = 0;
        this.b = null;
    }

    public HttpClientException(Exception var1) {
        this(0, var1);
    }

    public HttpClientException(int var1) {
        this(var1, (Exception)null);
    }

    public HttpClientException(int var1, Exception var2) {
        this.a = 0;
        this.b = null;
        this.a = var1;
        this.b = var2;
    }

    public HttpClientException(String var1, Throwable var2) {
        super(var1, var2);
        this.a = 0;
        this.b = null;
    }

    public HttpClientException(String var1) {
        super(var1);
        this.a = 0;
        this.b = null;
    }

    public HttpClientException(Throwable var1) {
        super(var1);
        this.a = 0;
        this.b = null;
    }

    public int getCode() {
        return this.a;
    }

    public Exception getException() {
        return this.b;
    }

}
