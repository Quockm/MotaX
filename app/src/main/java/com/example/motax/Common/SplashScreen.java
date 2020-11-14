package com.example.motax.Common;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.motax.Common.LoginSignUp.RetailerStartUpScreen;
import com.example.motax.MainActivity;
import com.example.motax.R;

/**
 * Created by QuocKM on 12,November,2020
 * EbizWorld company,
 * HCMCity, VietNam.
 */
public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;
    //Variable
    Animation topanim, bottomanim;
    ImageView image;
    TextView appname, sologan, version;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Animation
        Context context;
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.imgLogo);
        appname = findViewById(R.id.txtAppName);
        sologan = findViewById(R.id.txtSologan);
        version = findViewById(R.id.txtVersion);

        image.setAnimation(topanim);
        appname.setAnimation(bottomanim);
        sologan.setAnimation(bottomanim);
        version.setAnimation(bottomanim);

        new Handler().postDelayed(() -> {

            onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
            boolean isFirstime = onBoardingScreen.getBoolean("firstime", true);

            if (isFirstime) {
                SharedPreferences.Editor editor = onBoardingScreen.edit();
                editor.putBoolean("firstime",false);
                editor.commit();
                Intent intent = new Intent(SplashScreen.this, OnBroading.class);
                startActivity(intent);
                finish();
            }
            else {
                Intent intent = new Intent(SplashScreen.this, RetailerStartUpScreen.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}
