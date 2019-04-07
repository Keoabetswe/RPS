package com.example.keo.rps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity
{
    TextView tvName1,tvName2,tvName3,tvName4; //app name
    ImageView image; //app image


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        image = (ImageView) findViewById(R.id.ivLogo);

        Animation anime = AnimationUtils.loadAnimation(this, R.anim.splash_transition);

        image.startAnimation(anime);

        //opens the login activity after the splash screen
        final Intent i = new Intent(this, MainActivity.class);
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    //delays for 5 seconds
                    sleep(5000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
