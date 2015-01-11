package com.ucsc.teamtutor.tutrappengine.Model;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "backEndNodeApi",
        version = "v1",
        resource = "backEndNode",
        namespace = @ApiNamespace(
                ownerDomain = "Model.tutrappengine.teamtutor.ucsc.com",
                ownerName = "Model.tutrappengine.teamtutor.ucsc.com",
                packagePath = ""
        )
)
public class BackEndNodeEndpoint {

    private static final Logger logger = Logger.getLogger(BackEndNodeEndpoint.class.getName());

    /**
     * This method updates the student 
     *
     * @param updated The id of the student to update.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "updateStudent")
    public static boolean updateStudent(Student updated){
        // make sure that student exists in the database
        boolean success = false;
        return success;
    }

    /**
     * This method creates the student 
     *
     * @param updated The id of the student to create.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "createStudent")
    public static boolean createStudent(Student updated){
        // make sure that student exists in the database
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity student = new Entity("Student", updated.email);
        student.setProperty("email", updated.email);
        student.setProperty("fullname", updated.name);
        student.setProperty("joindate", "");
        student.setProperty("password", updated.password);
        datastore.put(student);
        return true;
    }

    /**
     * This method deletes the student 
     *
     * @param updated The id of the student to delete.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "deleteStudent")
    public static boolean deleteStudent(Student updated){
        // make sure that student exists in the database
        boolean success = false;
        return success;
    }
    
    /**
     * This method updates a tutor 
     *
     * @param updated The id of the tutor to delete.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "updateTutor")
    public static boolean updateTutor(Tutor updated){
        // make sure that student exists in the database
        boolean success = false;
        return success;
    }

    /**
     * This method updates a tutor 
     *
     * @param updated The id of the tutor to delete.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "createTutor")
    public static boolean createTutor(Tutor updated){
        // make sure that the new student doesn't exist in the database,
        // then add the student and return true
        boolean success = false;
        return success;
    }

    /**
     * This method updates a tutor 
     *
     * @param updated The id of the tutor to delete.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "deleteTutor")
    public static boolean deleteTutor(Tutor updated) {
        // see if the user exists in the database, if so delete them
        boolean success = false;
        return success;
    }

    /**
     * This method updates a tutor 
     *
     * @param subject The id of the tutor to delete
     * @param longitude the longitude coordinate
     * @param latitude the latitude coordinate                                   
     * @return Array list of tutor object, in sorted order of best ranking
     */
    @ApiMethod(name = "getNearestTutors")
    public static ArrayList<Tutor> getNearestTutors(String subject, double longitude, double latitude){
        //TODO find nearby tutors using gps finder
        ArrayList<Tutor> nearByTutors = null;
        return nearByTutors;
    }

    /**
     * This method updates a tutor 
     *
     * @param username the email of the user
     * @param password the pw of the user                                 
     * @return bool, true if we could update
     */
    @ApiMethod(name = "verifyUserInfo")
    public static int verifyUserInfo(String username, String password){
        int validInfo = 2; //0 = success, 1 = password fail, 2 = username fail
        //TODO pull data from database and compare to data
        return validInfo;
    }

    /**
     * This method logs in a student
     *
     * @param username the email of the user
     * @param password the pw of the user
     * @return Student object associated with login credentials                
     */
    @ApiMethod(name = "studentLogIn")
    public static Student StudentLogIn(String username, String password) {
        Student student = null;
        return student;
    }

    /**
     * This method logs in a tutor
     *
     * @param username the email of the user
     * @param password the pw of the user
     * @return Tutor object associated with login credentials
     */
    @ApiMethod(name = "tutorLogIn")
    public static Tutor TutorLogIn(String username, String password) {
        Tutor tutor = null;
        return tutor;
    }

}