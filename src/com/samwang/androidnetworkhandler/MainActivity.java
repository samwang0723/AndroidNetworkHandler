package com.samwang.androidnetworkhandler;

import java.util.HashMap;

import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import com.samwang.network.CustomHttpResponse;
import com.samwang.network.NetworkConnectionManager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        try {
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put(HTTP.USER_AGENT, "Mozilla/5.0 (Macintosh; U; PPC Mac OS X; en) AppleWebKit/125.2 (KHTML, like Gecko) Safari/85.8");
            // ... more headers here ...
            CustomHttpResponse response = NetworkConnectionManager.getJsonData("https://sample.com/sample_get_json", headers);
            if(response.getStatusCode() == HttpStatus.SC_OK){
                Object obj = response.getJsonObj();
                if(obj != null){
                    if (obj instanceof JSONObject) {
                        // you have an object
                        JSONObject jobj = (JSONObject)obj;
                        // Handle here...
                    } else if (obj instanceof JSONArray) {
                        // you have an array
                        JSONArray jary = (JSONArray)obj;
                        // Handle here...
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
