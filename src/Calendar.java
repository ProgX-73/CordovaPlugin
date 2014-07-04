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

    cordova.getActivity();
    callbackContext.success();
        return true;
    }
  
        
        
}
