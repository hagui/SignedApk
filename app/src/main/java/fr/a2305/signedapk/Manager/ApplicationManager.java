package fr.a2305.signedapk.Manager;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.a2305.signedapk.Agent.AgentFetcher;
import fr.a2305.signedapk.interfaces.DeviceManagerPolicy;
import fr.a2305.signedapk.interfaces.NetworkEventListener;

/**
 * SignedApk-
 * Created by hagui on 2016.
 * TODO to implement
 * it is a basic class of our signed apk
 * to use a such apk. the first step is tocreat instance of this manger
 * Then we creat the needed agent then add it to the manger
 * we will use a singleton to creat it
 * The AgentManager acts as a gateway to add/remove agents (extended from BaseAgent)
 */
public  final class ApplicationManager {
    private static final String a = "ApplicationManager";
    private static boolean c = false;
    private static ApplicationManager d = null;
    private Context mContext;
    private ExecutorService n;
    public static ApplicationManager.Status q;
    private NetworkEventListener p = null;
   // public ApplicationManager.a k;
    private AgentFetcher fether;



    static {
        q = Status.READY;
    }


    public ApplicationManager(Context var1 , DeviceManagerPolicy.SystemPolicy var2 ){
        this.mContext = var1;
      //  k = null;
       // this.k = new ApplicationManager.a((byte)0);
      //  this.p = new ApplicationManager.b((byte)0);
        ApplicationManager var3 = this;

        try{
            if(var3.n == null){
                var3.n = Executors.newSingleThreadExecutor();

            }

        } catch(Exception e){
            Log.e(a, "Exception in applicationManger" ,e);
        }

    }



    public enum Status {
        READY,
        STARTED,
        RUNNING;

      private Status(){
      }
    }


}

