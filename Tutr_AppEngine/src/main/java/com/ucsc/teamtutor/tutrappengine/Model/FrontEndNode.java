package com.ucsc.teamtutor.tutrappengine.Model;

/**
 * Created by HP on 1/10/2015.
 */
public class FrontEndNode {
    static LogInVerification verifier;
    static boolean updateStudent(Student updated){
        boolean success = false;
        return success;
    }
    static boolean createStudent(Student updated){
        boolean success = false;
        return success;
    }
    static boolean deleteStudent(Student updated){
        boolean success = false;
        return success;
    }
    static Tutor getNearestTutors(String subject, double longitude, double latitude){
        //TODO find nearby tutors using gps finder
        Tutor nearByTutors = null;
        return nearByTutors;
    }
    static int verifyUserInfo(String username, String password){
        int validInfo = 2; //0 = success, 1 = password fail, 2 = username fail
        //TODO pull data from database and compare to data
        return validInfo;
    }
}
