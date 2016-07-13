package fr.a2305.signedapk.interfaces;

/**
 * SignedApk-
 * Created by hagui on 2016.
 */
public interface DeviceManagerPolicy {
    DeviceManagerPolicy.SystemPolicy getSystemPolicy();
    DeviceManagerPolicy.LockPolicyType getLockPolicyType();

    public enum SystemPolicy {
        NOMAL,
        ACER,
        LEONOVO;

        private SystemPolicy(){
        }
    }

    public enum LockPolicyType {
        INSTANT_LOCK,
        PERMANENT_LOCK;

        private LockPolicyType(){

        }
    }
}
