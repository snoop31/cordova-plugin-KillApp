import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.app.AlarmManager;
import android.app.PendingIntent;	

public class KillApp extends CordovaPlugin {
	public static final String TAG = "KillApp_plugin";
	/**
	* Constructor.
	*/
	public KillApp() {}
	/**
	* Sets the context of the Command. This can then be used to do things like
	* get file paths associated with the Activity.
	*
	* @param cordova The context of the main Activity.
	* @param webView The CordovaWebView Cordova is running in.
	*/
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		Log.v(TAG,"Init KillApp");
	}
	public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		
		final int duration = Toast.LENGTH_SHORT;
		final JSONArray params = args;
		// Shows a toast
		cordova.getActivity().runOnUiThread(new Runnable() {
			public void run() {
				
				int shouldRestart = 0;

		        try {
		            shouldRestart = params.getInt(0);
		        } catch (JSONException e) {
		            e.printStackTrace();
		        }
		        
				if(shouldRestart == 1)
				{

					Intent i = cordova.getActivity().getBaseContext().getPackageManager().getLaunchIntentForPackage(
						cordova.getActivity().getBaseContext().getPackageName());
					int mPendingIntentId = 123456;
					PendingIntent mPendingIntent = PendingIntent.getActivity(
						cordova.getActivity().getBaseContext(), mPendingIntentId,    i, PendingIntent.FLAG_CANCEL_CURRENT);
					AlarmManager mgr = (AlarmManager)cordova.getActivity().getBaseContext().getSystemService(cordova.getActivity().getBaseContext().ALARM_SERVICE);
					mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
					
				}
				
				android.os.Process.killProcess(android.os.Process.myPid());
				
			}
		});
		
		return true;
	}
}