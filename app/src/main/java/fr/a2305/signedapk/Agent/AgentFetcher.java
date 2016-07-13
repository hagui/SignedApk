package fr.a2305.signedapk.Agent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import fr.a2305.signedapk.interfaces.Controller;
import fr.a2305.signedapk.interfaces.DeviceManager;
import fr.a2305.signedapk.interfaces.DiscoveryListener;
import fr.a2305.signedapk.interfaces.FileShareManager;
import fr.a2305.signedapk.interfaces.HttpRequestManager;
import fr.a2305.signedapk.interfaces.NetworkManager;
import fr.a2305.signedapk.interfaces.ScreenManager;
import fr.a2305.signedapk.interfaces.ScreenShareAgent;
import fr.a2305.signedapk.interfaces.SystemManager;

/**
 * signadeApk -
 * Created by hagui on 2016.
 */
public final class AgentFetcher {

    public static final String NETWORK = NetworkManager.class.getSimpleName();
    public static final String DEVICE = DeviceManager.class.getSimpleName();
    public static  final String DISCOVERY = DiscoveryListener.class.getSimpleName();
    public static final String SCREENSHARE = ScreenShareAgent.class.getSimpleName();
    public static final String SCREEN = ScreenManager.class.getSimpleName();
    public static String SYSTEM = SystemManager.class.getSimpleName();
    public static final String HTTP = HttpRequestManager.class.getSimpleName();
    public static final String FILESHARE = FileShareManager.class.getSimpleName();
    private ServiceMap a = new AgentFetcher.a();


    public  class a extends ServiceMap {
        private static final long serialVersionUID = 6298394514383147704L;

        private a() {
        }

        public final Object queryService(String var1) {
            return this.containsKey(var1)?this.get(var1):null;
        }

        final void a(String var1, Object var2) {
            if(this.queryService(var1) != null && var2 != null) {
                this.remove(var1);
                this.put(var1, var2);
            }

        }
    }

    protected AgentFetcher(){

    }


    public final void replaceService(String var1, Object var2) throws IllegalArgumentException {
        if(!StringUtil.isNull(var1) && var2 != null) {
            if(!this.a.containsKey(var1)) {
                throw new IllegalArgumentException("Cannot find service in service fetcher");
            } else {
                Class[] var3 = this.getService(var1).getClass().getInterfaces();
                ArrayList var4 = new ArrayList();
                if(var3 != null && var3.length > 0) {
                    Class[] var7 = var3;
                    int var6 = var3.length;

                    for(int var5 = 0; var5 < var6; ++var5) {
                        Class var9 = var7[var5];
                        var4.add(var9.getCanonicalName());
                    }
                }

                Iterator var11 = var4.iterator();

                while(var11.hasNext()) {
                    String var10 = (String)var11.next();

                    try {
                        if(!Class.forName(var10).isInstance(var2)) {
                            throw new IllegalArgumentException("New service didn\'t implement interfaces of previous service");
                        }
                    } catch (ClassNotFoundException var8) {
                        var8.printStackTrace();
                        throw new IllegalStateException("Previous service has some problems.");
                    }
                }

                ((Controller)this.a.get(var1)).onStop();
                this.a.put(var1, var2);
            }
        } else {
            throw new IllegalArgumentException("Cannot replace service because of null parameter");
        }
    }

    public final void addService(String var1, Object var2) throws IllegalArgumentException {
        if(!StringUtil.isNull(var1) && var2 != null) {
            if(this.a.containsKey(var1)) {
                throw new IllegalArgumentException("Service exist already");
            } else {
                this.a.put(var1, var2);
            }
        } else {
            throw new IllegalArgumentException("Cannot add service because of null parameter");
        }
    }

    public final Object getService(String var1) {
        return this.a.queryService(var1);
    }

    protected final ServiceMap getServiceMap() {
        return this.a;
    }

    protected final void removeService(String var1) {
        if(this.a.containsKey(var1)) {
            this.a.remove(var1);
        }

    }

    protected final void removeServices() {
        this.a.clear();
    }

    protected final Set<Map.Entry<String, Object>> getServices() {
        return this.a.entrySet();
    }



}
