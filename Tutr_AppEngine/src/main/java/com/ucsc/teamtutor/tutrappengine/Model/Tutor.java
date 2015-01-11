package com.ucsc.teamtutor.tutrappengine.Model;

import java.util.ArrayList;

/**
 * Created by HP on 1/10/2015.
 */
public class Tutor extends Member {
    private double hourlyRate; //cost per hour
    private double rawScore = 0; //the sum of all reviews for this tutor
    private double numberRatings = 0; //this is the number reviews this instructor has received
    private double averageRating;
    ArrayList<Qualification> qualifications = new ArrayList<>(0);

    //constructor
    public Tutor(String na, String em, String pass, String ph) {
        super(na, em, pass, ph);
    }

    public Tutor(String na, String em, String pass, String sk, String ph) {
        super(na, em, pass, sk, ph);
    }

    public void setPrice(double price) {
        hourlyRate = price;
    }

    public double getPrice() {
        return hourlyRate;
    }

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
