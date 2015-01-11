package com.ucsc.teamtutor.tutr;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;

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
                String Email = emailField.getText().toString();
                String Password = passwordField.getText().toString();
                if(LogInVerification.checkSignIn(Email, Password)) {
                    //BE SURE TO SIGN THEM IN SOMEWHERE
                    Intent toHome = new Intent(LogIn.this, HomeActivityTutr.class);
                    LogIn.this.startActivity(toHome);
                    finish();
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
