package fr.a2305.signedapk.Agent;

import java.util.HashMap;

/**
 * ${PROJECTED_NAME} -
 * Created by hagui on 2016.
 */
public abstract class ServiceMap extends HashMap<String , Object> {
    private static  final long  serialVersionUID = -7455370371057785633L;

    public ServiceMap() {
    }

    public abstract Object queryService(String var1);

    abstract void a(String var1, Object var2);
}
