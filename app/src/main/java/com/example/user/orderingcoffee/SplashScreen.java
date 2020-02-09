package com.example.user.orderingcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // To make the full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });

        thread.start();
    }

    private void doWork(){
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    private void startApp(){
        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
