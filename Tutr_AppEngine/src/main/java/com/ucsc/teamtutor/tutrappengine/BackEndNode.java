package com.ucsc.teamtutor.tutrappengine;

import com.tutr.libtutr.Model.Student;
import com.tutr.libtutr.Model.Tutor;

import java.util.ArrayList;

/**
 * Created by jhallard on 1/11/15.
 */
public class BackEndNode {

    public static boolean updateStudent(Student updated){
        // make sure that student exists in the database
        boolean success = false;
        return success;
    }
    public static boolean createStudent(Student updated){
        // make sure that the new student doesn't exist in the database,
        // then add the student and return true
        boolean success = false;
        return success;
    }
    public static boolean deleteStudent(Student updated){
        // see if the user exists in the database, if so delete them
        boolean success = false;
        return success;
    }
    public static boolean updateTutor(Tutor updated){
        // make sure that student exists in the database
        boolean success = false;
        return success;
    }
    public static boolean createTutor(Tutor updated){
        // make sure that the new student doesn't exist in the database,
        // then add the student and return true
        boolean success = false;
        return success;
    }
    public static boolean deleteTutor(Tutor updated){
        // see if the user exists in the database, if so delete them
        boolean success = false;
        return success;
    }
    public static ArrayList<Tutor> getNearestTutors(String subject, double longitude, double latitude){
        //TODO find nearby tutors using gps finder
        ArrayList<Tutor> nearByTutors = null;
        return nearByTutors;
    }
    public static int verifyUserInfo(String username, String password){
        int validInfo = 2; //0 = success, 1 = password fail, 2 = username fail
        //TODO pull data from database and compare to data
        return validInfo;
    }

    public static Student StudentLogIn(String username, String password) {
        Student student = null;
        return student;
    }

    public static Tutor TutorLogIn(String username, String password) {
        Tutor tutor = null;
        return tutor;
    }
    
}
