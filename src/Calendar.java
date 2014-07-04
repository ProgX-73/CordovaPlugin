package plug;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;


public class Calendar extends CordovaPlugin {
    public static final String ACTION_ADD_CALENDAR_ENTRY = "addCalendarEntry";


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    cordova.getThreadPool().execute(new Runnable() {
			@Override
			public void run() {
				
					try {
						final String message = "HELLO FROM PLUG CORDOVA !!!";
					
							showToast(message, Toast.LENGTH_LONG);
						
					} catch (JSONException e) {
						Log.e(LOG_PROV, LOG_NAME + ": Error: ");
						e.printStackTrace();
						callbackContext.error(e.getMessage());
					}
				
				callbackContext.success();
			}
		});
        return true;
    }
    private void showToast(final String message, final int length) {
        
        cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				toast = Toast.makeText(cordova.getActivity(), message, length);
				toast.show();
			}
		});
		
	}
}
