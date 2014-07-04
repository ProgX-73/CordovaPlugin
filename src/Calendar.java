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

 
        try {
            if (ACTION_ADD_CALENDAR_ENTRY.equals(action)) {
               
                
                //Sur le UI Thread
                /*cordova.getActivity().runOnUiThread(new Runnable() {
                     public void run() {
                         // Main Code goes here
                         callbackContext.success(); 
                     }
                 }*/
                //Threzad separé
                /*cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                        // Main Code goes here
                        callbackContext.success(); 
                    }
                });*/
                showToast("Hello from cordova plugin !!!", Toast.LENGTH_LONG);
               callbackContext.success();
                return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }

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
