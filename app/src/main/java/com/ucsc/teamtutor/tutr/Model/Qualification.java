package com.ucsc.teamtutor.tutr.Model;

/**
 * Created by HP on 1/10/2015.
 */
public class Qualification {
    //This is a very simple object which contains a tutor's qualification level in a certain class
    public String subject;
    public double skill; //0 = incompetant, 1 = proficient, 2 = advanced, 3 = expert

    public Qualification(String sub, double sk) {
        subject = sub;
        skill = sk;
    }
}
