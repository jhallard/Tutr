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
        return true;
    }
    
    public boolean createStudent(Student updated, String password){
        try {
            myApiService.createStudent(password, updated).execute();
        }catch(IOException e) {
            return false;
        }
        return true;
    }
    
    public boolean deleteStudent(Student updated){
        // see if the user exists in the database, if so delete them
        boolean success = false;
        return success;
    }
    public boolean updateTutor(Tutor updated){
        try {
            return myApiService.updateTutor(updated).execute().getData();
        }catch(IOException e) {
            return false;
        }
    }
    public boolean createTutor(Tutor updated, String pw){
        try {
            myApiService.createTutor(pw, updated).execute();
        }catch(IOException e) {
            return false;
        }
        return true;
    }
    public boolean deleteTutor(Tutor updated){
        // see if the user exists in the database, if so delete them
        boolean success = false;
        return success;
    }
    public TutorCollection getNearestTutors(String subject, double longitude, double latitude){
        //TODO find nearby tutors using gps finder
        TutorCollection nearByTutors = null;
        try {
            nearByTutors = myApiService.getNearestTutors(subject, longitude, latitude).execute();
        }catch(Exception e) {
            return nearByTutors;
        }
        return nearByTutors;
    }
    public int verifyUserInfo(String username, String password){
        LoginConfirmer confirmer = null;
        try {
            confirmer = (myApiService.verifyUserInfo(username, password).execute());
        }catch(Exception e) {
            confirmer = new LoginConfirmer();
            confirmer.setCode(3);
        }
        return confirmer.getCode();
    }

    public Student StudentLogIn(String username, String password) {
        Student student = null;
        try {
            student = myApiService.userLogIn(username, password).execute();
        }catch(Exception e) {
            student = null;
        }
        return student;
    }

    public Tutor TutorLogIn(String username, String password) {
        Tutor tutor = null;
        try {
            tutor = myApiService.tutorLogIn(username, password).execute();
        }catch(Exception e) {
            tutor = null;
        }
        return tutor;
    }
}
