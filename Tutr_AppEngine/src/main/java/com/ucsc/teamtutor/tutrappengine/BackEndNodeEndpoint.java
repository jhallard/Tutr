package com.ucsc.teamtutor.tutrappengine;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.tutr.libtutr.Model.*;
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
                ownerDomain = "tutrappengine.teamtutor.ucsc.com",
                ownerName = "tutrappengine.teamtutor.ucsc.com",
                packagePath = ""
        )
)
public class BackEndNodeEndpoint {

    private static final Logger logger = Logger.getLogger(BackEndNodeEndpoint.class.getName());

    /**
     * This method updates the student 
     *
     * @param student The id of the student to update.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "updateStudent")
    public static boolean updateStudent(@Named("student")Student student){
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
    public ConfirmValue createStudent(Student updated, @Named("pw")String pw){
        // make sure that student exists in the database
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey("Tutor", updated.getEmail());
        Entity student = null;
        ConfirmValue ret = new ConfirmValue();
        ret.setData(true);
        try {
            student = datastore.get(key);
            key = KeyFactory.createKey("Tutor", updated.getEmail());
            datastore.get(key);
            ret.setData(false); // if we get here that means a student or tutor with the email already exists.
            return ret;
        }catch(Exception e) {
            student = new Entity("Student", updated.getEmail());
        }

        student.setProperty("Email", updated.getEmail());
        student.setProperty("Name", updated.getName());
        student.setProperty("Password", pw);
        datastore.put(student);
        return ret;
    }

    /**
     * This method deletes the student 
     *
     * @param updated The id of the student to delete.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "deleteStudent")
    public ConfirmValue deleteStudent(Student updated){
        ConfirmValue ret = new ConfirmValue();
        ret.setData(false);

        return ret;

    }

    /**
     * This method updates a tutor 
     *
     * @param updated The id of the tutor to delete.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "updateTutor")
    public ConfirmValue updateTutor(Tutor updated){
        ConfirmValue ret = new ConfirmValue();
        ret.setData(false);

        return ret;
    }

    /**
     * This method updates a tutor 
     *
     * @param updated The id of the tutor to delete.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "createTutor", path="create_tutor")
    public ConfirmValue createTutor(Tutor updated, @Named("pw")String pw){
        // make sure that student exists in the database
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey("Tutor", updated.getEmail());
        Entity tutor = null;
        ConfirmValue ret = new ConfirmValue();
        ret.setData(true);
        try {
            tutor = datastore.get(key);
            key = KeyFactory.createKey("Student", updated.getEmail());
            datastore.get(key);
            ret.setData(false); // if we get here that means a student or tutor with the email already exists.
            return ret;
        }catch(Exception e) {
            tutor = new Entity("Tutor", updated.getEmail());
        }

        tutor.setProperty("email", updated.getEmail());
        tutor.setProperty("fullname", updated.getName());
        tutor.setProperty("joindate", "");
        tutor.setProperty("password", pw);
        datastore.put(tutor);
        return ret;
    }

    /**
     * This method updates a tutor 
     *
     * @param updated The id of the tutor to delete.
     * @return bool, true if we could update
     */
    @ApiMethod(name = "deleteTutor", path="deletetutor")
    public ConfirmValue deleteTutor(Tutor updated) {
        // see if the user exists in the database, if so delete them
        ConfirmValue ret = new ConfirmValue();
        ret.setData(false);

        return ret;
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
    public ArrayList<Tutor> getNearestTutors(@Named("subject")String subject, @Named("longitude")double longitude,@Named("latitude") double latitude){

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
    @ApiMethod(name = "verifyUserInfo", path = "verify_user_info")
    public LoginConfirmer verifyUserInfo(@Named("email")String email, @Named("password")String password){
        int validInfo = 2; //0 = student, 1 = tutor, 2 = email fail, 3 = pass fail
        //TODO pull data from database and compare to data
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey("Student", email);
        Entity student = null;
        LoginConfirmer ret = new LoginConfirmer();
        try {
            student = datastore.get(key);
            String pass = (String) student.getProperty("Password");
            if(!(pass.compareTo(password) == 0)){
                ret.setCode(3);
                return ret;
            }
            else {
                ret.setCode(0);
                return ret;
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
                ret.setCode(3);
                return ret;
            }
            else {
                ret.setCode(1);
                return ret;
            }
        }catch(Exception e) {
            ret.setCode(2);
            return ret;
        }
    }

    /**
     * This method logs in a student
     *
     * @param email the email of the user
     * @param password the pw of the user
     * @return Student object associated with login credentials                
     */
    @ApiMethod(name = "userLogIn", path = "user_log_in")
    public Student userLogIn(@Named("email")String email, @Named("password")String password) {
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
    public Tutor tutorLogIn(@Named("email")String email, @Named("password")String password) {
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