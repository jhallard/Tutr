package com.ucsc.teamtutor.tutrappengine.Model;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


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
     * @param pw Password for the student                
     * @return bool, true if we could update
     */
    @ApiMethod(name = "createStudent")
    public static boolean createStudent(Student updated, String pw){
        // make sure that student exists in the database
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey("Student", updated.getEmail());
        Entity student = null;
        try {
            student = datastore.get(key);
            key = KeyFactory.createKey("Tutor", updated.getEmail());
            datastore.get(key);
            return false; // if we get here that means a student or tutor with the email already exists.
        }catch(Exception e) {
            student = new Entity("Student", updated.getEmail());
        }

        student.setProperty("email", updated.getEmail());
        student.setProperty("fullname", updated.getName());
        student.setProperty("joindate", "");
        student.setProperty("password", pw);
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
    public static boolean createTutor(Tutor updated, String pw){        
        // make sure that student exists in the database
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey("Tutor", updated.getEmail());
        Entity tutor = null;
        try {
            tutor = datastore.get(key);
            key = KeyFactory.createKey("Student", updated.getEmail());
            datastore.get(key);
            return false; // if we get here that means a student or tutor with the email already exists.
        }catch(Exception e) {
            tutor = new Entity("Tutor", updated.getEmail());
        }

        tutor.setProperty("email", updated.getEmail());
        tutor.setProperty("fullname", updated.getName());
        tutor.setProperty("joindate", "");
        tutor.setProperty("password", pw);
        datastore.put(tutor);
        return true;
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
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        Filter priceFilter = new FilterPredicate("Price",FilterOperator.GREATER_THAN_OR_EQUAL, 40.0);

        Query q = new Query("Tutor").setFilter(priceFilter);

        PreparedQuery pq = datastore.prepare(q);

        ArrayList<Tutor> tutors = new ArrayList<Tutor>();
        
        for (Entity result : pq.asIterable()) {
            String name = (String) result.getProperty("FullName");
            String email = (String) result.getProperty("Email");
            double lon = (double) result.getProperty("Longitude");
            double lat = (double) result.getProperty("Longitude");

            Tutor tutor = new Tutor();
            tutor.setName(name);
            tutor.setEmail(email);
            tutor.setLongitude(lon);
            tutor.setLatitude(lat);
            
            tutors.add(tutor);
            
        }
        
        
        return tutors;
    }

    /**
     * This method updates a tutor 
     *
     * @param email the email of the user
     * @param password the pw of the user                                 
     * @return bool, true if we could update
     */
    @ApiMethod(name = "verifyUserInfo")
    public static int verifyUserInfo(String email, String password){
        int validInfo = 2; //0 = student, 1 = tutor, 2 = email fail, 3 = pass fail
        //TODO pull data from database and compare to data
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey("Student", email);
        Entity student = null;
        try {
            student = datastore.get(key);
            String pass = (String) student.getProperty("Password");
            if(!(pass.compareTo(password) == 0)){
                return 3; // password fail
            } 
            else {
                return 0; // else is student
            }
        }catch(Exception e) {
            
        }

        Entity tutor = null;
        key = KeyFactory.createKey("Student", email);
        try {
            datastore.get(key);
            tutor = datastore.get(key);
            String pass = (String) tutor.getProperty("Password");
            if(!(pass.compareTo(password) == 0)){
                return 3; // password fail
            }
            else {
                return 1; // else is a tutor
            }
        }catch(Exception e) {
            return 2;
        }
    }

    /**
     * This method logs in a student
     *
     * @param email the email of the user
     * @param password the pw of the user
     * @return Student object associated with login credentials                
     */
    @ApiMethod(name = "studentLogIn")
    public static Student studentLogIn(String email, String password) {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey("Student", email);
        Entity student = null;
        try {
            student = datastore.get(key);
            String pass = (String) student.getProperty("Password");
            if(!(pass.compareTo(password) == 0)){
                return null; // password fail
            }
        }catch(Exception e) {
            return null;
        }
        
        Student the_student = new Student();
        the_student.setEmail((String) student.getProperty("Email"));
        the_student.setName((String) student.getProperty("Name"));
        the_student.setEmail((String) student.getProperty("Phone"));
        the_student.setLongitude((double) student.getProperty("Longitude"));
        the_student.setLatitude((double) student.getProperty("Latitude"));
        the_student.setBio((String) student.getProperty("Bio"));
        
        return the_student;
    }

    /**
     * This method logs in a tutor
     *
     * @param email the email of the user
     * @param password the pw of the user
     * @return Student object associated with login credentials                
     */
    @ApiMethod(name = "tutorLogIn")
    public static Tutor tutorLogIn(String email, String password) {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey("Student", email);
        Entity tutor = null;
        try {
            tutor = datastore.get(key);
            String pass = (String) tutor.getProperty("Password");
            if(!(pass.compareTo(password) == 0)){
                return null; // password fail
            }
        }catch(Exception e) {
            return null;
        }

        Tutor the_tutor = new Tutor();
        the_tutor.setEmail((String) tutor.getProperty("Email"));
        the_tutor.setName((String) tutor.getProperty("Name"));
        the_tutor.setEmail((String) tutor.getProperty("Phone"));
        the_tutor.setLongitude((double) tutor.getProperty("Longitude"));
        the_tutor.setLatitude((double) tutor.getProperty("Latitude"));
        the_tutor.setBio((String) tutor.getProperty("Bio"));
        the_tutor.setPrice((double) tutor.getProperty("Price"));

        return the_tutor;
    }

}