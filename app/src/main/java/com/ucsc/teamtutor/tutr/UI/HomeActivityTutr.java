package com.ucsc.teamtutor.tutr.UI;



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
import android.widget.ListView;

import com.ucsc.teamtutor.tutr.Model.FrontEndNode;
import com.ucsc.teamtutor.tutr.Model.Student;
import com.ucsc.teamtutor.tutr.Model.Tutor;
import com.ucsc.teamtutor.tutr.R;

import java.util.ArrayList;


public class HomeActivityTutr extends ActionBarActivity {

    //I need a way to access the student's data.  For that I need a student object.  I don't know
    //how to ge that yet so I'm putting in this dummy.
    Student example = new Student();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_tutr);

        ListView tutorList = (ListView) findViewById (R.id.TUTORS);
        ArrayList<Tutor> tutors = FrontEndNode.getNearestTutors(null,
                example.getLongitude(), example.getLatitude());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_activity_tutr, menu);
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
