package com.example.menu;

import android.content.Intent;
import android.hardware.SensorManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menu.StrictMode.StrictMode;
import com.example.menu.bll.LoginBLL;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView link_signup;
    Intent intent;

    private int id=1;

    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // will hide the title bar
        this.getWindow()

                .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//enable full scren


        setContentView(R.layout.activity_login);



        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        link_signup = findViewById(R.id.link_signup);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    auth();

            }
        });
        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void auth() {
        final LoginBLL bll = new LoginBLL(etUsername.getText().toString(),etPassword.getText().toString());
        StrictMode.StrictMode();
        if(bll.checkUser()){


                    intent = new Intent(LoginActivity.this, MainActivity.class);


            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_LONG).show();
        }



    }




}