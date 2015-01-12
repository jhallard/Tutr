package com.tutr.libtutr.Model;

/**
 * Created by HP on 1/10/2015.
 */
public class Student extends Member {
    /*SEAN IF YOU READ THIS:
    Read the changes I made to the member class.
    I have commented out classes, it isn't strictly necessary.  I may put it back in if we find
      a way and time to actually read in classes.
    Until then the Student is but a glorified Tutor.  Time interests.
     */
    //variables
    /*
    private ArrayList<String> classes = new ArrayList<>(0); //starts at 0 cause we have no classes
    */
    //constructors
    public Student(String na, String em, String ph) {
        super(na, em, ph);
    }

    public Student(){
        super();
    }

    //methods
    /*
    public void retrieveClasses() {
        //THIS WILL BE CODED TO RETRIEVE CLASSES FROM PIAZZA
    }

    public void addClass(String newClass) {
        if (!classes.contains(newClass)) //make sure we don't clone classes
            classes.add(newClass);
    }

    public void removeClass(String dumpClass) {
        if (classes.contains(dumpClass))
            classes.remove(dumpClass);
    }

    public ArrayList<String> getClasses() {
        return classes;
    }
    */
}
