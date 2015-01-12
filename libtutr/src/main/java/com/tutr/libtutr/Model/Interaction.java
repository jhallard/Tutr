package com.tutr.libtutr.Model;

/**
 * Created by HP on 1/10/2015.
 */
public class Interaction {
    //This is a very simple object which only purpose is to keep tract of how many times each student and tutor/other students has studied with each other
    public double interactions = 0;
    public Member person;

    public Interaction(Member per) {
        person = per;
        interactions = 1;
    }
}
