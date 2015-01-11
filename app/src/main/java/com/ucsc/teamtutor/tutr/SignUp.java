package com.ucsc.teamtutor.tutr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignUp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button goButton = (Button) findViewById(R.id.SIGNUP);
        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText emailField = (EditText) findViewById(R.id.EMAIL);
                String Email = emailField.getText().toString();
                if(LogInVerification.validEmail(Email)) {
                    //TODO CREATE ACCOUNT HERE!@!@!@!@!
                    //BE SURE TO SIGN THEM IN SOMEWHERE
                    Intent toHome = new Intent(SignUp.this, HomeActivityTutr.class);
                    SignUp.this.startActivity(toHome);
                    finish();
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
