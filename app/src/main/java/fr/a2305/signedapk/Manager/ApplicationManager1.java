package fr.a2305.signedapk.Manager;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.util.List;
import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import fr.a2305.signedapk.Agent.AgentFetcher;
import fr.a2305.signedapk.interfaces.DeviceManagerPolicy;
import fr.a2305.signedapk.interfaces.MessageWatcher;
import fr.a2305.signedapk.interfaces.NetworkEventListener;
import fr.a2305.signedapk.interfaces.ServiceBroker;

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
public  final class ApplicationManager1 {
    private static final String a = "ApplicationManager";
    private static boolean c = false;
    private static ApplicationManager1 d = null;
    private Context e;
  //  public ApplicationManager.a k;
    private AgentFetcher fether;
    private MessageWatcher l;
    private List<Integer> m;
    private ExecutorService n;
    private Future<?> o;
    private NetworkEventListener p = null;
    private static ApplicationManager1.Status q;
    private ExecutorService r;
    private FutureTask<ServiceBroker> s;
    private ServiceBroker t;
    private Handler u;
    private final String v = "WatchdogTimer";
    private final String w = "WatchdogKickTimer";
    private Timer x;
    private Timer y;
    private final int z = 1;
    private final int A = 2;



    static {
        q = Status.READY;
    }


    public ApplicationManager1(Context var1 , DeviceManagerPolicy.SystemPolicy var2 ){
        this.e = var1;
      //  k = null;
       // this.k = new ApplicationManager.a((byte)0);
       // this.k.setName("AgentManagerThread");
      //  this.p = new ApplicationManager.b((byte)0);
        ApplicationManager1 var3 = this;

        try{
            if(var3.n == null){
                var3.n = Executors.newSingleThreadExecutor();
                //var3.o = var3.n.submit(var3.k);

            }

        } catch(Exception e){
            Log.e(a, "Exception in applicationManger" ,e);
        }
        this.r = Executors.newSingleThreadExecutor();
        this.s = new FutureTask(new Callable() {
            @Override
            public ServiceBroker call() throws Exception {
                //return ApplicationManager.this.new c((byte)0);
                return null;
            }
        });
        this.r.submit(this.s);
        q = ApplicationManager1.Status.STARTED;
        //this.f = new ServiceMain(var1, var2, new ApplicationManager.d((byte)0));

       // k = null;
    }



    public enum Status {
        READY,
        STARTED,
        RUNNING;

      private Status(){
      }
    }


}

