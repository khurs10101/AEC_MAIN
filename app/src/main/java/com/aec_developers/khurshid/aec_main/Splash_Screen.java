package com.aec_developers.khurshid.aec_main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //We create a thread here which will run for 3 seconds and then it will open the main activity
       Thread splashThread= new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   //The screen will sleep for 3 seconds
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   //Exception Handling Area
                   e.printStackTrace();
               }
               finally {
                   //Open the Main activity
                   //What is getBaseContext?
                   //startActivity methods takes intent object
                   startActivity(new Intent(getBaseContext(),MainActivity.class));
               }
           }
       });


        //run the thread
        splashThread.start();
    }

    //Once this activity lifecycle goes out of view, we need to remove this from backstack
    //so that it doesnt appear af6er we press back button


    @Override
    protected void onStop() {
        super.onStop();
        //when this activity reaches this lifecycle we want it to finish
        finish();
    }
}
