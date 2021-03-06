package com.example.motax.Common.LoginSignUp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.motax.R;

public class SignUpActivity extends AppCompatActivity {

    //variables
    ImageView backtbn;
    Button next, login_signup;
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Hooks
        backtbn = findViewById(R.id.btnSignUp_Back);
        next = findViewById(R.id.btnSignUp_Next);
        login_signup = findViewById(R.id.btnSignUp_Login);
        titleText = findViewById(R.id.txtSignUp_title);
    }

    public void callNextSignUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Sign_up_success.class);

        //Add Transition
        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View, String>(backtbn, "transition_back_signup_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_signup_btn");
        pairs[2] = new Pair<View, String>(login_signup, "transition_login_signup_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_signup");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}