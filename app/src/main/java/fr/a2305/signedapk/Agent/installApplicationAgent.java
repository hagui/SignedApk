package fr.a2305.signedapk.Agent;

import java.util.List;

import fr.a2305.signedapk.interfaces.ApplicationInstallPolicy;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public class installApplicationAgent implements ApplicationInstallPolicy {
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
        return false;
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
