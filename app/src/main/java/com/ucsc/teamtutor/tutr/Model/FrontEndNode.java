package com.ucsc.teamtutor.tutr.Model;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.ucsc.teamtutor.tutrappengine.backEndNodeApi.model.*;
import com.ucsc.teamtutor.tutrappengine.backEndNodeApi.BackEndNodeApi;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Created by HP on 1/10/2015.
 */
public class FrontEndNode {
    private BackEndNodeApi myApiService = null;

    public FrontEndNode() {
        if (myApiService == null) {  // Only do this once
            BackEndNodeApi.Builder builder = new BackEndNodeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://intense-clarity-821.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }
    }
    public boolean updateStudent(Student updated){

        try {
            Tutor tut = new Tutor();
            myApiService.updateTutor(tut).execute().getData(); 
        }catch(IOException e) {
            int x = 0;
        }
        return true;
    }
    public boolean createStudent(Student updated, String password){
//        myApiService.createStudent(updated, password).execute().getData();
        boolean success = false;
        return success;
    }
    public boolean deleteStudent(Student updated){
        // see if the user exists in the database, if so delete them
        boolean success = false;
        return success;
    }
    public boolean updateTutor(Tutor updated){
        // make sure that student exists in the database
        boolean success = false;
        return success;
    }
    public boolean createTutor(Tutor updated){
        // make sure that the new student doesn't exist in the database,
        // then add the student and return true
        boolean success = false;
        return success;
    }
    public boolean deleteTutor(Tutor updated){
        // see if the user exists in the database, if so delete them
        boolean success = false;
        return success;
    }
    public ArrayList<Tutor> getNearestTutors(String subject, double longitude, double latitude){
        //TODO find nearby tutors using gps finder
        ArrayList<Tutor> nearByTutors = null;
        return nearByTutors;
    }
    public int verifyUserInfo(String username, String password){
        int validInfo = 0; //0 = success, 1 = password fail, 2 = username fail
        //TODO pull data from database and compare to data
        return validInfo;
    }

    public Student StudentLogIn(String username, String password) {
        Student student = null;
        return student;
    }

    public Tutor TutorLogIn(String username, String password) {
        Tutor tutor = null;
        return tutor;
    }
}
