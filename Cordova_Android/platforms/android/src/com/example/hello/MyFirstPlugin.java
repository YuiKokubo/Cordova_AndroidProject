package com.example.hello;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import com.sun.jna.Native;
import com.sun.jna.Library;

/**
 * Created by yuikokubo on 2016/12/22.
 */

public class MyFirstPlugin extends CordovaPlugin {
    static String x;
        @Override
        public boolean execute (String action, JSONArray args,
            CallbackContext callbackContext)throws JSONException{
                Sample lib = (Sample) Native.loadLibrary("hello", Sample.class);
                x = lib.hello();
                callbackContext.success(x);
        return true;
    }
    interface Sample extends Library{
        String hello();
    }
}
