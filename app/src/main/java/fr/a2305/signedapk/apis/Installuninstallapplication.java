package fr.a2305.signedapk.apis;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import fr.a2305.signedapk.Agent.InstallApplicationAgent;
import fr.a2305.signedapk.Manager.ApplicationManager;
import fr.a2305.signedapk.R;
import fr.a2305.signedapk.interfaces.OnInstalledPackaged;


/*
	* This application installs/uninstalls an application package using 'ApplicationPolicy.installApplication()/ApplicationPolicy.uninstallApplication()'

    * related file in this project (you can find related code with keyword 'Installuninstallapplication' in that file)
      - res/layout/api_list.xml
      - manifests/AndroidManifest.xml
      - this file (apis/Installuninstallapplication.java)

    * related method in this file
      - onClickEvent()
 */

public class Installuninstallapplication extends Activity {
	InstallApplicationAgent installApplicationAgent ;
	private final static String TAG = "Installuninstallapplication";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.api_list);
		installApplicationAgent = new InstallApplicationAgent(getApplicationContext());
	}

    public void onClickEvent(View v){
        switch(v.getId()) {
			// Install application using ApplicationPolicy.installApplication()
			case R.id.btInstall:
			/*{
				boolean result = installApplicationAgent.installApplication("/mnt/sdcard/toto.apk", false);
				if (true == result) {
					new AlertDialog.Builder(Installuninstallapplication.this)
							.setTitle("Success")
							.setMessage("'DummyApp'(package name:test.dummyapp)\nhas been successfully installed.")
							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int which) {
									finish();
								}
							})
							.show();

				} else {
					new AlertDialog.Builder(Installuninstallapplication.this)
							.setTitle("Fail")
							.setMessage("'DummyApp'\nhas not been installed.\n(package name:test.dummyapp)\n\nPlease store 'DummyApp.apk' \nin '/storage/emulated/0/Download/' first.")
							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int which) {
									moveTaskToBack(true);
									finish();
									android.os.Process.killProcess(android.os.Process.myPid());
								}
							})
							.show();
				}
			}*/

				try {
					final ApplicationManager am = new ApplicationManager(Installuninstallapplication.this);
					am.setOnInstalledPackaged(new OnInstalledPackaged() {

						@SuppressLint("LongLogTag")
						public void packageInstalled(String packageName, int returnCode) {
							if (returnCode == ApplicationManager.INSTALL_SUCCEEDED) {
								Log.d(TAG, "Install succeeded");
							} else {
								Log.d(TAG, "Install failed: " + returnCode);
							}
						}
					});


					

							try {
								am.installPackage("/mnt/sdcard/toto.apk".toString());
							} catch (Exception e) {
								logError(e);
							}
						
				

				} catch (Exception e) {
					logError(e);
				}
			break;

			// Uninstall application using ApplicationPolicy.uninstallApplication()
			case R.id.btUninstall:
				/*
				if(null == appPolicy.getApplicationName("test.dummyapp"))
				{
					new AlertDialog.Builder(Installuninstallapplication.this)
							.setTitle("Alert")
							.setMessage("Please install 'DummyApp' first.\n(package name:test.dummyapp)")
							.setPositiveButton("OK", null)
							.show();
				}else {
					try {
						boolean result = appPolicy.uninstallApplication("test.dummyapp", false);
						if (true == result) {
							new AlertDialog.Builder(Installuninstallapplication.this)
									.setTitle("Success")
									.setMessage("'DummyApp'(package name:test.dummyapp)\nhas been successfully removed.")
									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface dialog, int which) {
											finish();
										}
									})
									.show();

						} else {
							new AlertDialog.Builder(Installuninstallapplication.this)
									.setTitle("Fail")
									.setMessage("'DummyApp'\nhas not been removed.\n(package name:test.dummyapp)")
									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface dialog, int which) {
											moveTaskToBack(true);
											finish();
											android.os.Process.killProcess(android.os.Process.myPid());
										}
									})
									.show();
						}
					} catch (SecurityException e) {
						Log.w(Installuninstallapplication.this.getLocalClassName(), "SecurityException: " + e);
					}
				}*/
				break;

		}

    }

	private void logError(Exception e) {
		e.printStackTrace();
		Toast.makeText(Installuninstallapplication.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
	}


	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/*
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.action_disable_admin:

			SharedPreferences sharedpreferences = getSharedPreferences(
					SAConstants.MY_PREFS_NAME, Context.MODE_PRIVATE);
			Editor editor = sharedpreferences.edit();

			if (sharedpreferences.getBoolean(SAConstants.ADMIN, false)) {
				editor.putBoolean(SAConstants.ADMIN, false);
			}
			editor.putBoolean(SAConstants.ELM, false);
			editor.commit();
			Intent intent = new Intent(this, AdminLicenseActivation.class);
			intent.putExtra(SAConstants.DEACTIVATION_REQUIRED, true);
			startActivity(intent);
			finish();
			break;

		case R.id.action_about_app:
			Intent aboutAppIntent = new Intent(this, AboutActivity.class);
			startActivity(aboutAppIntent);

			break;

		default:
			return super.onOptionsItemSelected(item);
		}

		return true;
	}
	*/
}
