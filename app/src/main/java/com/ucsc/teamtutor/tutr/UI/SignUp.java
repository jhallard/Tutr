package com.ucsc.teamtutor.tutr.UI;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ucsc.teamtutor.tutr.Model.LogInVerification;
import com.ucsc.teamtutor.tutr.R;


public class SignUp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button goButton = (Button) findViewById(R.id.SIGNUP);
        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Acquire all the information
                EditText emailField = (EditText) findViewById(R.id.EMAIL);
                EditText nameField = (EditText) findViewById(R.id.NAME);
                EditText confirmPasswordField = (EditText) findViewById(R.id.CONFIRM_PASSWORD);
                EditText passwordField = (EditText) findViewById(R.id.PASSWORD);
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();
                String confirmPassword = confirmPasswordField.getText().toString();
                String name = nameField.getText().toString();
                boolean emailValidity = LogInVerification.validEmail(email);

                //Make sure that 1. email is valid 2. password exists 3. it is equal to confirm
                //password and 4. there is a name
                if (emailValidity
                        && password.length() > 0
                        && password.compareTo(confirmPassword) == 0
                        && name.length() > 0) {
                    //TODO CREATE ACCOUNT HERE!@!@!@!@!
                    //BE SURE TO SIGN THEM IN SOMEWHERE
                    Intent toHome = new Intent(SignUp.this, HomeActivityTutr.class);
                    SignUp.this.startActivity(toHome);
                    finish();
                }

                //Now check each instance it could have gone wrong
                //If it went right, make sure it's still teal so the user knows it's correct.
                //I can't use @color/<color> resources, they don't work with parseColor, but:
                //fa0012 is red and 009688 is teal (default).
                else {
                    if (name.length() == 0){
                        //No name entered in field
                        nameField.setBackgroundColor((Color.parseColor("#fa0012")));
                    } else nameField.setBackgroundColor((Color.parseColor("#009688")));
                    if (!emailValidity){
                        //Invalid email
                        emailField.setBackgroundColor((Color.parseColor("#fa0012")));
                    } else emailField.setBackgroundColor((Color.parseColor("#009688")));
                    if (password.length() == 0){
                        //No password entered
                        passwordField.setBackgroundColor((Color.parseColor("#fa0012")));
                    } else passwordField.setBackgroundColor((Color.parseColor("#009688")));
                    if (password.compareTo(confirmPassword) != 0){
                        //Confirmation password does not match password entry
                        confirmPasswordField.setBackgroundColor((Color.parseColor("#fa0012")));
                    }
                    else confirmPasswordField.setBackgroundColor((Color.parseColor("#009688")));
                }
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
