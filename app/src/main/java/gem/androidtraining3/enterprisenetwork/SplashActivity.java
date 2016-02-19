package gem.androidtraining3.enterprisenetwork;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;

import gem.androidtraining3.enterprisenetwork.model.ResponseUserInfo;
import gem.androidtraining3.enterprisenetwork.session.Session;
import gem.androidtraining3.enterprisenetwork.util.Constant;

/**
 * Created by huylv on 17/02/2016.
 */
public class SplashActivity extends Activity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1000;
    boolean LOGGEDIN = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //check login
        SharedPreferences sp = getSharedPreferences(Constant.NSP,MODE_PRIVATE);
        LOGGEDIN = sp.contains(Constant.SPKEY_USERJSON);
        if(LOGGEDIN){
            Gson gson = new Gson();
            String s = sp.getString(Constant.SPKEY_USERJSON, "null");
            JsonReader jsonReader = new JsonReader(new StringReader(s));
            jsonReader.setLenient(true);
            ResponseUserInfo responseUserInfo = gson.fromJson(jsonReader, ResponseUserInfo.class);

            Session.setUser(responseUserInfo);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(LOGGEDIN){
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                }else{
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
