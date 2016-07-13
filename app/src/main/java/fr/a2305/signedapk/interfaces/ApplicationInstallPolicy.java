package fr.a2305.signedapk.interfaces;

import java.util.List;

/**
 * SignedApk
 * Created by hagui on 2016.
 */
public interface ApplicationInstallPolicy extends  Controller{
    public List<String> uninstallApplications(List<String> packageList);

    public boolean wipeApplicationData(String packageName);

    public boolean isApplicationInstalled(String packageName);

    public boolean isApplicationRunning(String packageName);

    public boolean installApplication(String apkFilePath, boolean installOnSDCard);

    public boolean updateApplication(String apkFilePath);

    public boolean uninstallApplication(String packageName, boolean keepDataAndCache);

    public boolean setDisableApplication(String packageName);

    public boolean setEnableApplication(String packageName);
}
