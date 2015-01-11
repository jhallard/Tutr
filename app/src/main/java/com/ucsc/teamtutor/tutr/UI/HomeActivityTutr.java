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
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

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
        TutorAdapter adapter = new TutorAdapter(this, tutors);
        tutorList.setAdapter(adapter);
        adapter.addAll(tutors);

        tutorList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //TODO move to profile page, perhaps even a specific one
            }
        });
    }

    public class TutorAdapter extends ArrayAdapter<Tutor>{
        public TutorAdapter (Context context, ArrayList<Tutor> tutors){
            super(context, 0, tutors);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Tutor tutor = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            TextView name = (TextView) convertView.findViewById(R.id.firstLine);
            TextView subjects = (TextView) convertView.findViewById(R.id.secondLine);
            name.setText(tutor.getName());
            subjects.setText(tutor.getTopThreeString());
            return convertView;
        }
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
