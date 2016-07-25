package fr.a2305.signedapk.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * SignedApk -
 * Created by hagui on 2016.
 */
public class ShellExecutor {


    public ShellExecutor() {
    }

    public String Executer(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String response = output.toString();
        return response;

    }
}
