package com.tutr.libtutr.Model;

import java.util.ArrayList;

/**
 * Created by HP on 1/10/2015.
 */
public class Tutor extends Member {
    /*SEAN IF YOU READ THIS:
    Read my changes to the member class.
    Ratings is something that is difficult to put in.  A complex rating system with stars and
      numerical values is not only difficult to input in this time frame but conceptually flawed
      for previously discussed reasons.  I will comment it out.  If we have time we can put in a
      much simpler endorsement system.

     */
    private double hourlyRate; //cost per hour
    /*
    private double rawScore = 0; //the sum of all reviews for this tutor
    private double numberRatings = 0; //this is the number reviews this instructor has received
    private double averageRating;
    */
    private ArrayList<Qualification> qualifications = new ArrayList<>(0);

    //constructors

    public Tutor(){
        super();
    }

    public Tutor(String na, String em, String ph) {
        super(na, em, ph);
    }
    //getters
    public double getHourlyRate() {return hourlyRate;}

    public ArrayList<Qualification> getQualifications() {return qualifications;}
    //setters
    public void setPrice(double price) {
        hourlyRate = price;
    }
    /*
    public void add_rating(double rating) {
        //check to make sure the student has interacted with the tutor before calling this method!!!
        rawScore += rating;
        numberRatings++;
        averageRating = rawScore / numberRatings;
    }

    public String get_rating() {
        if (numberRatings == 0) {
            return "No Ratings Yet!";
        } else {
            return "" + averageRating;
        }
    }

    public double get_numOfRatings() {
        return numberRatings;
    }
    */
    public void changeQualification(String subject, double level) {
        for (int i = 0; i < qualifications.size(); i++) {
            if (qualifications.get(i).subject.equals(subject)) {
                Qualification updated = qualifications.get(i);
                updated.skill = level;
                qualifications.set(i, updated);
                return; //exit the method once we have updated the level of qualification
            }
        }
        //if class wasnt found then we add it
        qualifications.add(new Qualification(subject, level));
    }

    public void removeQualification(Qualification toRemove) {
        if (qualifications.contains(toRemove)) {
            qualifications.remove(toRemove);
        }
    }
}
