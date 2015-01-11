package com.ucsc.teamtutor.tutr.UI;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.ucsc.teamtutor.tutr.Model.LogInVerification;
import com.ucsc.teamtutor.tutr.R;


public class LogIn extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button login = (Button) findViewById(R.id.ATTEMPT_LOGIN);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //Pass in login data to check
                EditText emailField = (EditText) findViewById(R.id.EMAIL);
                EditText passwordField = (EditText) findViewById(R.id.PASSWORD);
                emailField.setBackgroundColor(Color.parseColor("@color/teal"));
                passwordField.setBackgroundColor(Color.parseColor("@color/teal"));
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();
                int signInSuccess = LogInVerification.checkSignIn(email, password);
                if(signInSuccess == 0) {
                    //BE SURE TO SIGN THEM IN SOMEWHERE
                    Intent toHome = new Intent(LogIn.this, HomeActivityTutr.class);
                    LogIn.this.startActivity(toHome);
                    finish();
                } else {
                    //MAKE EMAIL FIELD RED
                    if (signInSuccess == 1 || signInSuccess == 2)
                        emailField.setBackgroundColor(Color.parseColor("@color/red"));
                    else //MAKE PASSWORD FIELD RED
                        if (signInSuccess == 3) {
                            passwordField.setBackgroundColor(Color.parseColor("@color/red"));
                        }
                }
            }
        });

        Button signUp = (Button) findViewById(R.id.SIGNUP);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent toSignUp = new Intent(LogIn.this, SignUp.class);
                LogIn.this.startActivity(toSignUp);
                finish();
            }
        });

        Button forgot = (Button) findViewById(R.id.FORGOT_PASSWORD);
        forgot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TBD
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
