package fr.a2305.signedapk.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * SignedAPK -
 * Created by hagui on 2016.
 */
public interface ResponseObject {


    int code();

    boolean isSuccessful();

    String message();

    List<String> headers(String var1);

    String header(String var1);

    boolean isRedirect();

    long contentLength() throws IOException;

    String contentType();

    InputStream byteStream() throws IOException;

    byte[] bytes() throws IOException;

    Reader charStream() throws IOException;

    String string() throws IOException;

    void close() throws IOException;

    String toString();


}
