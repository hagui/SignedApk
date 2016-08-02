package fr.a2305.signedapk.Agent;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.List;

import fr.a2305.signedapk.interfaces.ApplicationInstallPolicy;
import fr.a2305.signedapk.utils.ShellExecutor;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public class InstallApplicationAgent extends MainAgent implements ApplicationInstallPolicy {
    private Context mContext;
    private final static String INSTALLCOMMAND = "  pm    install          ";
    private final static String UNINSTALLCOMMAND = " pm uninstall -r ";

    public InstallApplicationAgent(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    protected void onInitialized() {

    }

    @Override
    public List<String> uninstallApplications(List<String> packageList) {
        return null;
    }

    @Override
    public boolean wipeApplicationData(String packageName) {
        return false;
    }

    @Override
    public boolean isApplicationInstalled(String packageName) {
        PackageManager pm = mContext.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean isApplicationRunning(String packageName) {
        return false;
    }

    @Override
    public boolean installApplication(String apkFilePath, boolean installOnSDCard) {
        boolean result = false;
        String response = null;
        ShellExecutor shellExecutor = new ShellExecutor();
        try {
            response = shellExecutor.Executer((this.INSTALLCOMMAND).concat(" " +apkFilePath));
        } catch (Exception e){
            // TODO iplement new Exception
            Log.e(" " , "fail" , e);
            result = false;
        } finally {
            if(response.contains("Succes")){
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean updateApplication(String apkFilePath) {
        return false;
    }

    @Override
    public boolean uninstallApplication(String packageName, boolean keepDataAndCache) {
        boolean result = false;
        String response = null;
        ShellExecutor shellExecutor = new ShellExecutor();
        try {
            response = shellExecutor.Executer((this.INSTALLCOMMAND).concat(packageName));

        } catch (Exception e){
            // TODO iplement new Exception
            Log.e(" " , "fail" , e);
            result = false;
        } finally {
            if(response.contains("succes")){
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean setDisableApplication(String packageName) {
        return false;
    }

    @Override
    public boolean setEnableApplication(String packageName) {
        return false;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
