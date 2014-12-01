package com.iesebre.dam2.pa201415.alex.androidskeletonsign;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import com.iesebre.dam2.pa201415.alex.androidskeletonsign.R;
public class SplashActivity extends Activity {
	 
	// Duració de la pantalla splash
    private static final long SPLASH_SCREEN_DELAY = 7500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Orientació de la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        //Amaguem la barra del títol
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash);
        //IF WE ARE REDIRECTED FROM TWITTER WE NEED TO GET URI
        final Uri uriTwitter = getIntent().getData();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	
                // llamar a la pantalla de login
                Intent mainIntent = new Intent().setClass(
                        SplashActivity.this, LoginActivity.class);
                //we send the uri to login activity
                mainIntent.setData(uriTwitter);
                startActivity(mainIntent);
            	
                //Cerramos la actividad de manera que no se pueda volver atrás
                finish();
            	
            }
        };
    	
        // Simulador
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
    
}
