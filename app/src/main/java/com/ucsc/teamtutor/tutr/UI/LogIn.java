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

import com.ucsc.teamtutor.tutr.Model.FrontEndNode;
import com.ucsc.teamtutor.tutr.Model.LoginVerification;
import com.ucsc.teamtutor.tutr.R;
import com.ucsc.teamtutor.tutrappengine.backEndNodeApi.model.*;



public class LogIn extends ActionBarActivity {

    private LoginVerification login_checker = new LoginVerification();
    private FrontEndNode front_node = new FrontEndNode();

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
//                emailField.setBackgroundColor(Color.parseColor("@color/teal"));
//                passwordField.setBackgroundColor(Color.parseColor("@color/teal"));
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();
                int signInSuccess = login_checker.checkSignIn(email, password);
                if(signInSuccess == 0) {
                    //BE SURE TO SIGN THEM IN SOMEWHERE
                    signInSuccess = front_node.verifyUserInfo(email, password);
                    if(signInSuccess == 0) { // the sign-in is a valid student
                        Student user = front_node.StudentLogIn(email, password);
                        Intent toHome = new Intent(LogIn.this, HomeActivityTutr.class);
                        LogIn.this.startActivity(toHome);
                        finish();
                    }
                    else if(signInSuccess == 1) { // the sign-in is a valid tutor
                        Tutor user = front_node.TutorLogIn(email, password);
                        Intent toHome = new Intent(LogIn.this, HomeActivityTutr.class);
                        LogIn.this.startActivity(toHome);
                        finish();
                    }
                    else {
                        int red = Color.parseColor("#fa0012");
                        int teal = Color.parseColor("#009688");
                        //MAKE EMAIL FIELD RED
                        if (signInSuccess == 2) {
                            emailField.setBackgroundColor(red);
                            passwordField.setBackgroundColor(teal);
                        }
                        //MAKE PASSWORD FIELD RED
                        else if (signInSuccess == 3) {
                            passwordField.setBackgroundColor(red);
                            emailField.setBackgroundColor(teal);
                        }
                    }
                } else {
                    //I couldn't use @color/<color>, I have to use hex values.  Otherwise
                    //a runtime error occurs.  As well, I make the other teal, in case the user
                    //fixes a mistake but makes a new one, they don't remain red after they have
                    //been fixed.
                    int red = Color.parseColor("#fa0012");
                    int teal = Color.parseColor("#009688");
                    //MAKE EMAIL FIELD RED
                    if (signInSuccess == 1 || signInSuccess == 2) {
                        emailField.setBackgroundColor(red);
                        passwordField.setBackgroundColor(teal);
                    }
                    //MAKE PASSWORD FIELD RED
                    else if (signInSuccess == 3) {
                        passwordField.setBackgroundColor(red);
                        emailField.setBackgroundColor(teal);
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
