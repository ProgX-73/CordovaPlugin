package plug;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;


public class Calendar extends CordovaPlugin {
    public static final String ACTION_ADD_CALENDAR_ENTRY = "addCalendarEntry";

    private String result ="";
    private String buff="";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		Log.d("Execute thread","Hello world");
    cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
					Log.d("UI thread","Hello world");
				Toast toast = Toast.makeText(cordova.getActivity(), "HELLO FROM PLUG 1", 1);
				toast.show();
				result="1-myResultFromPLuG on UI";
                
                Timer tui = new Timer();
        
                tui.schedule(new TimerTask(){
                    public void run(){
                        
                        Log.d("pool","task read buffer..."+buff);
                    }
                },500,1000);
			}
		});
    
    cordova.getThreadPool().execute(new Runnable() {
    @Override
    public void run() {
    	Log.d("Pool thread","Hello world 2 ;) ****************************************");
        Timer t = new Timer();
        
        t.schedule(new TimerTask(){
            public void run(){
                buff +="*";
                Log.d("pool","task fill buffer...");
            }
        },3000,1000);
    }
    });
        
    
        
         callbackContext.success(result); 
        return true;
    }
  
        
        
}
