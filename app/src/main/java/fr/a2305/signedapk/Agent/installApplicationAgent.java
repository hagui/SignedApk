package fr.a2305.signedapk.Agent;

import android.content.Context;
import android.content.pm.PackageManager;

import java.util.List;

import fr.a2305.signedapk.interfaces.ApplicationInstallPolicy;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public class installApplicationAgent extends MainAgent implements ApplicationInstallPolicy {
    private Context mContext;

    public installApplicationAgent(Context mContext) {
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
        return false;
    }

    @Override
    public boolean updateApplication(String apkFilePath) {
        return false;
    }

    @Override
    public boolean uninstallApplication(String packageName, boolean keepDataAndCache) {
        return false;
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
